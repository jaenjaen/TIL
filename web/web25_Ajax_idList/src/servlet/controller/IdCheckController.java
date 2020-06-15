package servlet.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		boolean flag = MemberDAOImpl.getInstance().idExist(id);
		
		out.print(flag);
		return null;
	}

}
