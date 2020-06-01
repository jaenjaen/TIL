package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Response;

public class GenericServletTest2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello GenericTest2");
		out.println("</h2></body></html>");
		
		out.close();
	}

}

/*
 * Servlet Instance Mapping info --  was가 알아야함 why? WAS makes a Servlet Object.
 * FQCN :  servlet.generic.GenericServletTest2
 * server 내부이름 매핑: GenericServletTest2
 * 
 * 클라이언트 url매핑:GS2
 * */