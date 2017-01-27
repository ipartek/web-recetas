package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.Utilidades;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.services.ServiceDadoArrayList;

/**
 * Servlet implementation class DadoController
 */
@WebServlet("/dado")
public class DadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ServiceDadoArrayList service;
	
	private static final String VIEW= "ejercicios/dado.jsp";


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
		System.out.println("Antes de Realizar doGet o doPost");
		super.service(req, resp);
		System.out.println("Tras realizar doGet o doPost");


	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=request.getParameter("op");
		int num_personas = service.getNumeroUsuarios();
		request.setAttribute("num_personas", num_personas);
		if (op.equals("2")) {
			int numeroAleatorio = Utilidades.getNumeroAleatorio((num_personas- 1));
			Usuario u=service.getByPos(numeroAleatorio);
			request.setAttribute("usuario", u);

		}
		request.getRequestDispatcher(VIEW).forward(request, response);

		// );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
