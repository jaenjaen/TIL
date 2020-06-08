package servelt.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		//세션 받아온다 
		// 인자값에  boolean이 들어가는 이유? 새로만들면 true 기존에 있는거 갖다 쓰면 false (안써도 됨 서버가 request뜯어서 쿠키확인함)
		HttpSession session = req.getSession();
		
		//jsessionid 값 콘솔 브라우저로 찍어본다.
		System.out.println(session.getId());
		out.println("<h3> jSessionId: "+session.getId()+"</h3><br><br>");
		
		//폼에 입력된 값 가지고 vo 객체 생성 membervo
		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		
		MemberVO pvo = new MemberVO(id, pass, "관리자", "서울시");
		
		//세션바인딩
		session.setAttribute("vo", pvo);
		System.out.println("member binding***");
		
		//네비게이션(A태그로 연결) a href='ProductServlet'
		out.println("<a href='ProductServlet'> ProductServlet으로 이동");
	}

}
