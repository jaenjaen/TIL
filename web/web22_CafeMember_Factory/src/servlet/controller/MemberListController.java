package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		
		String path = "index.jsp";
		
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			req.setAttribute("list", list);
			path = "allView.jsp";
		}catch(SQLException e) {
			
		}
		mv = new ModelAndView(path);
		return mv;
	}
	
}
