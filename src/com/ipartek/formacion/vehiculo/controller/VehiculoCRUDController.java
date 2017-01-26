package com.ipartek.formacion.vehiculo.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
import com.ipartek.formacion.vehiculo.servicios.ServiceVehiculo;
import com.ipartek.formacion.vehiculo.servicios.ServiceVehiculoArrayList;

/**
 * Servlet implementation class VehiculoCRUDController
 */
@WebServlet("/vehiculo")
public class VehiculoCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";

	// Operaciones que puede realizar el form
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	// otros
	private static ServiceVehiculo service;

	/**
	 * Solo se hace en la primera peticion al controlador
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		service = ServiceVehiculoArrayList.getInstance();
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

		// Buscar operacion a relaizar
		String op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}
		switch (op) {
		case OP_VER_DETALLE:
			long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("vehiculo", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
		case OP_VER_NUEVO:
			request.setAttribute("vehiculo", new Vehiculo());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		default:
			// listar por defecto
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
