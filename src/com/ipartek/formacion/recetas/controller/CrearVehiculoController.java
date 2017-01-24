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
 * Servlet implementation class CrearVehiculoController
 */
@WebServlet(description = "Controlador para crear  un coche", urlPatterns = { "/crear-vehiculo" })
public class CrearVehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_CREAR_VEHICULO = "ejercicios/Crear-Vehiculo.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearVehiculoController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			String pModelo = request.getParameter("modelo");
			// Plazas es int en los atributos de la clase vehiculo. Por lo
			// tanto, la variable debe ser int. Sin embargo, como todos los
			// parámetros son siempre de tipo String, hay que hacer una
			// conversión para que no de error y podamos pasar el parámetro de
			// forma correcta. La forma de realizar esta conversión es la
			// siguiente: int variable = integer.parseInt(lo que necesitemos(con
			// parametro));
			int pPlazas = Integer.parseInt(request.getParameter("plazas"));
			// Potencia es float en los atributos de la clase vehiculo. Por lo
			// tanto, la variable debe ser float. Sin embargo, como todos los
			// parámetros son siempre de tipo String, hay que hacer una
			// conversión para que no de error y podamos pasar el parámetro de
			// forma correcta. La forma de realizar esta conversión es la
			// siguiente: float variable = Float.parseInt(lo que necesitemos(con
			// parametro));
			float pPotencia = Float.parseFloat(request.getParameter("potencia"));

			/*
			 * request.setAttribute("modelo", pModelo);
			 * request.setAttribute("plazas", pPlazas);
			 * request.setAttribute("potencia", pPotencia);
			 */
			// hay que crear el nuevo coche. Para eso cogemos los atributos.

			Vehiculo v = new Vehiculo();

			v.setModelo(pModelo);
			v.setPlazas(pPlazas);
			v.setPotencia(pPotencia);
			// Es el atributo que definimos para lanzar un mensaje. Puede ser de
			// error, de aviso, de creación de objeto etc.
			request.setAttribute("vehiculo", v);

			// mensaje success
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			mensaje.setDescripcion("Vehiculo creado con Exito!!!");

		} catch (NumberFormatException e) {
			// Es donde lanzamos el mensaje de excepción. Se usa lo mismo para
			// enviar un mensaje de error o de todo ok.

			mensaje.setDescripcion("Los parametros introducidos no son correctos.");
		} catch (Exception e) {
			// Es donde lanzamos el mensaje de excepción. Se usa lo mismo para
			// enviar un mensaje de error o de todo ok.

			request.setAttribute("error", "Se produjo un error, lo sentimos: " + e.getMessage());
			e.printStackTrace();

		} finally {

			request.setAttribute("msj", mensaje);
			request.getRequestDispatcher(VIEW_CREAR_VEHICULO).forward(request, response);

		}

	}
}
