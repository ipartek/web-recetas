package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.VehiculoException;
import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculoArrayList;

/**
 * Servlet implementation class VehiculoCRUDController
 */
@WebServlet("/vehiculo")
public class VehiculoCRUDController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";

	private static ServiceVehiculo service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceVehiculoArrayList.getInstance();
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

		Mensaje mensaje = new Mensaje();

		// buscar operacion a realizar
		String op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {

		case OP_GUARDAR:
			boolean error = true;
			try {
				// recoger parametros
				String parametroModelo = request.getParameter("modelo");
				int parametroPlazas = Integer.valueOf(request.getParameter("plazas"));
				float parametroPotencia = Float.valueOf(request.getParameter("plazas"));
				// String parametroPotencia = request.getParameter("potencia");

				// request.getParameter("potencia");

				// crear Vehiculo
				Vehiculo vehiculo = new Vehiculo();

				// setters
				vehiculo.setModelo(parametroModelo);
				vehiculo.setPlazas(parametroPlazas);
				vehiculo.setPotencia(parametroPotencia);

				// guardalo con el servicio
				service.create(vehiculo);

				// mensaje usuario

				mensaje.setClase(Mensaje.CLASE_SUCCESS);
				mensaje.setDescripcion("Vehiculo creado con exito");

				// recuperar coches y pasar como atributo
				request.setAttribute("vehiculos", service.getAll());
				request.setAttribute("msj", mensaje);

				// ir a la vista con el listado de coches

				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			} catch (VehiculoException e) {
				mensaje.setClase(Mensaje.CLASE_WARNING);
				mensaje.setDescripcion("Problemas");
				e.printStackTrace();
			} finally {
				request.setAttribute("msj", mensaje);
				if (error = false) {
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
				} else {
					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
				}
			}

			break;

		case OP_VER_NUEVO:
			request.setAttribute("vehiculo", new Vehiculo());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		case OP_VER_DETALLE:
			long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("vehiculo", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		default:
			// listar
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		}// end switch

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
