package safefood.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.dao.BoardVo;
import safefood.dao.MemVo;
import safefood.service.BoardServiceImpl;
import safefood.service.IBoardService;
import safefood.service.IMemberService;
import safefood.service.MemberServiceImpl;

@WebServlet("/board.do")
@WebInitParam(name = "aa", value = "Hello")
public class BoardServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IBoardService Bser = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("action => " + action);

		if (action.equals("insertboard")) {
			insertBoard(request, response);
		} else if (action.equals("listboard")) {
			listBoard(request, response);
		} else if (action.equals("updateboard")) {
			updateBoard(request, response);
		} else if (action.equals("deleteboard")) {
			deleteBoard(request, response);
		} else if (action.equals("infoboard")) {
			infoBoard(request, response);
		} else if (action.equals("infoupdateboard")) {
			infoUpdateBoard(request, response);
		}

		// } else if (action.equals("fileup")) {
//			fileUp(request, response);
//		}
	}

	private void infoUpdateBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("bnum");
		String title = request.getParameter("btitle");
		BoardVo board = Bser.infoUpdateBoard(Integer.parseInt(num), title);
		if (board != null) {
			request.setAttribute("board", board);
			request.getRequestDispatcher("notice_update.jsp").forward(request, response);
		} else {

		}
		
	}

	private void infoBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("btitle");

		BoardVo board = Bser.infoBoard(title);
		if (board != null) {
			request.setAttribute("board", board);
			request.getRequestDispatcher("notice_view.jsp").forward(request, response);
		} else {

		}
	}

	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("loginid");
		String num = request.getParameter("bnum");
		boolean res = Bser.deleteBoard(id, Integer.parseInt(num));
		if (res) {
			response.sendRedirect("board.do?action=listboard");
		} else {
			
		}
	}

	private void updateBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("loginid");
		String num = request.getParameter("bnum");
		String title = request.getParameter("btitle");
		String document = request.getParameter("bdocument");
		boolean res = Bser.updateBoard(id, Integer.parseInt(num), title, document);
		if (res) {
			response.sendRedirect("board.do?action=listboard"); // 게시판리스트
		} else {
			response.sendRedirect("notice_insert.jsp");
		}

	}

	private void insertBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String id = (String) request.getSession().getAttribute("loginid");
		String title = request.getParameter("btitle");
		String document = request.getParameter("bdocument");
		boolean res = Bser.insertBoard(id, title, document);
		if (res) {
			response.sendRedirect("board.do?action=listboard");// 게시판 리스트로
		} else {
			response.sendRedirect(""); // 딱히 필요 없을듯.
		}

	}

	private void listBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<BoardVo> list = Bser.listBoard();
		request.setAttribute("blist", list);
		request.getRequestDispatcher("notice_list.jsp").forward(request, response);// 게시판 리스트페이지
	}

}
