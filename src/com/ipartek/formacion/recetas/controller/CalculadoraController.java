package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/calculadora")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculadoraController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		float precio = Float.parseFloat(request.getParameter("precio"));
		float iva = Float.parseFloat(request.getParameter("iva"));

		float precioConIva = precio * (iva + 100) / 100;

		request.setAttribute("precio", precio);
		request.setAttribute("iva", iva);
		request.setAttribute("precioConIva", precioConIva);

		String vistaJSP = "ejercicios/ejercicio-calculadora.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);

	}

}
