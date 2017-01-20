package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet(description = "Servlet para el saludo usando peticion get y post", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		PrintWriter out = response.getWriter();
		out.append("Hola, Bienvenido " + request.getParameter("nombre") + " " + request.getParameter("ape1") + " " + request.getParameter("ape2"));
		*/
		
		//recoger parametros
		
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("ape1");
		String apellido2 = request.getParameter("ape2");
		
		//TODO validar parametros
		
		//enviar atributos a JSP
		request.setAttribute("nombre", nombre);
		request.setAttribute("ape1", apellido1);
		request.setAttribute("ape2", apellido2);
		
		
		//request interna (forward) a la JSP / ir a la JSP
		
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros
		String nombrepost = request.getParameter("nombre");
		String apellido1post = request.getParameter("ape1");
		String apellido2post = request.getParameter("ape2");
		
		//enviar atributos a JSP
		request.setAttribute("nombre", nombrepost);
		request.setAttribute("ape1", apellido1post);
		request.setAttribute("ape2", apellido2post);
		
		String vistaJSP = "ejercicios/primer-controlador.jsp";
		request.getRequestDispatcher(vistaJSP).forward(request, response);
	}

}
