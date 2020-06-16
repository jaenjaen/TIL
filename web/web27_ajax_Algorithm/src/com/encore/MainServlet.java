package com.encore;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("wordCount")) {
			wordCount(request, response);
		} else if (action.equals("kickCount")) {
			kickCount(request, response);
		}
	}// process()

	private void wordCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			System.out.println("wordCount 진입");
			
		    String str = request.getParameter("str");
		    System.out.println(str);
		    
		    Count c = new Count();
		    String word = c.execute(str);
		    System.out.println(word);
		    
		    request.setAttribute("result", word);
		    request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	private void kickCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("kickCount 진입");
		String fname=request.getParameter("fname");
		
		//contextpath의 실제경로
		String path=request.getServletContext().getRealPath("/res");   // 중요합니다..채워넣어보세요
		
		System.out.println(path);
		File f=new File(path, fname);
		
		int result=Kickboard.execute(f);
	
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);	
	}
}
