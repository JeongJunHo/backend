package edu.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProductDBManager {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
	
	public boolean insert(String code, String name, int price, int stock, String memo, String reg_mb_id) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into webproduct (code,name,price,stock,memo,reg_mb_id,reg_date) values(?,?,?,?,?,?,now())";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			ps.setString(5, memo);
			ps.setString(6, reg_mb_id);
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
	
	public ArrayList<ProductVO> selectAll(String searchName, String searchPrice){
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from webproduct where 1";
			if(searchName != null && !searchName.equals("")) {
				sql += " and name like '%" + searchName + "%'";
			}
			if(searchPrice != null && !searchPrice.equals("")) {
				sql += " and price <= " + searchPrice;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int stock = rs.getInt(4);
				String memo = rs.getString(5);
				String reg_mb_id = rs.getString(6);
				Date reg_date = null;
				try {
					reg_date = sdf.parse(rs.getString(7));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String up_mb_id = rs.getString(8);
				Date up_date = null;
				try {
					if(rs.getString(9) != null) {
						up_date = sdf.parse(rs.getString(9));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				list.add(new ProductVO(code, name, price, stock, memo, reg_mb_id, reg_date, up_mb_id, up_date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public ProductVO selectOne(String code) {
		ProductVO productVO = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from webproduct where code = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int stock = rs.getInt(4);
				String memo = rs.getString(5);
				String reg_mb_id = rs.getString(6);
				Date reg_date = null;
				try {
					reg_date = sdf.parse(rs.getString(7));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String up_mb_id = rs.getString(8);
				Date up_date = null;
				try {
					if(rs.getString(9) != null) {
						up_date = sdf.parse(rs.getString(9));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				productVO = new ProductVO(code, name, price, stock, memo, reg_mb_id, reg_date, up_mb_id, up_date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return productVO;
	}
	
	public boolean update(String code, String name, int price, int stock, String memo, String up_mb_id) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update webproduct set name = ?, price = ?, stock = ?, memo = ?, up_mb_id = ?, up_date=now() where code = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setInt(3, stock);
			ps.setString(4, memo);
			ps.setString(5, up_mb_id);
			ps.setString(6, code);
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
	
	public boolean delete(String code) {
		boolean isOk = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from webproduct where code = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
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
}
