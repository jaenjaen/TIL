package servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String ch = req.getParameter("choose");
		System.out.println(ch);
		
		//check박스를 선택하지 않으면 error로 이동
		if(ch==null) {
			res.sendRedirect("error/error.html");
		}
		//그렇지 않은 경우 forwarding으로 내용 전달
		else {
			//바인딩 안해도 됨
			req.getRequestDispatcher("redirect2.jsp").forward(req, res);
		}
	}

}
