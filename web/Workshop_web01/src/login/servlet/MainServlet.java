package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//encoding
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		//입력된 정보 받기
		String id= req.getParameter("id");
		String pass= req.getParameter("pass");

		PrintWriter out = res.getWriter();
		
		out.println("<html><body align=center>");
		//out.println("<h2>A진입</h2>");
		//아이디 체크
		//맞으면 LoginSuccess.java 클릭하도록
		if(id.equals("encore") && pass.equals("1234")) {
			//out.println("<h2>B진입</h2>");
			out.println("<h3>로그인에 성공하셨습니다.</h3>");
			out.println("<a href=LoginSuccess?id="+id+"&& pass="+pass+"> 로그인 성공 페이지");
		}
		//아니면 LoginError.java클릭할 수 있도록
		else {
			//out.println("<h2>C진입</h2>");
			out.println("<h3>로그인에 실패하셨습니다.</h3>");
			out.println("<a href=LoginError?id="+id+"&& pass="+pass+"> 로그인 실패 페이지");
		}
		
		out.println("</body></html>");
		out.close();
	}

}
