package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.services.ServiceUsuario;
import com.ipartek.formacion.recetas.services.ServiceUsuarioMysql;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "userNameCredential", value = "admin"),
		@WebInitParam(name = "userPassCredential", value = "123") })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Mensaje msj;
	private HttpSession session;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			msj = new Mensaje();

			// recoger parametros
			String pMail = request.getParameter("userMail");
			String pPassword = request.getParameter("userPass");

			// crear usuario con parametros
			Usuario user = new Usuario();
			user.setEmail(pMail);
			user.setPassword(pPassword);

			if (service.existe(user.getEmail(), user.getPassword()) != null) {

				// guardar en sessison
				session = request.getSession(true);
				session.setAttribute("usuario", service.existe(user.getEmail(), user.getPassword()));

				// redirect a index.jsp
				response.sendRedirect("index.jsp");

			} else {

				msj.setClase(Mensaje.CLASE_WARNING);
				msj.setDescripcion("Tu usuario o password no son correctos");

				request.setAttribute("msj", msj);

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		} finally {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// private boolean validarUsuario(Usuario user) {
	// boolean resul = false;
	// // TODO implementar con BBDD algun dia
	//
	// // contexto para los parametros de inicio
	// final String userNameCredential = getInitParameter("userNameCredential");
	// final String userPassCredential = getInitParameter("userPassCredential");
	//
	// // comprobar que coincidan
	// if (userNameCredential.equalsIgnoreCase(user.getNombre())
	// && userPassCredential.equalsIgnoreCase(user.getPassword())) {
	// resul = true;
	// }
	//
	// return resul;
	// }

}
