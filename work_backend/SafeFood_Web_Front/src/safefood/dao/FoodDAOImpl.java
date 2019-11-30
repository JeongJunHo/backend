package safefood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import safefood.util.FoodSaxParser;

public class FoodDAOImpl implements FoodDAO {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	public FoodDAOImpl() {
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
	 * 필요
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 개수
	 */
	public int foodCount() {
		String sql = "select count(code) as cnt from food";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
//			st.setString(1, "%" + bean.getWord() + "%");

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<FoodVO> searchAll(String searchType, String searchText) {
		List<FoodVO> finds = new LinkedList<FoodVO>();
		String sql = "select * from food";
		boolean check = false;
		if (searchType != null && !searchType.trim().equals("") && searchText != null
				&& !searchText.trim().equals("")) {
			sql += " where " + searchType + " like ?";
			check = true;
		}
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			if (check) {
				st.setString(1, "%" + searchText + "%");
			}

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FoodVO f = new FoodVO();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material")); // 이녀석
				f.setImg(rs.getString("img"));
				f.setHit(rs.getInt("hit"));

				finds.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return finds;
	}

	@Override
	public List<FoodVO> searchAll_calory(String calory) {
		List<FoodVO> finds = new LinkedList<FoodVO>();
		String sql = "select * from food where calory <= ?";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, calory);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FoodVO f = new FoodVO();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setHit(rs.getInt("hit"));

				finds.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return finds;
	}

	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 * 
	 * @param code 검색할 식품 코드
	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public FoodVO search(int code) {
		// 코드에 맞는 식품 검색하여 리턴
		String sql = "select * from food where code = ?";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, code);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FoodVO f = new FoodVO();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setHit(rs.getInt("hit"));

				return f;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return null;
	}

	/**
	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
	 * 
	 * @return
	 */
	public List<FoodVO> searchBest() {
		List<FoodVO> finds = new LinkedList<FoodVO>();
		String sql = "select * from food order by hit desc";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FoodVO f = new FoodVO();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setHit(rs.getInt("hit"));

				finds.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return finds;
	}

	public List<FoodVO> searchBestIndex() {
		List<FoodVO> finds = new LinkedList<FoodVO>();
		String sql = "select * from food order by hit desc limit 0,6";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				FoodVO f = new FoodVO();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setHit(rs.getInt("hit"));

				finds.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return finds;
	}

	public static void print(List<FoodVO> foods) {
		for (FoodVO food : foods) {
			System.out.println(food);
		}
	}

	public void insertFood(FoodVO f) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into food(code, name, supportpereat, calory, carbo, protein, fat, sugar, natrium, chole, fattyacid, transfat, maker, material, img) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, f.getCode());
			st.setString(2, f.getName());
			st.setDouble(3, f.getSupportpereat());
			st.setDouble(4, f.getCalory());
			st.setDouble(5, f.getCarbo());
			st.setDouble(6, f.getProtein());
			st.setDouble(7, f.getFat());
			st.setDouble(8, f.getSugar());
			st.setDouble(9, f.getNatrium());
			st.setDouble(10, f.getChole());
			st.setDouble(11, f.getFattyacid());
			st.setDouble(12, f.getTransfat());
			st.setString(13, f.getMaker());
			st.setString(14, f.getMaterial());
			st.setString(15, f.getImg());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
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

	@Override
	public void updateHit(int code, int hit) {
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update food set hit=? where code=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, hit);
			st.setInt(2, code);

			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
