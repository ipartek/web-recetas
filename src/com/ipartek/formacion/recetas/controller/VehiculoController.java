package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.VehiculoException;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/crear-vehiculo")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Vehiculo v = new Vehiculo();
			try {
				// recoger paramteros
				v.setModelo(request.getParameter("modelo"));
				v.setPlazas(Integer.valueOf(request.getParameter("plazas")));
				v.setPotencia(Integer.valueOf(request.getParameter("potencia")));
				// enviar atributos a JSP
				request.setAttribute("vehiculo",v);
				
				if (!"".equals(v.getModelo()))
					request.setAttribute("bien", "Coche creado correctamente!");
			} catch (VehiculoException e) {
				request.setAttribute("error", e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				request.setAttribute("error", "Se produjo un error! lo sentimos");
				e.printStackTrace();
			} finally {
				String vistaJSP = "ejercicios/crearvehiculo.jsp";
				request.getRequestDispatcher(vistaJSP).forward(request, response);
			}
	}

}
