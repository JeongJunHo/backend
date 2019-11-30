package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class MemberDAODBImpl implements IMemberDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 닫기 에러");
		}
	}

	@Override
	public boolean memInsert(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into safeFoodMember values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, addr);
			ps.setString(5, tel);
			ps.setString(6, allergy);
			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}

	@Override
	public boolean memUpdate(String id, String pw, String name, String addr, String tel, String allergy) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "";
			if (allergy == null) {
				sql = "update safeFoodMember set pw=?,name=?,addr=?,tel=? where id=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, pw);
				ps.setString(2, name);
				ps.setString(3, addr);
				ps.setString(4, tel);
				ps.setString(5, id);
			} else {
				sql = "update safeFoodMember set pw=?,name=?,addr=?,tel=?,allergy =? where id=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, pw);
				ps.setString(2, name);
				ps.setString(3, addr);
				ps.setString(4, tel);
				ps.setString(5, allergy);
				ps.setString(6, id);
			}
			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}

		return res;
	}

	public ArrayList<MemVo> memList() {
		ArrayList<MemVo> list = new ArrayList<MemVo>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from safeFoodMember";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("addr"),
						rs.getString("tel"), rs.getString("allergy")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public MemVo memInfo(String id) {
		MemVo mem = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from safeFoodMember where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				mem = new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("addr"),
						rs.getString("tel"), rs.getString("allergy"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}

	public boolean memDelete(String id) {
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from safeFoodMember where id =? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}

		return res;
	}

	public boolean isLogin(String id, String pw) {
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from safeFoodMember where id = ? and pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			rs.last();

			int cnt = rs.getRow();
			if (cnt == 1) {
				res = true;
			} else {
				res = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}

	@Override
	public MemVo findId(String name, String tel) {
		MemVo mem = null;
		String id = null;
		String temppw = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select id from safeFoodMember where name = ? and tel = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			rs = ps.executeQuery();
			for (int i = 0; i < 1; i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
				uuid = uuid.substring(0, 10); // uuid를 앞에서부터 10자리 잘라줌.
				// System.out.println(i + ") " +uuid);
				temppw = uuid;
			}
			 System.out.println(temppw);
			while (rs.next()) {
				mem = new MemVo(rs.getString("id"));
				mem.setPw(temppw);
				System.out.println("mem : " + mem);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}

	@Override
	public boolean pwUpdate(String id, String pw) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update safeFoodMember set pw=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, id);
			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		}finally {
			close();
		}
		return res;
	}

}
