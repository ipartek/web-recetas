package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.Utilidades;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Usuario;
/**
 * Servlet implementation class DadoController
 */
@WebServlet("/dado")
public class DadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static int NUM_MAX_ALUMNOS = 15;
	static String alumnoAfortunado;
	static String[] aAlumnos = { "Aaron", "Eneko", "Itsaso", "Ivan", "Guillermo", "Lozoya", "Josu", "Ignacio", "Gomez",
			"Nerea", "Nagore", "Garbiñe", "Egoitz", "Pavel", "Pérez" };
	static ArrayList<Usuario> aUsers = new ArrayList<Usuario>();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (aUsers.size() < 1) {
			inicializarArrayList();
		}
			
		Mensaje mensaje = new Mensaje();
		int numeroAleatorio = Utilidades.getNumeroAleatorio((aUsers.size() - 1));
		Usuario afortunado = aUsers.get(numeroAleatorio); 
		mensaje.setClase(mensaje.CLASE_INFO);
		mensaje.setDescripcion("El alumno que tiene que leer es: " + afortunado.getNombre());
		request.setAttribute("msj", mensaje);
		request.setAttribute("usuario", afortunado);
		request.getRequestDispatcher("ejercicios/dado.jsp").forward(request, response);

	}
	
	private void inicializarArrayList() {
		aUsers.clear();
		aUsers.add(new Usuario("Aaron"));
		aUsers.add(new Usuario("Eneko"));
		aUsers.add(new Usuario("Itsaso"));
		aUsers.add(new Usuario("Ivan"));
		aUsers.add(new Usuario("Guillermo"));
		aUsers.add(new Usuario("Lozoya"));
		aUsers.add(new Usuario("Josu"));
		aUsers.add(new Usuario("Ignacio"));
		aUsers.add(new Usuario("Gomez"));
		aUsers.add(new Usuario("Nerea"));
		aUsers.add(new Usuario("Nagore"));
		aUsers.add(new Usuario("Garbiñe"));
		aUsers.add(new Usuario("Egoitz"));
		aUsers.add(new Usuario("Pavel"));
		aUsers.add(new Usuario("Perez"));
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
