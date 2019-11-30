package safefood.dao;

import java.util.ArrayList;

public interface DidFoodDAO {
	public boolean takeFood(String id, int code);
	
	public ArrayList<DidFoodVO> searchAll(String id);

}
