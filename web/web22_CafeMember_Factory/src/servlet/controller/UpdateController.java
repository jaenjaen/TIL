package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		String path = "index.jsp";
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		//vo 생성
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		//dao리턴
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//biz
		try {
			dao.updateMember(pvo);
		

			//수정 정보를 *세션*에 바인딩
			HttpSession session = req.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("updateMember SQL error");
		}
		mv = new ModelAndView(path);
		return mv;
	}
	
}
