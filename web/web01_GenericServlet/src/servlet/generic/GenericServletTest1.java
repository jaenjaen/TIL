package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest1 extends GenericServlet {

	/* 
	 * client가 요청하면 호출되는 메소드임
	 * 클라이언트의 요청정보를 ServletRequest에 담아 저장 -- command
	 * 요청 후에는 ServletRespose에 응답할 정보를 담는다.  -- result
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		//가정- 요청을 받음 printWrite를 얻어내서 println으로 응답
		//response for request (to browser)
		//응답과 관련된 것이기 때문에 리스폰스 객체의 메소드를 사용해야함
		PrintWriter out= res.getWriter();
		out.println("<html><body bgcolor='skyblue'>"); //브라우저로 응답
		out.println("<h2>Hello! Generic Servlet<h2>");
		out.println("</body></html>");
		
		out.close();
	}

}

//http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1