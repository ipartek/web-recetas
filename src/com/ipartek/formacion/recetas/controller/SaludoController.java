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
@WebServlet(description = "Servlet para aprender a usar las peticiones GET y POST", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * PrintWriter out = response.getWriter(); out.append("Peticion GET:\n"
		 * ); out.append("Bienvenido Sr/Sra:\n"); out.append("Nombre: " +
		 * request.getParameter("nombre") + "\n"); out.append("Apellidos: " +
		 * request.getParameter("ape1") + " " + request.getParameter("ape2"));
		 */

		try {

			// Recoger parametros.
			String pNombre = request.getParameter("nombre");
			String aApellido = request.getParameter("ape1");
			String a2Apellido = request.getParameter("ape2");

			// TODO validar parametros.

			// Enviar atributos a JSP.
			request.setAttribute("nombre", pNombre.toUpperCase());
			request.setAttribute("ape1", aApellido.toUpperCase());
			request.setAttribute("ape2", a2Apellido.toUpperCase());

		} catch (Exception e) {
			request.setAttribute("error", "Se produjo un error, lo sentimos.");

			e.printStackTrace();
		} finally {
			// Request interna (forward) a la JSP, ir a la JSP.
			String vistaJSP = "ejercicios/primer-controlador.jsp";
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		// Recoger parametros.
		String pNombre = request.getParameter("nombre");
		String aApellido = request.getParameter("ape1");
		String a2Apellido = request.getParameter("ape2");

		// TODO validar parametros.

		// Enviar atributos a JSP.
		request.setAttribute("nombre", pNombre.toLowerCase());
		request.setAttribute("ape1", aApellido.toUpperCase());
		request.setAttribute("ape2", a2Apellido.toUpperCase());

		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
	}

}
