package safefood.dao;

import java.util.ArrayList;

public interface IBoardDAO {
	
	public boolean boardUpdate(String id, int num, String title, String document);

	public boolean boardDelete(String id, int num);

	public boolean boardInsert(String id, String title, String document);

	public ArrayList<BoardVo> boardList();

	public BoardVo boardInfo(String title);
	
	public BoardVo boardUpdateInfo(int num, String title);

}
