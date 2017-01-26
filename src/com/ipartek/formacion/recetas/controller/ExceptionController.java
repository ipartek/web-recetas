package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExceptionController
 */
@WebServlet(description = "Controlador para probar como se capturan las excepciones y se configuran desde web.xml", urlPatterns = {
		"/controladorException" })
public class ExceptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("1".equals(request.getParameter("p"))) {
			Object o = null;
			o.toString();
		}
	}
	// else{

	// TODO Mirar mas tarde si se puede lanzar personalizada.
	// throw new VehiculoException("Trata de arrancarlo Carlos, por Dios..");
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
