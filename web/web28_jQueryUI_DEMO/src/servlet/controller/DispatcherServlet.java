package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//hidden 값으로 들어온 요청 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String command = req.getParameter("command");
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		ModelAndView mv = null;
	
		try {
			mv = controller.handle(req, res);
			path = mv.getPath();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("****ERROR****");
		}
		if (mv !=null ) {
			if(!mv.isRedirect()) req.getRequestDispatcher(path).forward(req, res);
			else res.sendRedirect(path);
		}
	}

}
