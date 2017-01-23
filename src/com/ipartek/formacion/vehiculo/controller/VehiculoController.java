
package com.ipartek.formacion.vehiculo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
import com.ipartek.formacion.vehiculo.pojo.VehiculoException;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet(urlPatterns = { "/vehiculo" })
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("modelo", request.getParameter("modelo"));
			if (Integer.parseInt(request.getParameter("plazas")) < 0) {
				throw new VehiculoException("El numero de plazas tiene que ser mayor que 0");
			}
			if (Integer.parseInt(request.getParameter("dimensiones")) < 0) {
				throw new VehiculoException("La dimension que ser mayor que 0");
			}
			if (Integer.parseInt(request.getParameter("potencia")) < 0) {
				throw new VehiculoException("La potencia tiene que ser mayor que 0");
			}
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setPlazas(Integer.parseInt(request.getParameter("plazas")));
			vehiculo.setDimensiones(Float.parseFloat(request.getParameter("dimensiones")));
			vehiculo.setPotencia(Float.parseFloat(request.getParameter("potencia")));
			request.setAttribute("vehiculo", vehiculo);
		} catch (Exception e) {

			request.setAttribute("error", e.getMessage());
		} finally {
			String vistaJSP = "Ejercicios/indexVehiculo.jsp";
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}

	}

}