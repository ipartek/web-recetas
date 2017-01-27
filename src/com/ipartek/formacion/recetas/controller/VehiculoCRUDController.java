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
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";

	private static ServiceVehiculo service;

	// Se ejecuta la primera vez que se realiza una peticion
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

	// Se ejecuta despues del init si es la primera peticion
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Esto se hace antes de realizar doGet o doPost
		super.service(req, res);
		// Despues de realizar doGet o doPost
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// buscar operacion a realizar
		String op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		// Creamos un booleano y el mensaje para sacar por pantalla.
		boolean mostrarmsj = false;
		Mensaje msj = new Mensaje();

		switch (op) {

		// Operacion que elimina un Vehiculo
		case OP_ELIMINAR:
			mostrarmsj = service.delete(Long.parseLong(request.getParameter("id")));
			request.setAttribute("vehiculos", service.getAll());
			if (mostrarmsj) {
				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("Eliminado correctamente");
				request.setAttribute("msj", msj);
			}

			request.getRequestDispatcher(VIEW_LIST).forward(request, response);

			break;

		// Operacion que crea y modifica el Vehiculo.
		case OP_GUARDAR:
			Vehiculo v = new Vehiculo();
			v.setId(Integer.parseInt(request.getParameter("id")));
			v.setModelo(request.getParameter("modelo"));
			v.setPlazas(Integer.parseInt(request.getParameter("plazas")));
			v.setDimensiones(Float.parseFloat(request.getParameter("dimensiones")));
			v.setPotencia(Float.parseFloat(request.getParameter("potencia")));
			if (Integer.parseInt(request.getParameter("id")) == -1) {
				service.create(v);
				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("Creado correctamente");
				request.setAttribute("msj", msj);

			} else {
				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("Modificado correctamente");
				request.setAttribute("msj", msj);
				service.update(v);
			}
			request.setAttribute("vehiculos", service.getAll());

			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		// Operacion que crea un nuevo vehiculo.
		case OP_VER_NUEVO:
			request.setAttribute("vehiculos", new Vehiculo());
			request.setAttribute("op", OP_VER_NUEVO);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		// Operacion que enseña los detalles del vehiculo.
		case OP_VER_DETALLE:
			long id = Long.parseLong(request.getParameter("id"));
			request.setAttribute("vehiculos", service.getById(id));
			request.setAttribute("op", OP_VER_DETALLE);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		// Cuando OP no es definido, por ejemplo al entrar desde index.
		default:
			// listar
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		}

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