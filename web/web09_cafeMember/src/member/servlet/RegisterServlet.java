package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOimpl;
import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberVO member = null;
		
		//폼값 받아와서
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		//vo생성
		if(address==null) {
			member = new MemberVO(id, password, name, "-");
		}
		else {
			member = new MemberVO(id, password, name, address);
		}

		//dao
		MemberDAOimpl dao = MemberDAOimpl.getInstance();
		
		//biz
		dao.registerMember(member);
		ArrayList<MemberVO> members = dao.showAllMembers();
	
		//네비게이션
		req.setAttribute("members", members);
		req.getRequestDispatcher("allShow.jsp").include(req, res);
		
		//뒤에 로그인 달기
		PrintWriter out = res.getWriter();
		out.println("<br><h3>"+id+"님이 회원가입 하셨습니다.</h3>");
	}

}
