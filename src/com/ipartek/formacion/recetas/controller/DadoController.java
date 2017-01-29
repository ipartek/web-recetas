package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.DadoAlumno;
import com.ipartek.formacion.recetas.services.ServiceDadoArrayList;

/**
 * Servlet implementation class DadoController
 */
@WebServlet("/dado")
public class DadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_JSP = "ejercicios/dado/index.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_ALUMNO_ALEATORIO = "2";

	private static ServiceDadoArrayList service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceDadoArrayList.getInstance();

	}

	@Override
	public void destroy() {
		super.destroy();
		service = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Antes de realizar doGet o doPost
		System.out.println("Antes de realizar doGet o doPost");
		super.service(req, resp);
		// Tras realizar doGet o doPost
		System.out.println("Tras realizar doGet o doPost");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = (request.getParameter("op") == null) ? OP_LISTAR : request.getParameter("op");
		DadoAlumno alumno = new DadoAlumno();

		switch (op) {
		case OP_ALUMNO_ALEATORIO: // 2

			long numAleatorio = (service.getNumeroAleatorio(service.getAll().size())) + 1;
			alumno = service.getById(numAleatorio);

			request.setAttribute("numAleatorio", numAleatorio);
			request.setAttribute("alumno", alumno);
			request.setAttribute("numMaxAlumnos", service.getAll().size());
			request.getRequestDispatcher(VIEW_JSP).forward(request, response);
			break;

		default:// 1
			request.setAttribute("numMaxAlumnos", service.getAll().size());
			request.getRequestDispatcher(VIEW_JSP).forward(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
