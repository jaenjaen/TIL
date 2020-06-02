package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderServlet
 */
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//로직은 이 곳에 
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body bgcolor = 'skyblue'>");
		out.println("<h2>Header Information</h2>");
		
		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			String value = req.getHeader(key);
			out.println(key+": "+value+"<br>");
		}
		
		out.println("<hr>");
		
		String id = req.getParameter("id");
		String id2 = req.getParameter("i");
		String pass2 = req.getParameter("p");
		
		out.println(id+" "+id2+" "+pass2);
		
		out.println("</body></html>");
		out.close();
	}

}
