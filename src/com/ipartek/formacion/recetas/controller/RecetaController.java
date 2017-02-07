package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceReceta;

/**
 * Servlet implementation class RecetaController
 */
@WebServlet("/receta")
public class RecetaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_LIST = "ejercicios/receta/index.jsp";
	private static final String VIEW_FORM = "ejercicios/receta/formulario.jsp";
	private static ServiceReceta service;
	
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	
       @Override
    public void init() throws ServletException {  	   
    	super.init();
    	service = ServiceReceta.getInstance();
    }
       
       @Override
    public void destroy() {
    	super.destroy();
    	service = null;
    }
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Operacion a realizar
				String op = request.getParameter("op");
				Mensaje msg = new Mensaje();
				if (op == null) {
					op = OP_LISTAR;
				}
				switch (op) {

				case OP_ELIMINAR:

					if (service.delete(Long.parseLong(request.getParameter("id")))) {
						msg.setClase(Mensaje.CLASE_SUCCESS);
						msg.setDescripcion("Eliminado correctamente");
						request.setAttribute("msj", msg);
					}

					request.setAttribute("recetas", service.getAll());
					request.getRequestDispatcher(VIEW_LIST).forward(request, response);
					break;

				case OP_GUARDAR:
					Receta r = null;
					try {
						r = new Receta();
						r.setId(Integer.parseInt(request.getParameter("id")));
						r.setTitulo(request.getParameter("titulo"));
						r.setImagen(request.getParameter("imagen"));
						r.setComensales(Integer.parseInt(request.getParameter("comensales")));
						r.setTiempo(Integer.parseInt(request.getParameter("tiempo")));
						r.setDificultad(request.getParameter("dificultad"));
						r.setDescripcion(request.getParameter("descripcion"));
						
						if (Integer.parseInt(request.getParameter("id")) == -1) {
							if (service.create(r)) {
								msg.setClase(Mensaje.CLASE_SUCCESS);
								msg.setDescripcion("Creado correctamente");
								request.setAttribute("msj", msg);
							}
						} else {
							if (service.update(r)) {
								msg.setClase(Mensaje.CLASE_SUCCESS);
								msg.setDescripcion("Modificado correctamente");
								request.setAttribute("msj", msg);
							}
						}

						request.setAttribute("recetas", service.getAll());
						request.getRequestDispatcher(VIEW_LIST).forward(request, response);

					} catch (NumberFormatException e) {
						msg.setClase(Mensaje.CLASE_DANGER);
						msg.setDescripcion(e.getMessage());
						e.printStackTrace();
						request.setAttribute("msj", msg);
						request.setAttribute("op", OP_VER_DETALLE);
						request.setAttribute("recetas", r);
						request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					}

					break;

				case OP_VER_NUEVO:
					request.setAttribute("recetas", new Receta());
					request.setAttribute("op", OP_VER_NUEVO);
					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					break;

				case OP_VER_DETALLE:
					long id = Long.parseLong(request.getParameter("id"));
					request.setAttribute("recetas", service.getById(id));
					request.setAttribute("op", OP_VER_DETALLE);
					request.getRequestDispatcher(VIEW_FORM).forward(request, response);
					break;

				default:
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
