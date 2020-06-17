package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Enter Company Controller");
		
		String result = "<ul><li> Tomato System </li>"
				+ "<li> NC Soft </li>"
				+ "<li> KAKAO </li>"
				+ "<li> Naver </li>"
				+ "<li> Watcha </li></ul>";
		
		req.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
