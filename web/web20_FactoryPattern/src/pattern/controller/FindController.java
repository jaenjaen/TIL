package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.Dao;
import pattern.model.NoteBook;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String path = "find_fail.jsp";
		
		String model = req.getParameter("model");
		Dao dao = Dao.getInstance();
		
		NoteBook notebook = dao.findNoteBook(model);
		req.setAttribute("notebook", notebook);
		path = "find_result.jsp";
		
		return path;
	}	
}
