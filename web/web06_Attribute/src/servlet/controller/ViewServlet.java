package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext con;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//Attribute에 바인딩 된 데이터 받아와서
		con = getServletContext();
		MemberVO member= (MemberVO)con.getAttribute("member");
		String name = member.getName();
		int age = member.getAge();
		String addr = member.getAddr();
		
		
		//웹브라우저로 출력
		out.println("<html><body>");
		out.println("<hr>");
		out.println("<h2>"+name+"님의 회원정보 입니다.</h2>");
		out.println("<li>이 름:"+name+"</li>");
		out.println("<li>나 이:"+age+"살</li>");
		out.println("<li>주 소:"+addr+"</li>");
		out.println("<hr>");
		out.println("</body></html>");
		out.close();
	}
}
