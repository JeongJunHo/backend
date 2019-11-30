package safefood.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.dao.EatFoodVO;
import safefood.service.EatFoodService;
import safefood.service.EatFoodServiceImpl;

/**
 * Servlet implementation class EatFoodServlet
 */
@WebServlet("/eatfood.do")
public class EatFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EatFoodService eatFoodServiceImpl = new EatFoodServiceImpl();
       
    public EatFoodServlet() {
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

		if (action.equals("insertaction")) {
			insertAction(request, response);
		}else if (action.equals("eatfoodinfo")) {
			list(request, response);
		}else if (action.equals("deleteaction")) {
			deleteAction(request, response);
		}
	}

	private void deleteAction(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		eatFoodServiceImpl.delete(num);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginid");
		
		ArrayList<EatFoodVO> list = eatFoodServiceImpl.selectAll(id);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("eatfoodinfo.jsp").forward(request, response);
	}

	private void insertAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("loginid");
		int code = Integer.parseInt(request.getParameter("code"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		EatFoodVO eatFoodVO = new EatFoodVO();
		eatFoodVO.setId(id);
		eatFoodVO.setCode(code);
		eatFoodVO.setCnt(cnt);
		
		eatFoodServiceImpl.insert(eatFoodVO);
		
		response.sendRedirect("food.do?action=productdetail&code=" + code);
	}
	
	
}
