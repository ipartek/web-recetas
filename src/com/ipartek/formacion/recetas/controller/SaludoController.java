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
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.append("peticion GET: <br>"); out.append("parametros: <br>");
		 * out.append("Nombre: " + request.getParameter("nombre") + "<br>");
		 * out.append("Apellido1: " + request.getParameter("ape1") + "<br>");
		 * out.append("Apellido2: " + request.getParameter("ape2") + "<br>");
		 */

		// recoger parametros
		String pNombre = request.getParameter("nombre");
		String pApellido1 = request.getParameter("ape1");
		String pApellido2 = request.getParameter("ape2");

		// TODO validar parametros

		// enviar atributos a JSP
		request.setAttribute("nombre", pNombre.toUpperCase());
		request.setAttribute("ape1", pApellido1);
		request.setAttribute("ape2", pApellido2);

		// request interna (forward) a la JSP, ir a la JSP
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros
		String pNombre = request.getParameter("nombre");
		String pApellido1 = request.getParameter("ape1");
		String pApellido2 = request.getParameter("ape2");

		// TODO validar parametros

		// enviar atributos a JSP
		request.setAttribute("nombre", pNombre.toLowerCase());
		request.setAttribute("ape1", pApellido1);
		request.setAttribute("ape2", pApellido2);

		// request interna (forward) a la JSP, ir a la JSP
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);

	}

}
