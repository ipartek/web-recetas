package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/crear-vehiculo")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		try {
			String pModelo = request.getParameter("modelo");
			int pPlazas = Integer.parseInt(request.getParameter("plazas"));
			float pPotencia = Float.parseFloat(request.getParameter("potencia"));

			// Instanciar Vehiculo
			Vehiculo v = new Vehiculo();
			v.setModelo(pModelo);
			v.setPlazas(pPlazas);
			v.setPotencia(pPotencia);

			request.setAttribute("vehiculo", v);
			// request.setAttribute("modelo", pModelo);
			// request.setAttribute("plazas", pPlazas);
			// request.setAttribute("potencia", pPotencia);
		} catch (Exception e) {
			request.setAttribute("error", "Se produjo un error lo sentimos: " + e.getMessage());
			e.printStackTrace();
		} finally {

			String vistaJSP = "ejercicios/crear-vehiculo.jsp";
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}
	}

}
