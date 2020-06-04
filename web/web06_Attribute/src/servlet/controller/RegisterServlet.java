package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext con;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//양방향 한글처리
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//폼값 받아
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String addr = req.getParameter("addr");
		
		//vo객체생성
		MemberVO member = new MemberVO(name,age,addr);
		
		//dao리턴 (했다치고)
		//비지니스로칙호출(했다치고)
		//객체바인딩 servletcontext에
		con = getServletContext();
		con.setAttribute("member", member);
		
		//페이지 이동
		//out.println("<a href='ViewServlet'>ViewServlet 결과 확인하기</a>");
		out.println("<a href='result.jsp'>결과 확인하기</a>");
		out.close();
	}

}
