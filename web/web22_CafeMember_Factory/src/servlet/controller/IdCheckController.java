package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		String id = req.getParameter("id");
		String path = "index.jsp";
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			boolean flag = dao.idExist(id);
			req.setAttribute("flag", flag);
			path = "idcheck.jsp";
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("idexist error****");
		}
		mv = new ModelAndView(path);
		return mv;
	}
	
}
