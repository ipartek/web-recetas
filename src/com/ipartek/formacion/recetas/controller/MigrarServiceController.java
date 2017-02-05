package com.ipartek.formacion.recetas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.services.ServiceMigrar;

/** Servlet implementation class MigrarServiceController */
@WebServlet("/migracion2")
public class MigrarServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceMigrar service;
	private static Mensaje msj;
	private static Connection conn;
	private static ArrayList<String[]> personas;
	private static ArrayList<String[]> personasErroneas;
       
	@Override
	public void init() throws ServletException {
		super.init();
		service = ServiceMigrar.getInstance();
		msj = new Mensaje();
		personas = new ArrayList<String[]>();
		personasErroneas = new ArrayList<String[]>();
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		service = null;
		msj = null;
		personas = null;
		personasErroneas = null;
		
	}

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			conn = service.abrirConexionBD();
			personas = service.leerArchivo("personas");
			personasErroneas= service.insertarArchivo(conn, personas);
			service.guardarIncompletas(personasErroneas);
			service.cerrarConexionBD(conn);
			
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Migracion Correcta");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "driver no funciona ");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "no encuentra archivo personas" );
			
		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "problemas al insertar datos");
			
		}finally{
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/validar-migracion.jsp").forward(request, response);
			
		}
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
