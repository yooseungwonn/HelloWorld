package himedia.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private static Logger logger = Logger.getLogger(EncodingFilter.class.getSimpleName());
	private static String encoding = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[EncodingFilter] init");
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// 출력을 위한 객체 얻어오기
		PrintWriter out = resp.getWriter();
		out.println("<h6>Encoding Filter 작용 전</h6>");
		
		// 실제 필터가 처리하는 내용
		logger.info("[EncodingFilter] doFilter");
		req.setCharacterEncoding(encoding); // 요청 정보의 인코딩 실행
		resp.setContentType("text/html"); // 응답 정보의 타입
		resp.setCharacterEncoding(encoding); // 응답 정보의 인코딩
		
		chain.doFilter(req, resp); // 요청 처리 종료 후 다음 필터로 연결
		
		out.println("<h6>Encoding Filter 작용 후</h6>");
		
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//Filter.super.destroy();
		logger.info("[EncodingFilter] destroy");
	}


}
