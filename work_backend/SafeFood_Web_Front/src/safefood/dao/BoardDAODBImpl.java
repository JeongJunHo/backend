package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAODBImpl implements IBoardDAO {
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
	public boolean boardUpdate(String id, int num, String title, String document) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update boardManager set title=?, document=? where id=? and num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, document);
			ps.setString(3, id);
			ps.setInt(4, num);
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
	public boolean boardDelete(String id, int num) {
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from boardManager where id=? and num=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, num);
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
	public boolean boardInsert(String id, String title, String document) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into boardManager(id, title, document) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, title);
			ps.setString(3, document);
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
	public ArrayList<BoardVo> boardList() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from boardManager";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BoardVo(rs.getInt("num"), rs.getString("id"), rs.getString("title"),
						rs.getString("document"), rs.getInt("hit")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	@Override
	public BoardVo boardInfo(String title) {
		BoardVo board = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from boardManager where title=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while (rs.next()) {
				board = new BoardVo(rs.getInt("num"), rs.getString("id"), rs.getString("title"),
						rs.getString("document"), rs.getInt("hit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return board;
	}

	@Override
	public BoardVo boardUpdateInfo(int num, String title) {
		BoardVo board = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from boardManager where title=? and num=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				board = new BoardVo(rs.getInt("num"), rs.getString("id"), rs.getString("title"),
						rs.getString("document"), rs.getInt("hit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return board;
	}



}
