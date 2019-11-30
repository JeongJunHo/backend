package safefood.dao;

import java.util.ArrayList;

public interface RankDAO {

	public void searchCnt(String sname);
	
	public ArrayList<RankVO> searchRank();
}
