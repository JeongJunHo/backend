package safefood.service;

import java.util.ArrayList;

import safefood.dao.BoardVo;
import safefood.dao.MemVo;

public interface IBoardService {
	public boolean updateBoard(String id, int num, String title, String document); // 게시판 수정?

	public boolean deleteBoard(String id, int num); // 글 삭제

	public boolean insertBoard(String id, String title, String document); // 글 쓰기 

	public ArrayList<BoardVo> listBoard(); // (공지게시판 메인화면.)
	
	public BoardVo infoBoard(String title);
	
	public BoardVo infoUpdateBoard(int num, String title);
}
