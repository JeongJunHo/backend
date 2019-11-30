package safefood.service;

import java.util.ArrayList;

import safefood.dao.DidFoodDAO;
import safefood.dao.DidFoodDAOImpl;
import safefood.dao.DidFoodVO;

public class DidFoodServiceImpl implements DidFoodService {
	DidFoodDAO dfd = new DidFoodDAOImpl();
	@Override
	public boolean takeFood(String id, int code) {
		// TODO Auto-generated method stub
		boolean res = dfd.takeFood(id, code);
		return res;
	}
	@Override
	public ArrayList<DidFoodVO> searchAll(String id) {
		// TODO Auto-generated method stub
		ArrayList<DidFoodVO> list = dfd.searchAll(id);
		return list;
	}

	
}

