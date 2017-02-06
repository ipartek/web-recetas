package com.ipartek.formacion.vehiculo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Mensaje;
import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
import com.ipartek.formacion.vehiculo.servicios.ServiceVehiculo;
import com.ipartek.formacion.vehiculo.servicios.ServiceVehiculoMysql;

/**
 * Servlet implementation class VehiculoCRUDControllerDB
 */
@WebServlet("/vehiculoDB")
public class VehiculoCRUDControllerDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";

	// Operaciones que puede realizar el form
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	// otros
	private static ServiceVehiculo service;

	/**
	 * Solo se hace en la primera peticion al controlador
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		// El unico cambio respecto al anterior
		service = ServiceVehiculoMysql.getInstance();
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
		String op = "";
		long id = -1;
		Mensaje msj = null;
		RequestDispatcher dispatcher = null;

		try {
			// incializar mensaje
			msj = new Mensaje();

			// buscar operacion a realizar
			op = request.getParameter("op");
			if (op == null) {
				op = OP_LISTAR;
			}

			switch (op) {

			case OP_VER_NUEVO:
				request.setAttribute("vehiculo", new Vehiculo());
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
				msj = null;
				break;

			case OP_VER_DETALLE:
				id = Long.valueOf(request.getParameter("id"));
				request.setAttribute("vehiculo", service.getById(id));
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
				msj = null;
				break;

			case OP_GUARDAR:
				try {
					// recoger parametros
					id = Long.valueOf(request.getParameter("id"));
					String pModelo = request.getParameter("modelo");
					int pPlazas = Integer.valueOf(request.getParameter("plazas"));
					// Float pPotencia =
					// Float.valueOf(request.getParameter("potencia"));
					String pPotencia2 = request.getParameter("potencia");
					// Float pDimensiones =
					// Float.valueOf(request.getParameter("dimensiones"));
					String pDimensiones2 = request.getParameter("dimensiones");

					// crear Vehiculo
					Vehiculo v = new Vehiculo();
					v.setId(id);
					v.setModelo(pModelo);
					v.setPlazas(pPlazas);
					v.setPotencia2(pPotencia2);
					v.setDimensiones2(pDimensiones2);

					// guardarlo o persistirlo en la bbdd
					boolean guardado = false;
					if (v.getId() == -1) {
						guardado = service.create(v);
					} else {
						guardado = service.update(v);
					}

					// compobar guardado y gestion Mensaje
					if (guardado) {
						msj.setClase(Mensaje.CLASE_SUCCESS);
						msj.setDescripcion("Vehiculo Guardado con Exito");
					} else {
						msj.setClase(Mensaje.CLASE_WARNING);
						msj.setDescripcion("No se ha podido Guardar el Vehiculo");
					}

					// cargar dispatch
					request.setAttribute("vehiculos", service.getAll());
					dispatcher = request.getRequestDispatcher(VIEW_LIST);

				} catch (Exception e) {

					// si es Vehiculo creado, volver a recuperarlo para mostrar
					// en formulario
					if (id != -1) {
						request.setAttribute("vehiculo", service.getById(id));
					} else {
						request.setAttribute("vehiculo", new Vehiculo());
					}

					msj.setDescripcion("Error:" + e.getMessage());
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				}
				break;

			case OP_ELIMINAR:
				id = Long.valueOf(request.getParameter("id"));
				if (service.delete(id)) {
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Vehivulo Eliminado con Exito");
				} else {
					msj.setClase(Mensaje.CLASE_WARNING);
					msj.setDescripcion("No se ha podido Eliminar el Vehiculo");
				}
				request.setAttribute("vehiculos", service.getAll());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;

			default:
				// listar
				request.setAttribute("vehiculos", service.getAll());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				msj = null;
				break;
			}// end switch

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
