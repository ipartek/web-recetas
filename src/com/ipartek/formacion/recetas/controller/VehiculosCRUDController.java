package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.VehiculoException;
import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculoArrayList;

/**
 * Servlet implementation class VehiculosCRUDController
 */
@WebServlet("/vehiculo")
public class VehiculosCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Vistas
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";   
    
	//Operaciones que pueda realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	
	private boolean accion;
	private Long id;
	private Vehiculo v;
	private Mensaje mensaje = new Mensaje();
	
	private static ServiceVehiculo service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceVehiculoArrayList.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		service = null;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Antes de Realizar doGet o doPost

		super.service(req, res);
		// Tras realizar doGet o doPost

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		if(op == null){
			op = OP_LISTAR;
		}
		
		switch(op) {
		
		case OP_VER_NUEVO:
			request.setAttribute("vehiculo", new Vehiculo());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
		
		case OP_VER_DETALLE:
			long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("vehiculo", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
			
		case OP_GUARDAR:
			try {
			v = new Vehiculo();
			v.setId(Long.valueOf(request.getParameter("id")));
			v.setModelo(request.getParameter("modeloCrear"));
			v.setPlazas(Integer.parseInt(request.getParameter("plazasCrear")));
			v.setPotencia(Float.parseFloat(request.getParameter("potenciaCrear")));
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			if (v.getId() > 0) {
				accion = service.update(v);
				if (accion) {
					mensaje.setDescripcion("Coche actualizado correctamente");
				} else {
					mensaje.setClase(Mensaje.CLASE_WARNING);
					mensaje.setDescripcion("No se ha podido actualizar el coche");
				}
			} else {
				
				accion = service.create(v);
				if (accion) {
					mensaje.setDescripcion("Coche creado correctamente");
				} else {
					mensaje.setClase(Mensaje.CLASE_WARNING);
					mensaje.setDescripcion("No se ha podido crear el coche correctamente");
				}
			}
			
			} catch(VehiculoException e) {
				mensaje.setClase(Mensaje.CLASE_DANGER);
				mensaje.setDescripcion(e.getMessage());
			} catch(Exception e) {
				mensaje.setClase(Mensaje.CLASE_DANGER);
				mensaje.setDescripcion("Ha fallado algo inesperado");
			} finally {
				request.setAttribute("msj", mensaje);
				request.setAttribute("vehiculos", service.getAll());
				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			}
			break;
			
		case OP_ELIMINAR:
			
			id = Long.valueOf(request.getParameter("id"));
			accion = service.delete(id);
			if (accion) {
				mensaje.setClase(Mensaje.CLASE_SUCCESS);
				mensaje.setDescripcion("Coche eliminado");
			} else  {
				mensaje.setClase(Mensaje.CLASE_DANGER);
				mensaje.setDescripcion("No se ha podido borrar el coche");
			}
			request.setAttribute("msj", mensaje);
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
			
		default:
			//listar
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
