package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public String createController(HttpServletRequest req, HttpServletResponse res) {
		return find(req,res);
	}

	private String find(HttpServletRequest req, HttpServletResponse res) {

		String path = "find_fail.jsp";
		
		String id = req.getParameter("id");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		try {
			MemberVO member = dao.findByIdMember(id);
			System.out.println(member);
			req.setAttribute("member", member);
			path = "find_ok.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FindController / findByIdMember Error");
		}
		
		return path;
	}
	
}
