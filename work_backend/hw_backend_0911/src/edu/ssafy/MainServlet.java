package edu.ssafy;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Login.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if (id.equals("ssafy") && pwd.equals("1111")) {
			response.sendRedirect("Result.html");
		} else {
			response.sendRedirect("Login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String hp1 = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String country = request.getParameter("country");
		String pubDate = request.getParameter("pubDate");
		String pub = request.getParameter("pub");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String priceType = request.getParameter("priceType");
		String desc = request.getParameter("desc");

		Writer w = response.getWriter();
		
		w.write("<style>");
		w.write("td{border: 1px solid;}");
		w.write("</style>");
		w.write("<div style='width: 600px; margin: 0 auto;'>");
		w.write("<h1 style='text-align: center;'>입력된 도서 정보</h1>");
		w.write("<table style='border: 1px solid; width: 100%;'>");
		w.write("<tr>");
		w.write("<td colspan='2' style='background: gray; text-align: center;'>");
		w.write("도서 정보");
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서명");
		w.write("</td>");
		w.write("<td>");
		w.write(title);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서번호");
		w.write("</td>");
		w.write("<td>");
		w.write(hp1 + "-" + hp2 + "-" + hp3);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서분류");
		w.write("</td>");
		w.write("<td>");
		w.write(type);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서국가");
		w.write("</td>");
		w.write("<td>");
		w.write(country);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("출판일");
		w.write("</td>");
		w.write("<td>");
		w.write(pubDate);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("출판사");
		w.write("</td>");
		w.write("<td>");
		w.write(pub);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("저 자");
		w.write("</td>");
		w.write("<td>");
		w.write(author);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서가격");
		w.write("</td>");
		w.write("<td>");
		w.write(price + priceType);
		w.write("</td>");
		w.write("</tr>");

		w.write("<tr>");
		w.write("<td style='background: gray;'>");
		w.write("도서설명");
		w.write("</td>");
		w.write("<td>");
		w.write(desc);
		w.write("</td>");
		w.write("</tr>");
		w.write("</table>");
		w.write("<div style='text-align: center;'>");
		w.write("<a href='Book.html'>도서 등록</a>");
		w.write("</div>");
		w.write("</div>");
	}

}
