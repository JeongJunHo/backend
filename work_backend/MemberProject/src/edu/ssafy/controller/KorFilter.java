package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class KorFilter
 */
@WebFilter(
		filterName="KorFilter",
		value = "*", 
		initParams= {@WebInitParam(name="kor", value="UTF-8")}
		)
public class KorFilter implements Filter {
	String charset;
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		charset = fConfig.getInitParameter("kor");
	}
	
    /**
     * Default constructor. 
     */
    public KorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("korea 전처리");
		request.setCharacterEncoding(charset);
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("korea 후처리");
	}
}
