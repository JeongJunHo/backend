package safefood.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.dao.FoodVO;
import safefood.dao.RankVO;
import safefood.service.FoodService;
import safefood.service.FoodServiceImpl;

/**
 * Servlet implementation class FoodServlet
 */
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodService foodServiceImpl = new FoodServiceImpl();

	@Override
	public void init() throws ServletException {
		super.init();
		foodServiceImpl.loadData(this.getServletContext().getRealPath("/"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("index")) {
			index(request, response);
		} else if (action.equals("bestintakeinfo")) {
			bestIntakeInfo(request, response);
		} else if (action.equals("productinfo")) {
			productInfo(request, response);
		} else if (action.equals("productdetail")) {
			productDetail(request, response);
		} else if (action.equals("fitcombsearch")) {
			fitCombSearch(request, response);
		} else if (action.equals("materialusechart")) {
			materialUseChart(request, response);
		} else if (action.equals("allergyfood")) {
			allergyFood(request, response);
		}
	}


	private void allergyFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginid");

		HashMap<String, List<FoodVO>> map = foodServiceImpl.allergyFood(id);
		request.setAttribute("map", map);

		request.getRequestDispatcher("allergyfood.jsp").forward(request, response);
	}

	private void materialUseChart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, Integer> map = foodServiceImpl.materialAccumulator();
		request.setAttribute("map", map);

		request.getRequestDispatcher("materialusechart.jsp").forward(request, response);
	}

	private void fitCombSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginid");
		String strCal = request.getParameter("searchCalory");
		Integer maxCalory = 0;
		if (strCal != null && strCal != "") {
			maxCalory = Integer.parseInt(strCal);
		}

		List<List<FoodVO>> combSearchList = foodServiceImpl.combinationSearch(maxCalory, id);

		request.setAttribute("list", combSearchList);
		request.getRequestDispatcher("fitcombsearch.jsp").forward(request, response);
	}

	private void productDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String id = (String) request.getSession().getAttribute("loginid");

		FoodVO foodVO = foodServiceImpl.search(code, id);
		request.setAttribute("food", foodVO);
		request.getRequestDispatcher("productdetail.jsp").forward(request, response);
	}

	private void productInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		List<FoodVO> list = foodServiceImpl.searchAll(searchType, searchText);
		foodServiceImpl.searchCnt(searchText);
		ArrayList<RankVO> rList = foodServiceImpl.searchRank();
		request.setAttribute("rList", rList);
		request.setAttribute("list", list);
		request.getRequestDispatcher("productinfo.jsp").forward(request, response);
	}

	private void bestIntakeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FoodVO> list = foodServiceImpl.searchBest();
		request.setAttribute("list", list);
		request.getRequestDispatcher("bestintakeinfo.jsp").forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodVO> list = foodServiceImpl.searchBestIndex();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
