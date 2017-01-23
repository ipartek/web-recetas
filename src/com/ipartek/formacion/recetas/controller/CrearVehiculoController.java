package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

/**
 * Servlet implementation class CrearVehiculoController
 */
@WebServlet(description = "Controlador para crear  un coche", urlPatterns = { "/crear-vehiculo" })
public class CrearVehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		try {

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

		} catch (Exception e) {
			// Es donde lanzamos el mensaje de excepción. Se usa lo mismo para
			// enviar un mensaje de error o de todo ok.
			request.setAttribute("error", "Se produjo un error, lo sentimos: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// donde va todo
			// request interna (forward) la JSP, ir a la JSP. Forward es como se
			// le
			// llama a esta acción.
			String vistaJSP2 = "ejercicios/Crear-Vehiculo.jsp"; // hay que
			// especificar
			// la carpeta
			request.getRequestDispatcher(vistaJSP2).forward(request, response);
		}

	}
}
