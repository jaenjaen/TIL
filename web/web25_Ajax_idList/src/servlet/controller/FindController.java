package servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		out.print(vo.getName()+" "+vo.getAddress());
		return null;
	}
	
}
