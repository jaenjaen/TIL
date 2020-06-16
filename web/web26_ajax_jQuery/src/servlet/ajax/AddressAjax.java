package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddressAjax")
public class AddressAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap map = new HashMap();
	
	//디비 연결 대신 Map을 이용해 각 선수들의 address를 맵핑
	public void init() throws ServletException {
		map.put("이용규", "대전");
		map.put("김태균", "대전");
		map.put("류현진", "Canada");
		map.put("푸이그", "LA");
		map.put("오타니", "LA");
		map.put("커쇼", "NY");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		
		out.print(map.get(name));
	}

}
