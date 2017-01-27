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
	public static final String OP_ELIMINAR = "4";
	public static final String OP_GUARDAR = "5"; // sirve para crear o modificar
													// un vehiculo

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
		// Antes de realizar doGet o doPost
		System.out.println("Antes de realizar doGet o doPost");
		super.service(req, resp);
		// Tras realizar doGet o doPost
		System.out.println("Tras realizar doGet o doPost");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiculoCRUDController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// buscar operacion a realizar
		String op = (request.getParameter("op") == null) ? OP_LISTAR : request.getParameter("op");
		Mensaje mensaje = new Mensaje();

		switch (op) {
		case OP_GUARDAR: // 5

			try {

				mensaje.setClase(Mensaje.CLASE_SUCCESS);

				Vehiculo v = new Vehiculo();
				v.setModelo(request.getParameter("modelo"));
				v.setPlazas(Integer.parseInt(request.getParameter("plazas")));
				v.setDimensiones(Float.parseFloat(request.getParameter("dimensiones")));
				v.setPotencia(Float.parseFloat(request.getParameter("potencia")));

				long pIid = (Long.parseLong(request.getParameter("id")));

				if (pIid == -1) {
					mensaje.setDescripcion("Se ha creado correctamente");
					service.create(v);
				} else {
					mensaje.setDescripcion("Se ha modificado correctamente");
					v.setId(Long.parseLong(request.getParameter("id")));
					service.update(v);
				}

				request.setAttribute("msj", mensaje);
				request.setAttribute("vehiculos", service.getAll());
				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			} catch (Exception e) {
				mensaje.setDescripcion(e.getMessage());
				mensaje.setClase(Mensaje.CLASE_DANGER);
				request.setAttribute("msj", mensaje);

				request.getRequestDispatcher(VIEW_FORM).forward(request, response);
				e.printStackTrace();
			}

			break;
		case OP_ELIMINAR: // 4

			// confirmar si realmente quiere eliminar

			mensaje.setDescripcion("Se ha eliminado correctamente");
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			request.setAttribute("msj", mensaje);

			service.delete(Long.parseLong(request.getParameter("id")));
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		case OP_VER_NUEVO: // 3
			request.setAttribute("vehiculo", new Vehiculo());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		case OP_VER_DETALLE: // 2
			long id = Long.parseLong(request.getParameter("id"));
			request.setAttribute("vehiculo", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
		default: // 1
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
