package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.services.ServiceReceta;
import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class VehiculoCRUDControllerDB
 */
@WebServlet("/receta")
public class RecetasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/receta/index.jsp";
	private static final String VIEW_FORM = "ejercicios/receta/formulario.jsp";

	// Operaciones que puede realizar el form
	public static final String OP_LISTAR = "1";

	// otros
	private static ServiceReceta service;

	/**
	 * Solo se hace en la primera peticion al controlador
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		// El unico cambio respecto al anterior
		service = ServiceRecetaMysql.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Esto se hace antes de realizar doGet o doPost
		super.service(req, resp);
		// Esto se hace despues de realizar doGet o doPost"
	}

	/**
	 * Destruimos
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		service = null;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = -1;
		Mensaje msj = null;
		RequestDispatcher dispatcher = null;

		try {
			// incializar mensaje
			msj = new Mensaje();

			request.setAttribute("receta", service.getAll());
			dispatcher = request.getRequestDispatcher(VIEW_LIST);
			msj = null;
			break;

		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher(VIEW_LIST);
			msj.setDescripcion(e.getMessage());
			e.printStackTrace();

		} finally {
			request.setAttribute("msj", msj);
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
