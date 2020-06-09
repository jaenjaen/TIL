package servelt.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Date publish_date = null;
		int price = 0;
		
		//값 받아와서
		String isbn = req.getParameter("isbn1")+"-"+req.getParameter("isbn2")+"-"+req.getParameter("isbn3");
		String title = req.getParameter("title");
		String catalogue = req.getParameter("kinds");
		String nation = req.getParameter("country");
	
		if (req.getParameter("release").equals("")) {
			publish_date = Date.valueOf("9999-12-13");
		}else {
		 publish_date = Date.valueOf(req.getParameter("release"));}
	
		String publisher = req.getParameter("publisher ");
		String author = req.getParameter("writer");
		
		if(req.getParameter("price").equals("")) {
			price = 0;
		}else {
		price = Integer.parseInt(req.getParameter("price"));}
		
		String currency = req.getParameter("unit");
		String desc = req.getParameter("desc");
		
		
		//객체생성
		BookVo book = new BookVo(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, desc);
		System.out.println(book.toString());
		
		
		//dao bizs
		BookDAOimpl dao = BookDAOimpl.getInstance();
		try {
			dao.bookRegister(book);
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("bookRegister SQL오류");
		}
		req.setAttribute("book", book);
		
		//forwarding
		RequestDispatcher dispatcher= req.getRequestDispatcher("book/result.jsp");
		dispatcher.forward(req, res);
	}

}
