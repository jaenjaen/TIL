package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * cotroller logic 공식 
 폼값받아서
(VO객체생성)
memberDAO 리턴받고
비지니스 로직 호출 (**중요**)
(3번의 결과 값 attribute에 바인딩)
네비게이션*/

public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("진입");
		
		//폼값받아서
		String id = req.getParameter("id");
		//memberDAO 리턴받고
		//비지니스 로직 호출
		//3번의 결과 값 attribute에 바인딩
		req.setAttribute("id", id);
		//네비게이션
		//req.getRequestDispatcher("resultView.jsp").forward(req, res);
		
		req.getRequestDispatcher("includeTest.jsp").include(req,res);
		PrintWriter out = res.getWriter();
		out.println("Forwarding에서는 이곳으로 응답이 돌아오지 않음.");
	}

}

/*requestDispatcher에는 forward방식과 include 방식 페이지 존재
 * 1. forward방식
 * forward하려는 페이지로 현재 서블릿의 전권을 가지고 서버상에서 다이렉트로 이동
 * 제어권이 완전히 이동하는 jsp페이지로 가버리기 때문에 다시 서블릿으로 되돌아오지 않음
 * 그렇기 때문에 서블릿에서 PrintWirter 객체를 사용할 일이 전혀 없음. 응답이 이곳에서 이뤄지지 않는 다는 뜻.
 * 
 * 응답의 내용은 jsp이지만
 * 출력된 결과창의 주소를 확인하면 전권을 가지고 이동했기 때문에 forwarding이 일어난 서블릿 주소가 뜨는 것을 확인할 수 있다.
 * 
 ----------------------------------------------------------------------------------
 *
 * 2. Include 방식
 * Servlet에 PrintWriter객체를 이용하려 하려면 include방식으로 페이지를 이동해야 함 
 * include에 연결된 페이지에 모든 내용을 가지고 다시 servlet으로 돌아오기 때문에
 * include 다음 줄의 출력 내용들을 모두 다 응답한다.
 * 
 * 둘 다 서버상에서 직접 다른 페이지를 호출하는 방식이기 때문에 페이지의 이동 속도가 빠르다
 * 브라우저를 거치지 않는 다는 점이 중요하다. 서버상에서 바로 이동
 * 모든 페이지 연결 방식의 80%이상이 forward로 이루어짐
 * 그렇기 때문에 servletrequest객체 바인딩을 잘 다뤄야 한다.
 */
