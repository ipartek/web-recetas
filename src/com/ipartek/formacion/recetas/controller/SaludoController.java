package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Servlet peticiones GET y POST", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// recoger paramteros
			String pNombre = request.getParameter("nombre");
			String pApe1 = request.getParameter("ape1");
			String pApe2 = request.getParameter("ape2");

			// setAttribute en request
			request.setAttribute("nombre", pNombre.toUpperCase());
			request.setAttribute("apellido1", pApe1.toUpperCase());
			request.setAttribute("apellido2", pApe2.toUpperCase());

		} catch (Exception e) {
			request.setAttribute("error", "Se produjo un error!!! lo sentimos.");
			e.printStackTrace();
		} finally {
			// dispatcher de request (forward) la JSP
			String vistaJSP = "ejercicios/primer-controlador.jsp";
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}

	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger paramteros
		String pNombre = request.getParameter("nombre");
		String pApe1 = request.getParameter("apellido1");
		String pApe2 = request.getParameter("apellido2");

		// setAttribute en request
		request.setAttribute("nombre", pNombre.toLowerCase());
		request.setAttribute("apellido1", pApe1.toLowerCase());
		request.setAttribute("apellido2", pApe2.toLowerCase());

		// dispatcher de request (forward) la JSP
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
	}
}