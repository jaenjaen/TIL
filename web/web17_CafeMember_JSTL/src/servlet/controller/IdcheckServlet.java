package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*폼값받아서
		 * DAO리턴 BIZ호출 Boolean
		 * 바인딩
		 * 네비게이션 idcheck.jsp
		 */
		
		String id = request.getParameter("id");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			boolean flag = dao.idExist(id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("idcheck.jsp").forward(request, response);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("idexist error****");
		}
	}

}
