package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet(description = "Servelt para aprender a usar la peticiones GET y POST", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * PrintWriter out = response.getWriter(); out.append(
		 * "peticion GET: <br>"); out.append("parametros: <br>"); out.append(
		 * "Nombre: " + request.getParameter("nombre") + "<br>");
		 */

		// recoger paramteros
		String pNombre = request.getParameter("nombre");

		// TODO validar parametros

		// enviar atributos a JSP
		request.setAttribute("[GET]nombre", pNombre.toUpperCase());

		// request interna (forward) la JSP, ir a la JSP
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger paramteros
		String pNombre = request.getParameter("nombre");

		// enviar atributos a JSP
		request.setAttribute("nombre", pNombre.toLowerCase());

		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
	}

}
