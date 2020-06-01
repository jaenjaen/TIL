package servlet.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WordExercise
 */
public class WordEncoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서
		 * 2.받은 값을 수정한 후
		 * 3.다시 웹브라우저 전송
		 */
		
		String wName = request.getParameter("word");
		wName = wName+"update severside";
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2> Client에서 보내온 값..<br>");
		out.println(wName+"</h2></body></html>");
		
		out.close();
	}

}
