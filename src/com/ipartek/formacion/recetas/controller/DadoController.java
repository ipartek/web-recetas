package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.Utilidades;

/**
 * Servlet implementation class DadoController
 */
@WebServlet("/dado")
public class DadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int numeroAleatorio;
	private static String[] aAlumnos = { "Aaron", "Eneko", "Itsaso", "Ivan", "Guillermo", "Lozoya", "Josu", "Ignacio",
			"Gomez", "Nerea", "Nagore", "Garbieñe", "Egoitz", "Pavel", "Pérez" };

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numeroAleatorio = Utilidades.getNumeroAleatorio((aAlumnos.length - 1));
		request.setAttribute("afortunado", aAlumnos[numeroAleatorio]);
		request.getRequestDispatcher("ejercicios/dado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
