package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count = 0;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		//ajax01_count.html
		/*
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		out.print(id+"  "+pass+"<br> <b>Count : "+ ++count+"</b>");*/
		
		//ajax02_encoding.html
		String nick = req.getParameter("nick");
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e){}
		System.out.println(nick);
		out.print(nick);
	}


}
