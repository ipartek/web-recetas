package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceReceta;
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
	// Operaciones que puede realizar el form
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";

	// otros
	private static ServiceReceta service;

	/**
	 * Solo se hace en la primera peticion al controlador
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		// El unico cambio respecto al anterior
		service = ServiceReceta.getInstance();
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
				request.setAttribute("receta", new Receta());
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
				msj = null;
				break;

			case OP_VER_DETALLE:
				id = Long.valueOf(request.getParameter("id"));
				request.setAttribute("receta", service.getById(id));
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
				msj = null;
				break;

			case OP_GUARDAR:
				try {
					// recoger parametros
					id = Long.valueOf(request.getParameter("id"));
					String pTitulo = request.getParameter("titulo");
					int pTiempo = Integer.valueOf(request.getParameter("tiempo"));

					// crear Receta
					Receta r = new Receta();
					r.setId(id);
					r.setTitulo(pTitulo);
					r.setTiempo(pTiempo);

					// guardarlo o persistirlo en la bbdd
					boolean guardado = false;
					if (r.getId() == -1) {
						guardado = service.create(r);
					} else {
						guardado = service.update(r);
					}

					// compobar guardado y gestion Mensaje
					if (guardado) {
						msj.setClase(Mensaje.CLASE_SUCCESS);
						msj.setDescripcion("Receta Guardado con Exito");
					} else {
						msj.setClase(Mensaje.CLASE_WARNING);
						msj.setDescripcion("No se ha podido Guardar la receta");
					}

					// cargar dispatch
					request.setAttribute("recetas", service.getAll());
					dispatcher = request.getRequestDispatcher(VIEW_LIST);

				} catch (Exception e) {

					// si es Vehiculo creado, volver a recuperarlo para mostrar
					// en formulario
					if (id != -1) {
						request.setAttribute("receta", service.getById(id));
					} else {
						request.setAttribute("receta", new Receta());
					}

					msj.setDescripcion("Error:" + e.getMessage());
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				}
				break;

			case OP_ELIMINAR:
				id = Long.valueOf(request.getParameter("id"));
				if (service.delete(id)) {
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Receta Eliminado con Exito");
				} else {
					msj.setClase(Mensaje.CLASE_WARNING);
					msj.setDescripcion("No se ha podido Eliminar la receta");
				}
				request.setAttribute("recetas", service.getAll());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;

			default:
				// listar
				request.setAttribute("recetas", service.getAll());
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
