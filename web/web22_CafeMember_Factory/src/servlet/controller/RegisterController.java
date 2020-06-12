package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String path = "index.jsp";
		MemberVO pvo  = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_ok.jsp";
			//
			//request.getRequestDispatcher("register_ok.jsp").forward(request, response);
			//response.sendRedirect("AllMember?name="+name);
		}catch(SQLException e) {
			
		}
		mv = new ModelAndView(path);
		
		return mv;
	}

}
