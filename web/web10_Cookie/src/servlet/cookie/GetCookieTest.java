package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클라이언트가 다시 요청할 때 브라우저에 저장된 쿠키들을 받아온다
 * 받아온 쿠키중에서 쿠키의 값과 이름을 출력해본다. 
 */
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie[] cks = req.getCookies();
		PrintWriter out = res.getWriter();
		
		for(Cookie c: cks) {
			out.println("<h2>"+c.getName()+"------"+c.getValue()+"</h2>");
		}
	}

}
