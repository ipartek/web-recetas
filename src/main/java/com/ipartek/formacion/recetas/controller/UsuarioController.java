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
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// vistas
	private static final String VIEW_LIST = "usuario/index.jsp";
	private static final String VIEW_FORM = "usuario/form.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	public static final String OP_FILTRAR = "6";

	private static ServiceUsuario service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
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

			case OP_FILTRAR:
				String pDniFiltro = request.getParameter("dni");
				ArrayList<Usuario> listaFiltrada = new ArrayList<Usuario>();

				if (pDniFiltro != null && pDniFiltro.length() == 9) {
					// TODO llamar servicio
					Usuario uFiltrado = service.buscarPorDni(pDniFiltro);
					if (uFiltrado != null) {
						msj.setClase(Mensaje.CLASE_SUCCESS);
						msj.setDescripcion("Encontrado usuario: <b>" + pDniFiltro + "</b>");
						listaFiltrada.add(new Usuario(pDniFiltro));
					} else {
						msj.setClase(Mensaje.CLASE_WARNING);
						msj.setDescripcion("Busqueda sin exito para: <b>" + pDniFiltro + "</b>");
						listaFiltrada = (ArrayList<Usuario>) service.listar();
					}

				} else {
					msj.setClase(Mensaje.CLASE_DANGER);
					msj.setDescripcion("Termino filtro no correcto <b>" + pDniFiltro
							+ "</b>, por favor filtra con el siguiente formato 12345678L, 8 numeros y una letra en mayusculas, no uses guiones ni espacios en blanco");
					listaFiltrada = (ArrayList<Usuario>) service.listar();
				}

				request.setAttribute("listaUsuario", listaFiltrada);
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;

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
					u.setId(id);
					u.setNombre(pNombre);
					u.setApellido1(pApellido1);
					u.setApellido2(pApellido2);
					u.setEdad(pEdad);
					u.setEmail(pEmail);
					u.setDni(pDni);
					u.setPuesto(pPuesto);
					u.setPassword(pPassword);
					u.setImagen(pImagen);

					// comprobar que no exista el DNI o EMAIL que son UNICOS
					if (service.comprobarIntegridad(u.getEmail(), u.getDni(), u.getId())) {
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

						// DNI o EMAIL existen
					} else {
						msj.setClase(Mensaje.CLASE_WARNING);
						msj.setDescripcion("El DNI o el EMAIL deben ser únicos, por favor usa otro.");

						request.setAttribute("usuario", u);
						dispatcher = request.getRequestDispatcher(VIEW_FORM);
					}

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

			// OPERACION LISTAR por defecto
			default:

				request.setAttribute("listaUsuario", service.listar());
				msj = null;
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
				break;
			}// end switch

		} catch (Exception e) {
			System.out.println("CATCCHHHHH");
			dispatcher = request.getRequestDispatcher(VIEW_LIST);
			msj.setDescripcion(e.getMessage());
			e.printStackTrace();

		} finally {
			System.out.println("FINALLYYY");
			request.setAttribute("total", service.usuarioTotales());
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