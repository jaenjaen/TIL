package servelt.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		//기존의 세션 받아오기
		HttpSession session = req.getSession();
		
		//바인딩 된 값이 있다면 그 값 찾아오기
		if(session.getAttribute("vo") != null) {
			MemberVO vo = (MemberVO) session.getAttribute("vo");
			
			//출력
			out.println("<h2>회원정보</h2>");
			out.println("<p> vo:"+vo.toString()+"</p>");
			
			//jsessionid도 출력해서 기존과 같은지 확인
			out.println("<h3>"+session.getId()+"</h3>");
			
			//상품정보를 하나 세션에 다시 바인딩 스트링으로
			String product = "수리쿠션";
			session.setAttribute("product", product);
			
			//네비게이션 <a href='CartServlet'></a>
			out.println("<a href='CartServlet'>장바구니로 이동(세번째 서블릿페이지)</a>");
			
		}
		else {
			out.println("<h3> session에 바인딩 된 객체가 없습니다.</h3>");
			out.println("<a href='login.html'>다시 로그인 하기</a>");
		}
	}

}
