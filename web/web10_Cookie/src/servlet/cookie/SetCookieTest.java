package servlet.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 쿠키생성
 * 생성한 쿠키를 웹브라우저로 보냄 (resposse.addcookie(c)
 * */
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		Date now = new Date();
		String id = "ENCORE";
		
		//1.쿠키생성
		Cookie c1 = new Cookie("NOW", "2020-06-0810:47");
		Cookie c2 = new Cookie("id",id);
		
		//쿠키의 유효시간 지정 하루로 지정
		c1.setMaxAge(24*60*60);
		c2.setMaxAge(0);//쿠키 사용하지 않겠다는 소리
		
		//3. 쿠키 넘기기
		res.addCookie(c1);
		res.addCookie(c2);
		
		//4.페이지 이동(GetCookieTest)
		res.sendRedirect("GetCookieTest");
		
		}

}
