package safefood.service;

import java.util.ArrayList;

import safefood.dao.EatFoodVO;

public interface EatFoodService {
	public void insert(EatFoodVO eatFoodVO);
	public void delete(int num);
	public ArrayList<EatFoodVO> selectAll(String id);
}
