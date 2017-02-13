package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServiceUsuario service;

	private Mensaje msj;
	private HttpSession session;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// service = ServiceVehiculoArrayList.getInstance();
		// service = VehiculoServiceObjectStream.getInstance();
		service = ServiceUsuarioMysql.getInstance();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			msj = new Mensaje();

			// recoger parametros
			String pEmail = request.getParameter("userEmail");
			String pPassword = request.getParameter("userPass");

			// crear usuario con parametros
			Usuario user = new Usuario();
			user.setEmail(pEmail);
			user.setPassword(pPassword);

			if (validarUsuario(user)) {
				// guardar en sessison
				session = request.getSession(true);
				session.setAttribute("usuario", user);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean validarUsuario(Usuario user) {
		boolean resul = false;
		// TODO implementar con BBDD algun dia
		Usuario u = service.existe(user.getEmail(), user.getPassword());
		if (u != null) {
			resul = true;
		}
		return resul;
	}

}
