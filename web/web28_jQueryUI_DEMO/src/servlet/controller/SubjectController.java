package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Enter SubjectController");
		
		//biz logic+결과리턴
		String result=" Algorithm | Big Data | Deep Learning | Restful API | Vue.js ";
		
		req.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
