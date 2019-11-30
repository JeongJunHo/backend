package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//파라미터 처리
		String name = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		//로직처리
		String str = new String();
		System.out.println(name + " " + passwd);
		if(name.equals("ssafy")&&passwd.equals("ssafy")) {
//			str = "<h1>connected id : " + name + "<br> passwd : " + passwd + "</h1>";
//			response.sendRedirect("success.html");
			String res = "접속하신 " + name + "는 로그인 되었습니다.";
			request.setAttribute("res", res);
		}else {
//			str = "<h1>connected fail id : " + name + "<br> passwd : " + passwd + "</h1>";
			String res = "접속하신 " + name + "는 로그인 되지 않았습니다.";
			request.setAttribute("res", res);
		}
		//결과처리
//		response.getWriter().write(str);
//		response.flushBuffer();
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
