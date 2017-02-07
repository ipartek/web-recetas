package com.ipartek.formacion.recetas.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.recetas.pojo.Usuario;

/**
 * Servlet Filter implementation class FilterZonaSegura
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, asyncSupported = true, 
							description = "Filtro para comprobar todos las peticiones que accedan a la zona segura, deben estar logeados en sesion.", 
							urlPatterns = { "/zona-segura/*" })
public class FilterZonaSegura implements Filter {

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

		HttpServletRequest httpRequest = ((HttpServletRequest) request);

		HttpSession session = httpRequest.getSession(true);
		Usuario user = (Usuario) session.getAttribute("usuario");

		// Usuario Logeado en Session
		if (user != null) {
			// TODO comprobar que existe en BBDD

			System.out.println("Usuario logeado en session " + user.toString());
			// pass the request along the filter chain
			chain.doFilter(request, response);

			// Usuario debe logearse antes de acceder
		} else {

			StringBuffer url = httpRequest.getRequestURL();
			String uri = httpRequest.getRequestURI();
			String ctx = httpRequest.getContextPath();
			String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";

			((HttpServletResponse) response).sendRedirect(base + "login.jsp");
		}

		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
