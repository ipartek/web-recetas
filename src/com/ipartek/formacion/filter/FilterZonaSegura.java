package com.ipartek.formacion.filter;

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

import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet Filter implementation class FilterZonaSegura
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, asyncSupported = true, description = "Filtro para comprobar que todas las peticiones que accedan a la zona segura ,esten logeados en session", urlPatterns = {
				"/zona-segura/*" })
public class FilterZonaSegura implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("pasamos por el filtro");
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		HttpSession session = httpRequest.getSession(true);
		Usuario user = (Usuario) session.getAttribute("user");
		// user logeado en sesion
		if (user != null) {
			// TODO comprobar que existe en DDBB
			System.out.println("Esta logeado");
			// usuario debe logearse
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			StringBuffer url = httpRequest.getRequestURL();
			String uri = httpRequest.getRequestURI();
			String ctx = httpRequest.getContextPath();
			String base = url.substring(0, (url.length() - uri.length()) + ctx.length());
			String login = getURLWithContextPath(httpRequest) + "/login.jsp";

			((HttpServletResponse) response).sendRedirect(base + "/login.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	}

}
