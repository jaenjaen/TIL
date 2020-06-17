package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieController implements Controller{
	private ArrayList<String> cookies;
	
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String path = "index.jsp";
		
		//쿠키set
		/*Cookie cookie = new Cookie(name, value);*/
		//
		return null;
	}

}
