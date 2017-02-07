package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceReceta;
import com.ipartek.formacion.recetas.services.ServiceRecetaMySql;

/**
 * Servlet implementation class RecetasCRUDController
 */
@WebServlet("/recetas")
public class RecetasCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VIEW_LIST = "ejercicios/receta/index.jsp";
	private static final String VIEW_FORM = "ejercicios/receta/form.jsp";
    
	//Operaciones que pueda realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	
	private boolean accion;
	private Long id;
	private Receta r;
	private Mensaje mensaje = new Mensaje();
	RequestDispatcher dispatcher = null;

	
	private static ServiceReceta service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = ServiceRecetaMySql.getInstance();
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
			request.setAttribute("receta", new Receta());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
		
		case OP_VER_DETALLE:
			long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("receta", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;
			
		case OP_GUARDAR:
			try {
			r = new Receta();
			r.setId(Long.valueOf(request.getParameter("id")));
			r.setTitulo(request.getParameter("nombre"));
			
			mensaje.setClase(Mensaje.CLASE_SUCCESS);
			if (r.getId() > 0) {
				accion = service.update(r);
				if (accion) {
					mensaje.setDescripcion("Receta actualizada correctamente");
				} else {
					mensaje.setClase(Mensaje.CLASE_WARNING);
					mensaje.setDescripcion("No se ha podido actualizar la receta");
				}
			} else {
				
				accion = service.create(r);
				if (accion) {
					mensaje.setDescripcion("Receta creada correctamente");
				} else {
					mensaje.setClase(Mensaje.CLASE_WARNING);
					mensaje.setDescripcion("No se ha podido crear la receta correctamente");
				}
			}
				request.setAttribute("recetas", service.getAll());
				dispatcher = request.getRequestDispatcher(VIEW_LIST);
			
			} catch(Exception e) {
				mensaje.setClase(Mensaje.CLASE_DANGER);
				mensaje.setDescripcion(e.getMessage());
				if(r.getId()!=-1) {
					request.setAttribute("receta", service.getById(r.getId()));
				} else {
					request.setAttribute("receta", r);
				}
				dispatcher = request.getRequestDispatcher(VIEW_FORM);
			} finally {
				request.setAttribute("msj", mensaje);
				
				dispatcher.forward(request, response);
			}
			break;
			
		case OP_ELIMINAR:
			
			id = Long.valueOf(request.getParameter("id"));
			accion = service.delete(id);
			if (accion) {
				mensaje.setClase(Mensaje.CLASE_SUCCESS);
				mensaje.setDescripcion("Receta eliminada");
			} else  {
				mensaje.setClase(Mensaje.CLASE_DANGER);
				mensaje.setDescripcion("No se ha podido borrar la receta");
			}
			request.setAttribute("msj", mensaje);
			request.setAttribute("recetas", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
			
		default:
			//listar
			request.setAttribute("recetas", service.getAll());
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
