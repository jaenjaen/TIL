package servelt.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servelt.model.book.BookDAOimpl;
import servelt.model.book.BookVo;

public class Book extends HttpServlet {
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
		String catalogue = req.getParameter("kinds");
		String nation = req.getParameter("country");
		Date publish_date = req.getParameter("release");
		String publisher = req.getParameter("publisher ");
		String author = req.getParameter("writer");
		int price = Integer.parseInt(req.getParameter("price"));
		String currency = req.getParameter("unit");
		String desc = req.getParameter("desc");
		
		//객체생성
		BookVo book = new BookVo(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, desc);
		System.out.println(book.toString());
		
		
		//dao biz
		BookDAOimpl dao = BookDAOimpl.getInstance();
		dao.bookRegister(book);
		
		//forwarding
		RequestDispatcher dispatcher= req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, res);
	}

}
