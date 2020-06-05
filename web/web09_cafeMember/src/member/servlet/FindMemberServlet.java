package member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOimpl;
import servlet.model.MemberVO;


public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//값 받아와서
		String id = req.getParameter("id");
		
		//dao
		MemberDAOimpl dao = MemberDAOimpl.getInstance();
		
		//biz
		MemberVO member = dao.findByIdMember(id);
		
		//member return not null
		if (member !=null) {
			req.setAttribute("member", member);
			req.getRequestDispatcher("find_ok.jsp").forward(req, res);
			}
		//null
		else {
			req.getRequestDispatcher("find_fail.jsp").forward(req, res);
		}
	}
}
