package controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemDetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		
		String path = "index.jsp";
		int id = Integer.parseInt(req.getParameter("id"));
		Item item =null;
		ItemDao dao = ItemDao.getInstance();
		
		try {
			//업데이트하고
			dao.countView(id);
			//받아오기
			item = dao.getItem(id);
			
			//오늘 본 상품 정보 추가
			//1) 쿠키 + 2)브라우저로보내기
			Cookie cookie = new Cookie("fruitshop"+id, item.getUrl());
			cookie.setMaxAge(24*60*60);
			res.addCookie(cookie);
			
			path = "itemdetail.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("item", item);
		return new ModelAndView(path,false);
	}

}
