package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class ExceptionController */
@WebServlet(description = "Controlador para probar como se capturan las excepciones y se configuran desde web.xml", 
urlPatterns = { "/exception" })

public class ExceptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletRespons response)*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		if ("1".equals(request.getParameter("p"))) {
			//EXCEPTION Object o = null;
			//EXCEPTION o.toString();
		} else {

			//EXCEPTION throw new VehiculoException("Carlos trata de arrancarlo");
		}
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}