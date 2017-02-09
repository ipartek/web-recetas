package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.services.ServiceUsuario;
import com.ipartek.formacion.recetas.services.ServiceUsuarioMySQL;

/**
 * Servlet implementation class UsuarioCRUDController
 */
@WebServlet("/zona-segura/usuario")
public class UsuarioCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Declaracion
	private static final String VIEW_LIST = "/zona-segura/usuario/index.jsp";
	private static final String VIEW_FORM = "/zona-segura/usuario/formulario.jsp";
	private static ServiceUsuario service;

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	public static final String OP_FILTRO = "6";

	// Se ejecuta la primera vez que se realiza una peticion
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//service = ServiceVehiculoArrayList.getInstance();
		service = ServiceUsuarioMySQL.getInstance();
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Operacion a realizar
				String op = request.getParameter("op");
				Mensaje msg = new Mensaje();
				if (op == null) {
					op = OP_LISTAR;
				}
				switch (op) {

				case OP_ELIMINAR:

					if (service.darDeBaja(Long.parseLong(request.getParameter("id")))) {
						msg.setClase(Mensaje.CLASE_SUCCESS);
						msg.setDescripcion("Eliminado correctamente");
						request.setAttribute("msj", msg);
					}

					request.setAttribute("count", service.usuarioTotales());
					request.setAttribute("usuarios", service.listar());
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
					break;

				case OP_GUARDAR:
					Usuario u = null;
					try {
						u = new Usuario();
						
						u.setId(Integer.parseInt(request.getParameter("id")));
						u.setNombre(request.getParameter("nombre"));
						u.setApellido1(request.getParameter("apellido1"));
						u.setApellido2(request.getParameter("apellido2"));
						u.setEdad(Integer.parseInt(request.getParameter("edad")));
						u.setEmail(request.getParameter("email"));
						u.setDni(request.getParameter("dni"));
						u.setPuesto(request.getParameter("puesto"));
						u.setPassword(request.getParameter("password"));
						u.setImagen(request.getParameter("imagen"));
						
						
						// Los vehiculos nuevos tienen id -1 al INSTANCIAR Vehiculo.
						if (Integer.parseInt(request.getParameter("id")) == -1) {
							if (service.darDeAlta(u)) {
								msg.setClase(Mensaje.CLASE_SUCCESS);
								msg.setDescripcion("Creado correctamente");
								request.setAttribute("msj", msg);
							}
						} else {
							if (service.modificar(u)) {
								msg.setClase(Mensaje.CLASE_SUCCESS);
								msg.setDescripcion("Modificado correctamente");
								request.setAttribute("msj", msg);
							}
						}
						
						request.setAttribute("count", service.usuarioTotales());
						request.setAttribute("usuarios", service.listar());
						request.getRequestDispatcher(VIEW_LIST).forward(request, response);

					} catch (NumberFormatException e) {
						msg.setClase(Mensaje.CLASE_DANGER);
						msg.setDescripcion(e.getMessage());
						e.printStackTrace();
						request.setAttribute("msj", msg);
						request.setAttribute("op", OP_VER_DETALLE);
						request.setAttribute("usuarios", u);
						request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					}

					break;

				case OP_VER_NUEVO:
					request.setAttribute("usuarios", new Usuario());
					request.setAttribute("op", OP_VER_NUEVO);
					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					break;

				case OP_VER_DETALLE:
					long id = Long.parseLong(request.getParameter("id"));
					request.setAttribute("usuarios", service.buscarPorId(id));
					request.setAttribute("op", OP_VER_DETALLE);
					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					break;
					
				case OP_FILTRO:
					String email = request.getParameter("email");
					if (email != "") {
						ArrayList<Usuario> ArrayEmail = new ArrayList<Usuario>();
						Usuario userEmail = service.buscarPorEmail(email);
						ArrayEmail.add(userEmail);
						request.setAttribute("usuarios", ArrayEmail);
					}
					
					String dni = request.getParameter("dni");
					if (dni != "") {
						request.setAttribute("usuarios", service.buscarPorDni(dni));
					}
					
					String busqueda = request.getParameter("busqueda");
					if (busqueda != "") {
						request.setAttribute("usuarios", service.buscarPorNombreOApellido(busqueda));
					}
					
					String edadMin = request.getParameter("edadMin");
					String edadMax = request.getParameter("edadMax");
					if (edadMin != "" && edadMax != "") {
						request.setAttribute("usuarios", service.buscarPorEdad(Integer.parseInt(edadMin), Integer.parseInt(edadMax)));
					}
					request.setAttribute("op", OP_LISTAR);
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
					break;

				// Cuando OP no es definida, por ejemplo al clickar listar
				// <a href="vehiculo">CRUD de Vehiculos</a>
				default:
					request.setAttribute("count", service.usuarioTotales());
					request.setAttribute("usuarios", service.listar());
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
					break;
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
