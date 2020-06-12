package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

//defalut가 forwarding
public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String id = req.getParameter("id");
		
		MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
		ModelAndView mv= new ModelAndView();
		mv.setViewName("find_ok");
		mv.addObject("message","Spring FrameWork!!,"+vo.getName());
		return mv;
	}
	
}
