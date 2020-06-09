package servelt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servelt.model.book.BookDAOimpl;
import servelt.model.book.BookVo;

public class ShowAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		BookDAOimpl dao = BookDAOimpl.getInstance();
		ArrayList<BookVo> books = new ArrayList<>();
		
		try {
			books = dao.showAllbook();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("showAllbook sql 오류");
		}
		req.setAttribute("books", books);
		req.getRequestDispatcher("book/showAllBook.jsp").forward(req, res);
	}

}
