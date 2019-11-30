package edu.ssafy.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.dao.ProductDBManager;
import edu.ssafy.dao.ProductVO;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDBManager manager = new ProductDBManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("listProduct")) {
			String searchName = request.getParameter("searchName");
			String searchPrice = request.getParameter("searchPrice");
			ArrayList<ProductVO> list = manager.selectAll(searchName, searchPrice);
			request.setAttribute("list", list);
			request.getRequestDispatcher("listProduct.jsp").forward(request, response);
		}else if (action.equals("registerProduct")) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			String memo = request.getParameter("memo");
			String reg_mb_id = (String) request.getSession().getAttribute("loginId");
			
			boolean result = manager.insert(code, name, price, stock, memo, reg_mb_id);
			
			String message = new String();
			String url = URLEncoder.encode("product.do?action=listProduct", "UTF-8");
			if(result) {
				message = "등록 성공";
			}else {
				message = "등록 실패";
			}
			message = URLEncoder.encode(message, "UTF-8");
			response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
		}else if(action.equals("infoProduct")) {
			String code = request.getParameter("code");
			
			ProductVO productVO = manager.selectOne(code);
			request.setAttribute("product", productVO);
			request.getRequestDispatcher("infoProduct.jsp").forward(request, response);
		}else if(action.equals("updateProduct")) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			String memo = request.getParameter("memo");
			String up_mb_id = (String) request.getSession().getAttribute("loginId");
			
			boolean result = manager.update(code, name, price, stock, memo, up_mb_id);
			
			String message = new String();
			String url = URLEncoder.encode("product.do?action=listProduct", "UTF-8");
			if(result) {
				message = "수정 성공";
			}else {
				message = "수정 실패";
			}
			message = URLEncoder.encode(message, "UTF-8");
			response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
		}else if(action.equals("deleteProduct")) {
			String code = request.getParameter("code");
			
			boolean result = manager.delete(code);
			
			String message = new String();
			String url = URLEncoder.encode("product.do?action=listProduct", "UTF-8");
			if(result) {
				message = "삭제 성공";
			}else {
				message = "삭제 실패";
			}
			message = URLEncoder.encode(message, "UTF-8");
			response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
		}else if(action.equals("selectOne_json")) {
			String code = request.getParameter("code");
			
			ProductVO productVO = manager.selectOne(code);
			
			request.setAttribute("product", productVO);
			
			/*이런식으로 던져도 됩니다.*/
//			response.setContentType("application/json");
//			response.getWriter().print("{\"code\" : " + productVO.getCode() + "}");
			request.getRequestDispatcher("json_product.jsp").forward(request, response);
		}
	}
	
}
