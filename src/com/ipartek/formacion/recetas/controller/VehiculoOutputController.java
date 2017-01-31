package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.VehiculoServiceObjectStream;

/**
 * Servlet implementation class VehiculoOutputController
 */
@WebServlet("/vehiculoOutput")
public class VehiculoOutputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ServiceVehiculo service;

	@Override
	public void init(ServletConfig config) throws ServletException {

		service = VehiculoServiceObjectStream.getInstance();

		super.init(config);
	}

	@Override
	public void destroy() {
		super.destroy();
		service = null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("vehiculos", service.getAll());
		request.getRequestDispatcher("ejercicios/vehiculo-stream.jsp").forward(request, response);
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
