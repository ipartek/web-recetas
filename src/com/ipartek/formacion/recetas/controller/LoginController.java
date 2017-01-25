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
 * Servlet implementation class loginController
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

			String pNombre = request.getParameter("userName");
			String pPassword = request.getParameter("userPass");

			Usuario user = new Usuario();
			user.setNombre(pNombre);
			user.setPassword(pPassword);

			if (validarUsuario(user)) {
				session = request.getSession(true);
				session.setAttribute("usuario", user);

				response.sendRedirect("index.jsp");

			} else {
				msj.setClase(Mensaje.CLASE_WARNING);
				msj.setDescripcion("tus datos no son correctos");

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

		final String userNameCredential = getInitParameter("userNameCredential");
		final String userPassCredential = getInitParameter("userPassCredential");

		if (userNameCredential.equalsIgnoreCase(user.getNombre())
				&& userPassCredential.equalsIgnoreCase(user.getPassword())) {
			resul = true;
		}
		return resul;
	}

}
