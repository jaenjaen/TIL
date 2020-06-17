package controller;

import java.sql.SQLException;

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
			path = "itemdetail.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("item", item);
		return new ModelAndView(path,false);
	}

}
