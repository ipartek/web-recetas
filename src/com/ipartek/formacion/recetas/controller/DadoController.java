package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DadoController
 */
@WebServlet("/dado")
public class DadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static int NUM_MAX_ALUMNOS = 15;
	static String alumnoAfortunado;
	static String[] aAlumnos = { "Aaron", "Eneko", "Itsaso", "Ivan", "Guillermo", "Lozoya", "Josu", "Ignacio", "Gomez",
			"Nerea", "Nagore", "Garbieñe", "Egoitz", "Pavel", "Pérez" };
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Mensaje mensaje = new Mensaje();
//		int numeroAleatorio = Utilidades.getNumeroAleatorio((aAlumnos.length - 1));
//		alumnoAfortunado = aAlumnos[numeroAleatorio]; 
//		mensaje.setClase(mensaje.CLASE_INFO);
//		mensaje.setDescripcion("El alumno que tiene que leer es: " + alumnoAfortunado);
//		request.setAttribute("msj", mensaje);
//		request.getRequestDispatcher("ejercicios/dado.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
