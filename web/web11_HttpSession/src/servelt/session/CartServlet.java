package servelt.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//기존의 세션 받아오기
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		//jssionid , vo, pvo 출력
		out.println("<h2>jSessionId: "+ session.getId() +"</h2>");
		out.println("<h4>"+session.getAttribute("vo")+"</h4>");
		out.println("<h4>"+session.getAttribute("product")+"</h4>");
				
		if(session.getAttribute("vo") != null) {
		//현재 세션에 바인딩 된 정보가 있다면? 세션 죽이기
			session.invalidate();
			out.println("<script>");
			out.println("alert('로그아웃되셨습니다.')");
			out.println("location.href='login.html'");
			out.println("</script>");
		}
		//없으면? 로그인 페이지로
		else {
			res.sendRedirect("login.html");
		}
	}

}
