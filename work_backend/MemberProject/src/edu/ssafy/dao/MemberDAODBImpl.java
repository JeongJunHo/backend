package edu.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAODBImpl implements IMemberDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB Close Error");
		}
	}
	
	public boolean memInsert(String id, String pw, String name, String tel, String gender) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into webmember values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
			ps.setString(5, gender);
			ps.executeUpdate();
			isOk = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		} finally {
			close();
		}
		
		return isOk;
	}
	
	public ArrayList<MemVo> memList(){
		ArrayList<MemVo> list = new ArrayList<MemVo>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from webmember";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("tel"), rs.getString("gender")));
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
			String sql = "select * from webmember where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				mem = new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("tel"), rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return mem;
	}
	
	public boolean memUpdate(String id, String pw, String name, String tel, String gender) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update webmember set pw = ?, name = ?, tel = ?, gender = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, name);
			ps.setString(3, tel);
			ps.setString(4, gender);
			ps.setString(5, id);
			ps.executeUpdate();
			isOk = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		} finally {
			close();
		}
		
		return isOk;
	}
	
	public boolean memDelete(String id) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from webmember where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			isOk = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		} finally {
			close();
		}
		
		return isOk;
	}
	
	public boolean isLogin(String id, String pwd) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select count(*) as cnt from webmember where id = ? and pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next() && rs.getInt("cnt") > 0) {
				isOk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isOk = false;
		} finally {
			close();
		}
		
		return isOk;
	}
}
