package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.services.ServiceUsuario;
import com.ipartek.formacion.recetas.services.ServiceUsuarioMysql;

/**
 * Servlet implementation class UsuarioCRUDController
 */
@WebServlet("/zona-segura/usuario")
public class UsuarioCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// vistas
	private static final String VIEW_LIST = "usuario/indexUsuario.jsp";
	private static final String VIEW_FORM = "usuario/formularioUsuario.jsp";
	private static final String VIEW_ADD = "usuario/crear-usuario.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	public static final String OP_FILTRAR = "9";

	private static ServiceUsuario service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// service = ServiceVehiculoArrayList.getInstance();
		// service = VehiculoServiceObjectStream.getInstance();
		service = ServiceUsuarioMysql.getInstance();

	}

	@Override
	public void destroy() {
		super.destroy();
		service = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Antes de Realizar doGet o doPost");
		super.service(req, resp);
		// System.out.println("Tras realizar doGet o doPost");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
				request.setAttribute("usuario", new Usuario());
				dispatcher = request.getRequestDispatcher(VIEW_ADD);
				msj = null;
				break;

			case OP_VER_DETALLE:
				id = Long.valueOf(request.getParameter("id"));
				request.setAttribute("usuario", service.buscarPorId(id));
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
				msj = null;
				break;
			case OP_GUARDAR:
				try {
					// recoger parametros

					String pNombre = request.getParameter("nombre");
					String pApellido1 = request.getParameter("apellido1");
					String pApellido2 = request.getParameter("apellido2");
					int pEdad = Integer.valueOf(request.getParameter("edad"));
					String pEmail = request.getParameter("email");
					String pDni = request.getParameter("dni");
					String pPuesto = request.getParameter("puesto");
					String pPassword = request.getParameter("password");
					String pImagen = request.getParameter("imagen");

					// crear Usuario
					Usuario u = new Usuario();

					u.setNombre(pNombre);
					u.setApellido1(pApellido1);
					u.setApellido2(pApellido2);
					u.setEdad(pEdad);
					u.setEmail(pEmail);
					u.setDni(pDni);
					u.setPuesto(pPuesto);
					u.setPassword(pPassword);
					u.setImagen(pImagen);

					// guardarlo o persistirlo en la bbdd
					boolean guardado = false;
					if (u.getId() == -1) {
						guardado = service.darDeAlta(u);
					} else {
						guardado = service.modificar(u);
					}

					// compobar guardado y gestion Mensaje
					if (guardado) {
						msj.setClase(Mensaje.CLASE_SUCCESS);
						msj.setDescripcion("Usuario Guardado con Exito");
					} else {
						msj.setClase(Mensaje.CLASE_WARNING);
						msj.setDescripcion("No se ha podido Guardar el Usuario");
					}

					// cargar dispatch
					request.setAttribute("listaUsuario", service.listar());
					dispatcher = request.getRequestDispatcher(VIEW_LIST);

				} catch (Exception e) {

					// si es Usuario creado, volver a recuperarlo para mostrar
					// en formulario
					if (id != -1) {
						request.setAttribute("usuario", service.buscarPorId(id));
					} else {
						request.setAttribute("usuario", new Usuario());
					}
					e.printStackTrace();
					msj.setDescripcion("Error:" + e.getMessage());
					dispatcher = request.getRequestDispatcher(VIEW_FORM);
				}
				break;
			case OP_ELIMINAR:
				id = Long.valueOf(request.getParameter("id"));
				if (service.darDeBaja(id)) {
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Usuario Eliminado con Exito");
				} else {
					msj.setClase(Mensaje.CLASE_WARNING);
					msj.setDescripcion("No se ha podido Eliminar el Usuario");
				}
				request.setAttribute("listaUsuario", service.listar());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;
			case OP_FILTRAR:
				String[] opcion=request.getParameterValues("optradio");
					if(opcion[0].equalsIgnoreCase("Nombre")){
						request.setAttribute("listaUsuario",service.filtrarPorNombre(request.getParameter("filtro")));
					}
					else if(opcion[0].equalsIgnoreCase("Dni")){
						request.setAttribute("listaUsuario",service.filtrarPorDni(request.getParameter("filtro")));

					}
					else if(opcion[0].equalsIgnoreCase("Email")){
						request.setAttribute("listaUsuario",service.filtrarPorEmail(request.getParameter("filtro")));

					}
					msj.setClase(Mensaje.CLASE_SUCCESS);
					msj.setDescripcion("Filtrado realizado con exito:<br/>"
							+ "<b>Filtrar por:</b> "+opcion[0]
							+ "<br/><b>Texto introducido:</b> "+request.getParameter("filtro"));
					dispatcher = request.getRequestDispatcher(VIEW_LIST);
					break;
			default:
				request.setAttribute("listaUsuario", service.listar());
				msj = null;
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}