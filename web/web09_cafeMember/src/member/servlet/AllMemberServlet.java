package member.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOimpl;
import servlet.model.MemberVO;

public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MemberDAOimpl dao = MemberDAOimpl.getInstance();
		
		ArrayList<MemberVO> members = dao.showAllMembers();
		req.setAttribute("members", members);
		
		req.getRequestDispatcher("allShow.jsp").forward(req, res);
	}

}
