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

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceRecetaMysql;

/**
 * Servlet implementation class RecetaController
 */
@WebServlet("/receta")
public class RecetaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceRecetaMysql service;

	private static final String VIEW_LIST = "ejercicios/receta/index-receta.jsp";
	private static final String VIEW_FORM = "ejercicios/receta/formulario-receta.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";

	// Se ejecuta la primera vez que se realiza una peticion
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceRecetaMysql.getInstance();

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
			mostrarmsj = service.delete(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("recetas", service.getAll());
			if (mostrarmsj) {
				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("Eliminado correctamente");
				request.setAttribute("msj", msj);
			}

			request.getRequestDispatcher(VIEW_LIST).forward(request, response);

			break;

		// Operacion que crea y modifica el Vehiculo.
		case OP_GUARDAR:
			Receta r = null;
			try {
				r = new Receta();
				r.setId(Integer.parseInt(request.getParameter("id")));
				r.setTitulo(request.getParameter("titulo"));
				r.setImagen(request.getParameter("imagen"));
				r.setTiempo(Integer.parseInt(request.getParameter("tiempo")));
				r.setComensales(Integer.parseInt(request.getParameter("comensales")));
				r.setDificultad(request.getParameter("dificultad"));
				r.setDescripcion(request.getParameter("descripcion"));

				if (Integer.parseInt(request.getParameter("id")) == -1) {
					service.create(r);
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Creado correctamente");
					request.setAttribute("msj", msj);

				} else {
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Modificado correctamente");
					request.setAttribute("msj", msj);
					service.update(r);
				}
				request.setAttribute("recetas", service.getAll());

				request.getRequestDispatcher(VIEW_LIST).forward(request, response);

			} catch (Exception e) {
				msj.setClase(Mensaje.CLASE_DANGER);
				msj.setDescripcion(e.getMessage());
				request.setAttribute("msj", msj);
				request.setAttribute("op", OP_VER_DETALLE);
				request.setAttribute("recetas", r);
				e.printStackTrace();
				request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			}
			break;
		// Operacion que crea un nuevo vehiculo.
		case OP_VER_NUEVO:
			request.setAttribute("recetas", new Receta());
			request.setAttribute("op", OP_VER_NUEVO);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		// Operacion que enseña los detalles del vehiculo.
		case OP_VER_DETALLE:
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("recetas", service.getById(id));
			request.setAttribute("op", OP_VER_DETALLE);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		// Cuando OP no es definido, por ejemplo al entrar desde index.
		default:
			// listar
			request.setAttribute("recetas", service.getAll());
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
