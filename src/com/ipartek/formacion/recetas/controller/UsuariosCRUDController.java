package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

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
 * Servlet implementation class UsuariosCRUDController
 */
@WebServlet("/usuarios")
public class UsuariosCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VIEW_LIST = "zona-segura/usuarios.jsp";
	private static final String VIEW_FORM = "zona-segura/usuarios-formulario.jsp";
	
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";

	private static ServiceUsuario service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceUsuarioMysql.getInstance();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
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
					id = Long.valueOf(request.getParameter("id"));
					String uNombre = request.getParameter("nombre");
					String uApellido1 = request.getParameter("apellido1");
					String uApellido2 = request.getParameter("apellido2");
					String uEmail = request.getParameter("email");
					String uDni = request.getParameter("dni");
					String uPuesto = request.getParameter("puesto");
					String uImagen = request.getParameter("imagen");
					String uPassword = request.getParameter("password");
					int uEdad = Integer.valueOf(request.getParameter("edad"));
					

					// crear Usuario
					Usuario u = new Usuario();
					u.setId(id);
					u.setNombre(uNombre);
					u.setApellido1(uApellido1);
					u.setApellido2(uApellido2);
					u.setEmail(uEmail);
					u.setEdad(uEdad);
					u.setDni(uDni);
					u.setPuesto(uPuesto);
					u.setPassword(uPassword);
					u.setImagen(uImagen);
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
						msj.setDescripcion("No se ha podido Guardar el usuario");
					}

					// cargar dispatch
					request.setAttribute("usuarios", service.listar());
					dispatcher = request.getRequestDispatcher(VIEW_LIST);

				} catch (Exception e) {

					// si es Vehiculo creado, volver a recuperarlo para mostrar
					// en formulario
					if (id != -1) {
						request.setAttribute("usuarios", service.listar());
					} else {
						request.setAttribute("usuarios", new Usuario());
					}

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
				request.setAttribute("usuarios", service.listar());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;

			default:
				// listar
				request.setAttribute("usuarios", service.listar());
				msj = null;
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;
			}// end switch

		} catch (Exception e) {
			dispatcher = request.getRequestDispatcher(VIEW_LIST);
			msj.setDescripcion(e.getMessage());
			e.printStackTrace();

		} finally {
			request.setAttribute("total", service.usuarioTotales());
			request.setAttribute("msj", msj);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
