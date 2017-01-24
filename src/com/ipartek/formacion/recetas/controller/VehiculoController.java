package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/crear-vehiculo")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_CREAR_VEHICULO = "ejercicios/crear-vehiculo.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiculoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje mensaje = null;

		try {
			mensaje = new Mensaje();

			// recoger parametros del formulario
			String pModelo = request.getParameter("modelo");
			int pPlazas = Integer.parseInt(request.getParameter("plazas"));
			float pPotencia = Float.parseFloat(request.getParameter("potencia"));

			// Instanciar Vehiculo
			Vehiculo v = new Vehiculo();
			v.setModelo(pModelo);
			v.setPlazas(pPlazas);
			v.setPotencia(pPotencia);

			// enviar como atributo a la JSP
			request.setAttribute("vehiculo", v);
			// request.setAttribute("modelo", pModelo);
			// request.setAttribute("plazas", pPlazas);
			// request.setAttribute("potencia", pPotencia);

			// Mensaje Success
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			mensaje.setDescripcion("Vehiculo creado con exito");

		} catch (NumberFormatException e) {
			mensaje.setDescripcion("Error!! Los parametros introducidos no son correctos");
			e.printStackTrace();
		} catch (Exception e) {

			// request.setAttribute("error", "Se produjo un error lo sentimos: "
			// + e.getMessage());
			mensaje.setDescripcion("Error!! Upsss se produjo un error lo sentimos: " + e.getMessage());
			e.printStackTrace();
		} finally {

//			String vistaJSP = "ejercicios/crear-vehiculo.jsp";
			request.setAttribute("msj", mensaje);
			request.getRequestDispatcher(VIEW_CREAR_VEHICULO).forward(request, response);
		}
	}

}
