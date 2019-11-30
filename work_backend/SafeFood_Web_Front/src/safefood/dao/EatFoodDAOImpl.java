package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EatFoodDAOImpl implements EatFoodDAO {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void insert(EatFoodVO eatFoodVO) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into eatfood(id, code, cnt, eatdate) values(?,?,?,now())";
			st = conn.prepareStatement(sql);
			st.setString(1, eatFoodVO.getId());
			st.setInt(2, eatFoodVO.getCode());
			st.setInt(3, eatFoodVO.getCnt());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(int num) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from eatfood where num = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, num);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public ArrayList<EatFoodVO> selectAll(String id) {
		ArrayList<EatFoodVO> list = new ArrayList<EatFoodVO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select a.num, a.id, a.code, a.cnt, a.eatdate, (select name from food where a.code=code) as foodName from eatfood a order by eatdate desc";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String searchId = rs.getString(2);
				int code = rs.getInt(3);
				int cnt = rs.getInt(4);
				Date eatdate = null;
				try {
					eatdate = sdf.parse(rs.getString(5));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String foodName = rs.getString(6);
				
				list.add(new EatFoodVO(num, searchId, code, cnt, eatdate, foodName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("닫기 실패");
		}
	}
}
