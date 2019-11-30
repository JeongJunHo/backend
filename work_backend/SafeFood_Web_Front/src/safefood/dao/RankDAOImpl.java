package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankDAOImpl implements RankDAO {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	@Override
	public void searchCnt(String sname) {
		// TODO Auto-generated method stub
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from searchlist where sname = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, sname);
			rs = st.executeQuery();
			rs.last();
			int row = rs.getRow();
			System.out.println(row);
			if (row > 0) {
				int tmp = rs.getInt("count");
				tmp = tmp + 1;
				sql = "update searchlist set count = ? where sname = ?";
				st = conn.prepareStatement(sql);
				st.setInt(1, tmp);
				st.setString(2, sname);
				st.executeUpdate();
			} else if (row == 0 && sname != null) {
				sql = "insert into searchlist values(?,?)";
				st = conn.prepareStatement(sql);
				st.setString(1, sname);
				st.setInt(2, 1);

				st.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<RankVO> searchRank() {
		// TODO Auto-generated method stub
		ArrayList<RankVO> list = new ArrayList<RankVO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from searchlist";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new RankVO(rs.getString("sname"), rs.getInt("count")));
			}
			Collections.sort(list, new Comparator<RankVO>() {

				@Override
				public int compare(RankVO o1, RankVO o2) {
					// TODO Auto-generated method stub
					return o2.getCount() - o1.getCount();
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
