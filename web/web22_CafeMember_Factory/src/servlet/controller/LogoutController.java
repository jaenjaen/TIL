package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		String path = "index.jsp";
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("vo") != null) {
			session.invalidate();
		}
		mv = new ModelAndView(path);
		return mv;
	}
	
}
