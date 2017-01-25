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
@WebServlet(urlPatterns = { "/login" }, initParams = {
		@WebInitParam(name = "userNameCredential", value = "admin", description = "Nombre de user para acceder a la aplicación hasta tener una DB"),
		@WebInitParam(name = "userPassCredential", value = "123", description = "Clave del user hasta tener una DB") })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
	private Mensaje msj;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// mensaje
			msj = new Mensaje();

			// recoger parametros

			String pNombre = request.getParameter("userName");
			String pPassword = request.getParameter("userPW");

			Usuario user = new Usuario();
			user.setNombre(pNombre);
			user.setPassword(pPassword);

			if (validarUsuario(user)) {

				session = request.getSession(true);
				session.setAttribute("user", user);

				// redirect index.jsp
				response.sendRedirect("index.jsp");

				/*
				 * Si hago una redirección no puedo pasar un atributo porque no
				 * va a estar a donde voy, ya que son varias request y el
				 * atributo solo funcionaría en el primer viaje, no en los
				 * siguientes request (SON MUCHOS REQUEST, estilo un partido de
				 * ping-pong o tenis). Lo que si que puedo es pasar parámetros.
				 * ¿Cómo se pasan? añadiendo la información en el enlace. Por
				 * ejemplo: index.jsp?parametro=bala
				 * 
				 */

			} else {
				msj.setClase(Mensaje.CLASE_WARNING);
				msj.setDescripcion(
						"Tu usuario o clave no son correctos. Por favor, revisa la información introducida y vuelve a intentarlo. Te quedan X intentos. Muchas gracias :)");
				request.setAttribute("msj", msj);

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	private boolean validarUsuario(Usuario user) {
		boolean resul = false;
		// TODO implementar con base de datos algún día

		// contexto para los parametros de inicio

		final String userNameCredential = getInitParameter("userNameCredential");
		final String userPassCredential = getInitParameter("userPassCredential");

		// comprueba que coincidan user y pasword
		if (userNameCredential.equalsIgnoreCase(user.getNombre())
				&& userPassCredential.equalsIgnoreCase(user.getPassword())) {
			resul = true;
		}

		return resul;
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
