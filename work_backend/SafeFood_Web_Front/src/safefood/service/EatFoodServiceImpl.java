package safefood.service;

import java.util.ArrayList;

import safefood.dao.EatFoodDAO;
import safefood.dao.EatFoodDAOImpl;
import safefood.dao.EatFoodVO;

public class EatFoodServiceImpl implements EatFoodService {
	EatFoodDAO eatFoodDAO = new EatFoodDAOImpl();

	@Override
	public void insert(EatFoodVO eatFoodVO) {
		eatFoodDAO.insert(eatFoodVO);
	}

	@Override
	public void delete(int num) {
		eatFoodDAO.delete(num);
	}

	@Override
	public ArrayList<EatFoodVO> selectAll(String id) {
		return eatFoodDAO.selectAll(id);
	}
	
}
