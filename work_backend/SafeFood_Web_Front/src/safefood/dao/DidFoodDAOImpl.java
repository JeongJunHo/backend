package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DidFoodDAOImpl implements DidFoodDAO {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 닫기 에러");
		}
	}

	@Override
	public boolean takeFood(String id, int code) {
		// TODO Auto-generated method stub
		boolean res = false;
		String str="";
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select id from dibfood where id =? and code = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setInt(2, code);
			rs = st.executeQuery();
			while (rs.next()) {
				str = rs.getString("id");
			}
			if (id.equals(str)) {
				res = false;
			} else {
				sql = "insert into dibfood values(?,?)";
				st = conn.prepareStatement(sql);
				st.setString(1, id);
				st.setInt(2, code);
				st.executeUpdate();
				res = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	@Override
	public ArrayList<DidFoodVO> searchAll(String id) {
		// TODO Auto-generated method stub
		ArrayList<DidFoodVO> list = new ArrayList<DidFoodVO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from where id =?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				list.add(new DidFoodVO(rs.getString("id"),rs.getInt("code")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	

}
