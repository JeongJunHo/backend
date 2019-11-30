package com.ssafy.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		Product product = null;
		ArrayList<Product> list = null;
		
		writer.write("[입력]<br/>");
		productDAO.insert("A01", "상품1", 1000, 100, "상품1번입니다.", "jjh");
		productDAO.insert("A02", "상품2", 2000, 200, "상품2번입니다.", "jjh");
		productDAO.insert("A03", "상품3", 3000, 300, "상품3번입니다.", "jjh");
		list = productDAO.selectAll(null, null);
		for (Product p : list) {
			writer.write(p.toString() + "<br/>");
		}
		writer.write("<br/>");
		
		writer.write("[수정]<br/>");
		productDAO.update("A01", "상품1 수정", 999, 90, "수정입니다.", "aaaaa");
		list = productDAO.selectAll(null, null);
		for (Product p : list) {
			writer.write(p.toString() + "<br/>");
		}
		writer.write("<br/>");
		
		writer.write("[삭제]<br/>");
		productDAO.delete("A02");
		list = productDAO.selectAll(null, null);
		for (Product product2 : list) {
			writer.write(product2.toString() + "<br/>");
		}
		writer.write("<br/>");
		
		writer.write("[조회 = A03]<br/>");
		product = productDAO.selectOne("A03");
		writer.write(product.toString() + "<br/>");
		writer.write("<br/>");
	}

}
