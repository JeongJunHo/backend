package safefood.dao;

import java.util.ArrayList;

public interface EatFoodDAO {
	public void insert(EatFoodVO eatFoodVO);
	public void delete(int num);
	public ArrayList<EatFoodVO> selectAll(String id);
}
