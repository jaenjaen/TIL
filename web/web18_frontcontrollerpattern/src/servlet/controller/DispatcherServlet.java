package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/*
 * <servlet>
 * 	<servlet-name>DispatcherServlet</servlet-name>
 * 	<servlet-class>servlet.controller.DispatcherServlet</servelt-class>
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>DispatcherServlet</servlet-name>
 * 	<url-pattern>front.do</url-pattern>
 * </servlet-mapping>
 * 		
 */
@WebServlet(urlPatterns="/front.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청이 어디에서 들어오는 지 확인 command받기
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			register(request,response);
		}
		else if(command.equals("find")) {
			path = find(request,response);
		}
		else if(command.equals("idcheck")) {
			path = idcheck(request,response);
		}else if(command.equals("logout")) {
			path = logout(request,response);
		}
		else if(command.equals("allMember")) {
			path = allMember(request,response);
		}
		else if(command.equals("login")) {
			path = login(request,response);
		}
		else if(command.equals("update")) {
			path = update(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);	
	}

	
	
	
	
	private String update(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//vo 생성
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		//dao리턴
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//biz
		try {
			dao.updateMember(pvo);
		

			//수정 정보를 *세션*에 바인딩
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("updateMember SQL error");
		}
		return path;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo !=null ) {
				System.out.println("A");
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path= "login_result.jsp";
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return path;
	}

	private String allMember(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		}catch(SQLException e) {
			
		}
		return path;
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo") != null) {
			session.invalidate();
		}
		return path;
	}

	private String idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String path = "index.jsp";
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			boolean flag = dao.idExist(id);
			request.setAttribute("flag", flag);
			path = "idcheck.jsp";
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("idexist error****");
		}
		return path;
	}

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}			
		}catch(SQLException e) {
			
		}
		return path;
	}

	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "index.jsp";
		MemberVO pvo  = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_ok.jsp";
			//
			//request.getRequestDispatcher("register_ok.jsp").forward(request, response);
			//response.sendRedirect("AllMember?name="+name);
		}catch(SQLException e) {
			
		}
		return path;
	}

}
