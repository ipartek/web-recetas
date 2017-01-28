package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Servlet implementation class LogoutController */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//getSesion
		HttpSession session = request.getSession();
		//Cerrar HttpSession
		session.invalidate();
		session = null;

		response.sendRedirect("index.jsp");
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}