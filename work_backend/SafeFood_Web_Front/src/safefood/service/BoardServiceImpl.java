package safefood.service;

import java.util.ArrayList;

import safefood.dao.BoardDAODBImpl;
import safefood.dao.BoardVo;
import safefood.dao.IBoardDAO;
import safefood.dao.MemVo;

public class BoardServiceImpl implements IBoardService {
	IBoardDAO BAO = new BoardDAODBImpl();

	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateBoard(String id, int num, String title, String document) {
		boolean res = BAO.boardUpdate(id, num, title, document);
		return res;
	}

	@Override
	public boolean deleteBoard(String id, int num) {
		boolean res = BAO.boardDelete(id, num);
		return res;
	}

	@Override
	public boolean insertBoard(String id, String title, String document) {
		boolean res = BAO.boardInsert(id, title, document);
		return res;
	}

	@Override
	public ArrayList<BoardVo> listBoard() {
		ArrayList<BoardVo> list = BAO.boardList();
		return list;
	}

	@Override
	public BoardVo infoBoard(String title) {
		BoardVo bao = BAO.boardInfo(title);
		return bao;
	}

	@Override
	public BoardVo infoUpdateBoard(int num, String title) {
		BoardVo bao = BAO.boardUpdateInfo(num, title);
		return bao;
	}

}
