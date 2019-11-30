package edu.ssafy.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCP {
	private static DataSource ds;
	static {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/ssafy/mysql");
			System.out.println("lookup success");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("lookup fail");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		if(conn != null) {
			System.out.println("연결 성공");
		}else {
			System.out.println("연결 실패");
		}
		return conn;
	}
}
