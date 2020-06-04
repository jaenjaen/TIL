package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");

		//입력된 정보 받기
		String id= req.getParameter("id");
		String pass= req.getParameter("pass");
		
		PrintWriter out = res.getWriter();
		
		
		out.println("<html><body>");
		//out.println("<h2>A진입</h2>");
		out.println("<h3 align=center>"+id+"님이 로그인 되었습니다.!!<br><br>");
	
		out.println("<a href=book.html>도서 등록<br>");
		out.println("<a href=login.html>로그아웃");
		out.println("</body></html>");
		out.close();
	}
}
