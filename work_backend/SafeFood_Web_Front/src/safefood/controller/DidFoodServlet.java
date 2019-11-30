package safefood.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.dao.DidFoodVO;
import safefood.service.DidFoodService;
import safefood.service.DidFoodServiceImpl;

/**
 * Servlet implementation class DidFoodServlet
 */
@WebServlet("/didfood.do")
public class DidFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DidFoodService didFoodServiceImpl = new DidFoodServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DidFoodServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("takefood")) {
			takeFood(request, response);
		} else if (action.equals("searchall")) {
			searchAll(request, response);
		}
	}

	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("loginid");
		ArrayList<DidFoodVO> list = didFoodServiceImpl.searchAll(id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("didfoodinfo.jsp").forward(request, response);
		
	}

	private void takeFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("loginid");
		int code = Integer.parseInt(request.getParameter("code"));

		boolean res = didFoodServiceImpl.takeFood(id, code);
		String str = "";
		if (res) {
			str = "찜목록에 추가되었습니다.";
		} else {
			str = "이미 존재하는 상품입니다.";
		}
		String encode = URLEncoder.encode(str, "utf-8");
		response.sendRedirect("food.do?action=productinfo&res=" + encode);

	}

}
