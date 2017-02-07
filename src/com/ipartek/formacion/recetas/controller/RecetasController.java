package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.ipartek.formacion.recetas.services.ServiceReceta;
import com.ipartek.formacion.recetas.services.ServiceRecetasMysql;
import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculoMysql;

/**
 * Servlet implementation class RecetasController
 */
@WebServlet("/recetas")
public class RecetasController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_LIST = "ejercicios/recetas/lista-recetas.jsp";
	private static final String VIEW_FORM = "ejercicios/recetas/formrecetas.jsp";
    
	//Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	
	Receta r;
	Mensaje mensaje = new Mensaje();

	private static ServiceReceta service;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//service = VehiculoServiceObjectStream.getInstance();
		service = ServiceRecetasMysql.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		service = null;
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//esto se hace antes de realizar doget o dopost
		super.service(arg0, arg1);
		//esto se hace tras realizar doget o dopost
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//buscar operacion a realizar
		String op = (request.getParameter("op") == null)?OP_LISTAR : request.getParameter("op");
		
		switch (op){
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
				r.setTitulo(request.getParameter("titulocrear"));
				r.setImagen(request.getParameter("imagencrear"));
				r.setTiempo(Integer.valueOf(request.getParameter("tiempocrear")));
				r.setDificultad(request.getParameter("dificultadcrear"));
				r.setComensales(Integer.valueOf(request.getParameter("comensalescrear")));
				r.setDescripcion(request.getParameter("descripcioncrear"));
				
				mensaje.setClase(mensaje.CLASE_SUCCESS);
				
				
				if(r.getId() > 0){
					
					if(service.update(r)){
						mensaje.setDescripcion("Modificado correctamente");
					}else{
						mensaje.setClase(mensaje.CLASE_DANGER);
						mensaje.setDescripcion("Error al modificar");
					}
					
				}else{
					
					if(service.create(r)){
						mensaje.setDescripcion("Coche creado correctamente");
					}else{
						mensaje.setClase(mensaje.CLASE_DANGER);
						mensaje.setDescripcion("Error al crear");
					}
					
				}
				
			}catch (Exception e) {
				
				mensaje.setClase(mensaje.CLASE_DANGER);
				mensaje.setDescripcion("Upps ha habido algun error, lo sentimos...");
				
				
			}finally{
				request.setAttribute("msj", mensaje);
				request.setAttribute("recetas", service.getAll());
				request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			}
			
			break;
			
		case OP_ELIMINAR:
			
			long idcoche = Long.valueOf(request.getParameter("id"));
			
			if(service.delete(idcoche)){
				mensaje.setDescripcion("Eliminado correctamente");
			}else{
				mensaje.setClase(mensaje.CLASE_DANGER);
				mensaje.setDescripcion("Error al eliminar");
			}
			
			request.setAttribute("msj", mensaje);
			request.setAttribute("recetas", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			
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
