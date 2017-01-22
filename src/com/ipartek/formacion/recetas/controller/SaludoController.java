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
@WebServlet(description = "Servlet para aprender a usar las peticiones GETy POST", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PrintWriter out = response.getWriter();
		// out.append("Peticion GET: " + "<br>");
		// out.append("Parametros: " + "<br>");
		// out.append("Kaixo: " + request.getParameter("nombre") + " " +
		// request.getParameter("ape1") + " "
		// + request.getParameter("ape2"));

		// recoger parametros
		String pNombre = request.getParameter("nombre");
		String pApe1 = request.getParameter("ape1");
		String pApe2 = request.getParameter("ape2");

		// TODO validar parametros

		// Enviar atributos a JSP

		request.setAttribute("nombre", pNombre.toUpperCase());
		request.setAttribute("ape1", pApe1.toUpperCase());
		request.setAttribute("ape2", pApe2.toUpperCase());

		// Request interna a la jsp(forward) ,ir a la jsp
		String vistaJSP = "Ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros
		String pNombre = request.getParameter("nombre");
		String pApe1 = request.getParameter("ape1");
		String pApe2 = request.getParameter("ape2");

		// TODO validar parametros

		// Enviar atributos a JSP

		request.setAttribute("nombre", pNombre.toUpperCase());
		request.setAttribute("ape1", pApe1.toUpperCase());
		request.setAttribute("ape2", pApe2.toUpperCase());
		String vistaJSP = "Ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
	}

}
