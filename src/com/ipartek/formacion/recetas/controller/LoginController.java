package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "userNameCredential", value = "admin"),
		@WebInitParam(name = "userPassCredential", value = "123") })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Mensaje msj;
	private HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			msj = new Mensaje();

			// recoger parametros
			String pNombre = request.getParameter("userName");
			String pPassword = request.getParameter("userPass");

			// crear usuario con parametros
			Usuario user = new Usuario();
			user.setNombre(pNombre);
			user.setPassword(pPassword);

			// comprobacion
			if (validarUsuario(user)) {

				session = request.getSession(true);
				session.setAttribute("usuario", user);

				// redirect a index.jsp
				response.sendRedirect("index.jsp"); // no se puede enviar
													// atributos, en caso de
													// querer enviar, se podra
													// en viar a traves del url
													// index.jsp?Parametro=value

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean validarUsuario(Usuario user) {
		boolean resul = false;

		// TODO implementar con BBDD algun día

		// contexto para los parametros de inicio
		final String userNameCredential = getInitParameter("userNameCredential");
		final String userPassCredential = getInitParameter("userPassCredential");

		// comprobar que coincidan usuario y password.
		if (userNameCredential.equalsIgnoreCase(user.getNombre())
				&& userPassCredential.equalsIgnoreCase(user.getPassword())) {
			resul = true;
		}
		return resul;
	}
}
