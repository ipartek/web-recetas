package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceRecetaMysql;

/**
 * Servlet implementation class RecetaCRUDController
 */
@WebServlet("/receta")
public class RecetaCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/receta/index.jsp";
	private static final String VIEW_FORM = "ejercicios/receta/formulario.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_ELIMINAR = "4";
	public static final String OP_GUARDAR = "5"; // sirve para crear o modificar
													// un vehiculo

	// private static ServiceReceta service;
	private static Persistable<Receta> service;

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
	public RecetaCRUDController() {
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

		// Inicializar mensaje
		Mensaje mensaje = new Mensaje();
		try {

			switch (op) {
			case OP_GUARDAR: // 5

				try {

					// mensaje.setClase(Mensaje.CLASE_SUCCESS);

					// Recoger variables y crear Receta
					Receta r = new Receta("");
					r.setTitulo(request.getParameter("titulo"));
					r.setTiempo(Integer.parseInt(request.getParameter("tiempo")));
					r.setDificultad(request.getParameter("dificultad"));
					r.setComensales(Integer.parseInt(request.getParameter("comensales")));
					r.setDescripcion(request.getParameter("descripcion"));

					long pIid = (Long.parseLong(request.getParameter("id")));

					// guardarlo o persistirlo en BBDD
					boolean guardado = false;
					if (pIid == -1) {
						// mensaje.setDescripcion("Se ha creado correctamente");
						guardado = service.create(r);
					} else {
						// mensaje.setDescripcion("Se ha modificado
						// correctamente");
						r.setId(Long.parseLong(request.getParameter("id")));
						guardado = service.update(r);
					}

					// comprobar guardado y gestión de mensajes
					if (guardado) {
						mensaje.setDescripcion("Receta guardada correctamente");
						mensaje.setClase(Mensaje.CLASE_SUCCESS);
					} else {
						mensaje.setDescripcion("Receta no guardada. Intentelo mas tarde");
						mensaje.setClase(Mensaje.CLASE_WARNING);
					}

					request.setAttribute("msj", mensaje);
					request.setAttribute("recetas", service.getAll());
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
				} catch (Exception e) {
					// si es Receta creado, volver a recuperarlo para mostrar
					// en formulario
					if ((Long.parseLong(request.getParameter("id"))) != -1) {
						request.setAttribute("receta", service.getById((Long.parseLong(request.getParameter("id")))));
					} else {
						request.setAttribute("receta", new Receta(""));
					}
					mensaje.setDescripcion("Error: " + e.getMessage());
					mensaje.setClase(Mensaje.CLASE_DANGER);
					request.setAttribute("msj", mensaje);

					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					e.printStackTrace();
				}

				break;
			case OP_ELIMINAR: // 4

				// TODO confirmar si realmente quiere eliminar

				if (service.delete(Long.parseLong(request.getParameter("id")))) {
					mensaje.setDescripcion("Receta eliminada correctamente");
					mensaje.setClase(Mensaje.CLASE_SUCCESS);
				} else {
					mensaje.setDescripcion("Receta no eliminada. Intentelo mas tarde.");
					mensaje.setClase(Mensaje.CLASE_WARNING);
				}

				request.setAttribute("msj", mensaje);
				request.setAttribute("recetas", service.getAll());
				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
				break;
			case OP_VER_NUEVO: // 3
				request.setAttribute("receta", new Receta(""));
				request.getRequestDispatcher(VIEW_FORM).forward(request, response);
				break;

			case OP_VER_DETALLE: // 2
				long id = Long.parseLong(request.getParameter("id"));
				request.setAttribute("receta", service.getById(id));
				request.getRequestDispatcher(VIEW_FORM).forward(request, response);
				break;
			default: // 1
				// listar
				request.setAttribute("recetas", service.getAll());
				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
				break;
			}// end switch

		} catch (Exception e) {
			mensaje.setDescripcion(e.getMessage());
			e.printStackTrace();
		}
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
