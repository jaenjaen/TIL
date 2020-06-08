package servelt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servelt.model.user.UserDAOimpl;
import servelt.model.user.UserVo;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		//입력된 정보 받기
		String id= req.getParameter("id");
		String pass= req.getParameter("pass");

		//dao biz
		UserDAOimpl dao = UserDAOimpl.getInstance();
		try {
			UserVo user = dao.login(id, pass);
			if(user != null) {
				HttpSession session = req.getSession();
				session.setAttribute("vo", user);
				req.getRequestDispatcher("loginSucess.jsp").forward(req, res);
			}
			else {
				res.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			System.out.println("Main ServletDB연결 에러*****");
		}

	}
}
