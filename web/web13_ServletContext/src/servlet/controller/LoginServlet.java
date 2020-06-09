package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOimpl;
import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//1.폼값을 받아옴
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		//2.DAO리턴 biz로직 호출
		MemberDAOimpl dao = MemberDAOimpl.getInstance();
		try {
			MemberVO rvo = dao.login(id, password);
			
			//3.세션 받아오기
			HttpSession session = req.getSession();
			
			if(rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: "+session.getId());
				req.getRequestDispatcher("login_result.jsp").forward(req, res);
			}
		} catch (SQLException e) {
			System.out.println("loginServlet DB Error*****");
		}
	}

}
