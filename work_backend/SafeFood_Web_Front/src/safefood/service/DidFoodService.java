package safefood.service;

import java.util.ArrayList;

import safefood.dao.DidFoodVO;

public interface DidFoodService {
	public boolean takeFood(String id, int code);
	
	public ArrayList<DidFoodVO> searchAll(String id);

}
