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
 * Servlet implementation class SaludoController
 */
@WebServlet(description = "Servlet para aprender a usar las peticiones GET y POST", urlPatterns = { "/crear-vehiculo" })
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje mensaje = null;
		String pModelo = "";
		String aPlazas = "";
		String aPotencia = "";

		try {

			mensaje = new Mensaje();

			// Recoger parametros.
			pModelo = request.getParameter("modelo");
			aPlazas = request.getParameter("plazas");
			aPotencia = request.getParameter("potencia");

			// Crear Vehiculo.
			Vehiculo v = new Vehiculo();

			v.setModelo(pModelo);
			v.setPlazas(Integer.parseInt(aPlazas));
			v.setPotencia(Float.parseFloat(aPotencia));

			// Enviar atributos a JSP.
			request.setAttribute("vehiculo", v);

			// mensaje success
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			mensaje.setDescripcion("¡Vehiculo creado con Exito!");

		} catch (NumberFormatException e) {
			mensaje.setDescripcion("Los parametros introducidos no son los correctos.");

		} catch (Exception e) {
			mensaje.setDescripcion(e.getMessage());
			e.printStackTrace();
		} finally {
			String vistaJSP = "ejercicios/crear-vehiculo.jsp";
			request.setAttribute("msj", mensaje);
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}
	}

}
