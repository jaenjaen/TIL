package servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//한글처리
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		//위에 처리한 작업의 내용이 서버상의 다음번 컴포넌트에게 계속 적용되기 위한 작업(안하면 이 다음 컴포넌트에 위의 작업이 진행되지 않음)
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
