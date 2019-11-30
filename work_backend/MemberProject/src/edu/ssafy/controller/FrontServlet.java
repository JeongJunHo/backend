package edu.ssafy.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import edu.ssafy.dao.MemVo;
import edu.ssafy.dao.MemberDAODBImpl;
import edu.ssafy.service.IMemberService;
import edu.ssafy.service.MemberServiceImpl;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet(
		value = "/main.do",
		initParams = {@WebInitParam(name = "aa", value = "test")}
		)
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAODBImpl man = new MemberDAODBImpl();
	IMemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String str = getInitParameter("aa");
//		System.out.println(str);
//		
//		String msg = (String) request.getSession().getAttribute("server");
//		System.out.println(msg);
//		request.getSession().setAttribute("server", "hello");
//		request.getSession().invalidate();
//		
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null) {
//			for (Cookie cookie : cookies) {
//				System.out.println(cookie.getName() + " " + cookie.getValue());
//			}
//		}
		
//		Cookie c = new Cookie("c", "맛있다");
//		Cookie java = new Cookie("java", "더맛있다");
//		response.addCookie(c);
//		response.addCookie(java);
		
		String action = request.getParameter("action");
		
//		System.out.println("action : " + action);
		
		if(action.equals("registermem")) {
			registerMem(request, response);
		}else if (action.equals("listmem")) {
			listMem(request, response);
		}else if (action.equals("infomem")) {
			infoMem(request, response);
		}else if (action.equals("updatemem")) {
			updateMem(request, response);
		}else if (action.equals("deletemem")) {
			deleteMem(request, response);
		}else if (action.equals("login")) {
			login(request, response);
		}else if (action.equals("logout")) {
			logout(request, response);
		}else if (action.equals("fileup")) {
			fileUp(request, response);
		}
	}
	

	private void fileUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String path = request.getServletContext().getRealPath("/upload/");
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		int size = 1024 * 1024 * 5; // 5M
		MultipartRequest req = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		String name = req.getParameter("pname");
		String ofile = req.getOriginalFileName("pfile");
		String sfile = req.getFilesystemName("fileup");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write("<h1>fileupload success 성공</h1>");
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = new String();
		if(memberService.login(id, pwd)) {
			request.getSession().setAttribute("loginId", id);
			url = "home.jsp";
		}else {
			url = "index.jsp?res=f";
		}
		response.sendRedirect(url);
	}

	private void deleteMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		boolean result = memberService.deleteMem(id);
		//화면 출력
		String message = new String();
		String url = URLEncoder.encode("main.do?action=listmem", "UTF-8");
		if(result) {
			message = "삭제 성공";
		}else {
			message = "삭제 실패";
		}
		message = URLEncoder.encode(message, "UTF-8");
		response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
	}

	private void updateMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");
		boolean result = memberService.updateMem(id, pw, name, tel, gender);
		// 화면처리
		String message = new String();
		String url = URLEncoder.encode("main.do?action=listmem", "UTF-8");
		if(result) {
			message = "수정 성공";
		}else {
			message = "수정 실패";
		}
		message = URLEncoder.encode(message, "UTF-8");
		response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
	}

	private void infoMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		MemVo mem = memberService.infoMem(id);
		if(mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("infoMem.jsp").forward(request, response);
		}else {
			String message = URLEncoder.encode("정보를 가져오지 못했습니다.", "UTF-8");
			String url = URLEncoder.encode("main.do?action=listmem", "UTF-8");
			response.sendRedirect("result.jsp?message=" + message + "&url=" + url);
		}
	}

	private void listMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemVo> list = memberService.listMem();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listMem.jsp").forward(request, response);
	}

	private void registerMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String tel = request.getParameter("ptel");
		String gender = request.getParameter("pgender");
		//업무 처리
		boolean res = memberService.registerMem(id, pw, name, tel, gender);
		//출력 처리
		String str = new String();
		if(res) {
			//request.setAttribute("res", "등록 되었습니다.");
			str = "등록 되었습니다.";
			
		}else {
			//request.setAttribute("res", "등록 실패 되었습니다.");
			str = "등록 실패 되었습니다.";
		}
//		request.getRequestDispatcher("result.jsp").forward(request, response);
		String encode = URLEncoder.encode(str, "UTF-8");
		String loginId = (String) request.getSession().getAttribute("loginId");
		String url = loginId != null ? "main.do?action=listmem" : "index.jsp";
		url = URLEncoder.encode(url, "UTF-8");
		response.sendRedirect("result.jsp?message=" + encode + "&url=" + url);
	}

}
