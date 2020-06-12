package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		String path = "index.jsp";
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = req.getSession();
			
			if(rvo !=null ) {
				System.out.println("A");
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path= "login_result.jsp";
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		mv = new ModelAndView(path);
		return mv;
	}
	
}
