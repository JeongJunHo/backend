package safefood.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.dao.MemVo;
import safefood.service.IMemberService;
import safefood.service.MemberServiceImpl;

@WebServlet("/main.do")
@WebInitParam(name = "aa", value = "Hello")
public class FrontServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IMemberService mSer = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("action => " + action);

		if (action.equals("registermem")) {
			registerMem(request, response);
		} else if (action.equals("listmem")) {
			listMem(request, response);
		} else if (action.equals("infomem")) {
			infoMem(request, response);
		} else if (action.equals("updatemem")) {
			updateMem(request, response);
		} else if (action.equals("deletemem")) {
			deleteMem(request, response);
		} else if (action.equals("login")) {
			login(request, response);
		} else if (action.equals("logout")) {
			logout(request, response);
		} else if (action.equals("findId")) {
			findId(request, response);
		} else if (action.equals("allergymaterialrank")) {
			allergyMaterialRank(request, response);
		} 
		// } else if (action.equals("fileup")) {
//			fileUp(request, response);
//		}
	}


	private void allergyMaterialRank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = mSer.allergyMaterialRank(); // 리스트 불러오기..
		request.setAttribute("map", map);
		request.getRequestDispatcher("allergy_material.jsp").forward(request, response);
		
	}

	private void findId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		// 엄무처리
		MemVo id = mSer.findId(name, tel);
		System.out.println(id);
		String text = new String();
		response.setContentType("text/html; charset=UTF-8");
		if (id != null) {
			String temppw = id.getPw();
			mSer.updatePw(id.getId(), id.getPw());
			String t = "임시비밀번호로 로그인 후 비밀번호를 변경해 주세요.";
			response.getWriter().print(t+" \n"+id.getId() + " \n" + id.getPw());
		} else {
			text = "아이디를 찾을 수 없습니다.";
			response.getWriter().print(text);
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("food.do?action=index");// 로그아웃하면 메인페이지로.
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");

		if (mSer.login(id, pw)) {
			request.getSession().setAttribute("loginid", id); // 로그인한 아이디 세션으로 등록.
			response.sendRedirect("food.do?action=index"); // 로그인을 했따면 메인페이지로.
		} else {
			response.sendRedirect("SignUp.jsp");// 실패 했따면 그대로 로그인 페이지로.
		}
	}

	private void deleteMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		// 엄무처리
		boolean mem = mSer.deleteMem(id);
		// 화면 출력
		if (mem) {
			response.sendRedirect("food.do?action=index"); // 회원정보를 삭제했다면 회원정보페이지로.
		} else {

		}
	}

	private void updateMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String addr = request.getParameter("paddr");
		String tel = request.getParameter("ptel");
		String[] allergy = request.getParameterValues("pallergy");
		String alStr = new String();
		if (allergy != null) {
			for (int i = 0; i < allergy.length - 1; i++) {
				alStr += allergy[i] + ",";
			}
			alStr += allergy[allergy.length - 1];
		}

		// 엄무처리
		boolean res = mSer.updateMem(id, pw, name, addr, tel, alStr);
		if (res) {
			// 화면처리
			response.sendRedirect("main.do?action=infomem&pid=" + id); // 회원 정보를 수정 했따면 회원정보 리스트로.
		} else {

		}

	}

	private void infoMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		// 엄무처리
		MemVo mem = mSer.infoMem(id);
		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("updatepersonalinfo.jsp").forward(request, response);
		} else {

		}

	}

	private void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 엄무처리
		ArrayList<MemVo> list = mSer.listMem(); // 리스트 불러오기..
		request.setAttribute("list", list);
		request.getRequestDispatcher("updatepersonalinfo.jsp").forward(request, response);
	}

	private void registerMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 처리
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String addr = request.getParameter("paddr");
		String tel = request.getParameter("ptel");
		String[] allergy = request.getParameterValues("pallergy");
		String alStr = new String();
		if (allergy != null) {
			for (int i = 0; i < allergy.length - 1; i++) {
				alStr += allergy[i] + ",";
			}
			alStr += allergy[allergy.length - 1];
		}
		// 업무처리
		boolean res = mSer.registerMem(id, pw, name, addr, tel, alStr);
		// 출력처리
		if (res) {
			response.sendRedirect("food.do?action=index"); // 등록완료되면 로그인페이지로
		} else {
			response.sendRedirect("SignUp.jsp"); // 등록실패이므로 그대로 회원가입 페이지.
		}
	}

}
