package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("ItemListController 진입");
		String path = "index.jsp";
		ArrayList<Item> list = new ArrayList();
		
		///get Cookie
		Cookie[] cookies = req.getCookies();
		ArrayList<String> fruits = new ArrayList<>();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				if(c.getName().startsWith("fruitshop")) {
					fruits.add(c.getValue());
				}
			}
		}
		
		req.setAttribute("fruits", fruits);
		
		//biz
		try {
			list = ItemDao.getInstance().getAllItem();
			req.setAttribute("list", list);
			path = "itemlist.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("ItemListController 오류");
		}
		
		return new ModelAndView(path, false);
	}

}
