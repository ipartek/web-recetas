package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;

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
		
		Vehiculo V = new Vehiculo();
		
		try{
			
			V.setModelo(request.getParameter("modelo"));
			V.setPlazas(Integer.valueOf(request.getParameter("plazas")));
			V.setPotencia(Integer.valueOf(request.getParameter("potencia")));
			request.setAttribute("vehiculo", V);
			
		}catch(VehiculoException e){
			request.setAttribute("error", e.getMessage());
			
		}catch(Exception e){
			request.setAttribute("error", "Se produjo un error al crear el vehiculo");
			
			
		}finally{
			String vistaJSP = "ejercicios/crearvehiculo.jsp";
			request.getRequestDispatcher(vistaJSP).forward(request, response);
		}
	}
}
