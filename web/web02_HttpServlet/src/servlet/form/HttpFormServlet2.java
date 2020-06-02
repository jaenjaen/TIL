package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpFormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h2>값을 모두 받아옵니다.</h2>");
		Enumeration<String> en = req.getParameterNames(); // key반환
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			out.println("<li>"+name+":"+req.getParameter(name)+"</li></br>");
		}
		
		String str[] = req.getParameterValues("menu");
		out.println("<b>당신이 좋아하는 음식들 입니다.</b><br>");
		String menu="";
		for(int i=0; i<str.length;i++) {
			menu += str[i]+" ";
		}
		out.println(menu);
		out.close();
	}

}
