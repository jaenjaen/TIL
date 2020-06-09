package servlet.controller;

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
	
		//네비게이션
		res.sendRedirect("AMS?id="+id);
	}

}
