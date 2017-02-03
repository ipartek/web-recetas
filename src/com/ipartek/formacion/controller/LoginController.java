package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "usrPassCredentials", value = "123"),
		@WebInitParam(name = "usrNameCredentials", value = "admin") })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mensaje msj;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			msj = new Mensaje();

			// recoger parametros del formulario
			String pUsuario = request.getParameter("user");
			String pClave = request.getParameter("password");

			// crear Usuario
			Usuario user = new Usuario();
			user.setNombre(pUsuario);
			user.setPassword(pClave);

			// validar Parametros

			if (validarUsuario(user)) {

				// guardar en sesion
				session = request.getSession(true);
				session.setAttribute("user", user);// esto se guarda
													// en el
													// contexto del
													// usuario
				// redirect a index.jsp,si usamos esto no podemos mandar
				// attributos por request,los parametros en string
				// response.sendRedirect("index.jsp?parametrohola");

				response.sendRedirect("index.jsp");

			} else {
				msj.setClase(Mensaje.CLASE_WARNING);
				msj.setDescripcion("Datos Incorrectos");
				request.setAttribute("msj", msj);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		} finally {

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private boolean validarUsuario(Usuario user) {
		boolean result = false;
		// TODO implementar con BBDD
		// contexto parametros de inicio
		final String usrNameCredentials = getInitParameter("usrNameCredentials");
		final String usrPassCredentials = getInitParameter("usrPassCredentials");
		if (usrNameCredentials.equalsIgnoreCase(user.getNombre())
				&& usrPassCredentials.equalsIgnoreCase(user.getPassword())) {
			result = true;

		}
		return result;
	}

}
