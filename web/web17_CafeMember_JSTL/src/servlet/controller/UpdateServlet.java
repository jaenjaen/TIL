package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//폼값 받아오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//vo 생성
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		//dao리턴
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//biz
		try {
			dao.updateMember(pvo);
		

			//수정 정보를 *세션*에 바인딩
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
			}
			
			//네비게이션 update_result.jsp
			request.getRequestDispatcher("update_result.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("updateMember SQL error");
		}

	}

}
