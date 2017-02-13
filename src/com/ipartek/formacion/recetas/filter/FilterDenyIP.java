package com.ipartek.formacion.recetas.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterDenyIP
 */
@WebFilter("/*")
public class FilterDenyIP implements Filter {


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
		String ip = request.getRemoteAddr( );
        HttpServletResponse httpResp = null;
        httpResp = (HttpServletResponse) response;
 
        	if ("192.168.0.26".equals(ip) || "192.168.0.25".equals(ip)){
        		chain.doFilter(request,response);
        	 
            } else {
            	httpResp.sendError(HttpServletResponse.SC_FORBIDDEN,
                        "That means goodbye forever! " );
            	               
            }
    
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
