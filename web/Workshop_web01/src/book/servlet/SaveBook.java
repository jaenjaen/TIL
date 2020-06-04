package book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.BookVo;

public class SaveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//값 받아와서
		String isbn = req.getParameter("isbn1")+"-"+req.getParameter("isbn2")+"-"+req.getParameter("isbn3");
		String title = req.getParameter("title");
		String kinds = req.getParameter("kinds");
		String country = req.getParameter("country");
		String release = req.getParameter("release");
		String publisher = req.getParameter("publisher ");
		String writer = req.getParameter("writer");
		String price = req.getParameter("price")+req.getParameter("unit");
		String desc = req.getParameter("desc");
		
		//객체생성
		BookVo book = new BookVo(isbn, title, kinds, country, release, publisher, writer, price, desc);
		System.out.println(book.toString());
		req.setAttribute("book", book);
		
		//forwarding
		RequestDispatcher dispatcher= req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, res);
	}

}
