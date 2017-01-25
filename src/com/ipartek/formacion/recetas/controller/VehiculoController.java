package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/crear-vehiculo")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VIEW_CREAR_VEHICULO = "ejercicios/crear-vehiculo.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Mensaje mensaje = null;
			String pModelo = "";
			String pPlazas = "";
			String pPotencia = "";
			try {
				mensaje = new Mensaje();
				// recoger parametros
				pModelo = request.getParameter("modelo");
				pPlazas = request.getParameter("plazas");
				pPotencia = request.getParameter("potencia");
				
				//crear vehiculo
				Vehiculo v = new Vehiculo();
				v.setModelo(pModelo);
				v.setPlazas(Integer.parseInt(pPlazas));
				v.setPotencia(Float.parseFloat(pPotencia));
				request.setAttribute("vehiculo",v);
				
				//mensaje success
				mensaje.setClase(Mensaje.CLASE_SUCCESS);
				mensaje.setDescripcion("Vehiculo creado con Exito!");
				
				
			} catch (NumberFormatException e) {
				mensaje.setDescripcion("Los parametros introducidos no son correctos.");
				e.printStackTrace();
			} catch (Exception e) {
				mensaje.setDescripcion(e.getMessage());
				e.printStackTrace();
			} finally {
				request.setAttribute("msj", mensaje);
				request.getRequestDispatcher(VIEW_CREAR_VEHICULO).forward(request, response);
			}
	}

}
