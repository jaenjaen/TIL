package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/*
 * 회원 가입하면 정보를 바탕으로 VO 생성 이를 ArrayList에 추가 
 * 회원 가입을 5명이 하면 vo 5개 만들어짐
 * ArrayList를 ServletContext에 넣음
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>()); //자체적으로 동기화처리
    private ServletContext context;
	
	public void init() throws ServletException {
		/*context = getServletContext();
		System.out.println("ServletContext의 주소: "+context);
		
		context.setAttribute("list", list);
		System.out.println("ServletContext에 카페 입장명단을 바인딩합니다.*****");*/
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("list", list);
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String addr = req.getParameter("addr");
		
		System.out.println("폼값 가져오기*****");
		
		//vo객체생성
		MemberVO vo = new MemberVO(name,age,addr);
		System.out.println("객체생성*****");
		
		list.add(vo);
		System.out.println("Vo list에 저장*****"); //servlet Context에 binding된 list에 vo가 저장
		
		out.println(name+"님이 카페에 입장하셨습니다.<p>");
		System.out.println(name+" 카페 입장");
		

		//out.println("<a href=viewMember.jsp?name="+name+"> Member보기로 이동합니다. </a>");
		
		RequestDispatcher rdp = req.getRequestDispatcher("viewMember.jsp");
		rdp.forward(req, res); // 페이지 이동
		
		//out.println("페이지 이동시켰습니다."); forward로 이동하면 제어권이 다시 돌아오지 않음
		out.close();
	}

}
