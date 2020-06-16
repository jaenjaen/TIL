package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SerialAjax")
public class SerialAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private HashMap<String, String> map = new HashMap<>();
      
      @Override
    public void init() throws ServletException {
    	map.put("ajax", "James"); //id,name
    	map.put("encore", "Gosling");
    }
      
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		if(command.equals("register")) {
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			
			out.print(addr+"에 사는"+name+"님의 가입 하셨습니다.");
		}else if(command.equals("idcheck")) {
			String id = request.getParameter("id");
			if(map.get(id)==null) out.print(false); // 아이디가 디비에 없다면 사용 가능
			else out.print(true);
		}
	}

}
