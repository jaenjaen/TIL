package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpFormServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    /*
     * service (req,rsp)
     * was가 위 함수를 calling
     * 클라이언트가 요청하면 호출!!!!! 
     * request resopose 객체 생성
     * 쓰레드(service함수 시작됨)
     * 여까지 싹다 WAS가 관장
     */
    
	protected void service(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		/*
		 * 한글처리 양방향
		 * 폼에 입력된 모든 데이타 받아서
		 * 웹브라우저에 출력 
		 */
		
		//char encoding printwriter return 받기 전에 해야함 밑에 나오면 한글깨짐
		req.setCharacterEncoding("UTF-8"); //get으로 객체를 받으면 필요가 없음. post 받으면 servlet객체에 담겨옴
		rsp.setContentType("text/html;charset=utf8");
		
		
		String id = req.getParameter("userId");
		String pass = req.getParameter("userPass");
		String[] menu = req.getParameterValues("menu");
		
		PrintWriter out = rsp.getWriter();
		
		
		out.println("<html><body><h2>");
		out.println("넘겨받은 값 </h2>");
		out.println("<p>고객님의 아이디:"+id+"</p>");
		out.println("<p>고객님의 비밀번호:"+pass+"</p>");
		out.println("<h5>고객님이 선호하는 메뉴</h5>");
		
		for(int i=0; i<menu.length;i++) {
			out.print(menu[i]+" ");
		}
		
		out.println("</body></html>"); // 닫아야하는데 생략해도 돌아가긴 함 사실 html,body를 생략해도 되긴 함
		out.close();
	}

}
