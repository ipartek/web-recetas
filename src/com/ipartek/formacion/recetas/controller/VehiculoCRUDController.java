package com.ipartek.formacion.recetas.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;
import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculoArraylist;
import com.ipartek.formacion.recetas.services.VehiculoServiceObjectStream;

/**
 * Servlet implementation class VehiculoCRUDController
 */
@WebServlet("/vehiculo")
public class VehiculoCRUDController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/form.jsp";
    
	//Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_GUARDAR = "4";
	public static final String OP_ELIMINAR = "5";
	
	Vehiculo v;
	Mensaje mensaje = new Mensaje();

	private static ServiceVehiculo service;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = VehiculoServiceObjectStream.getInstance();
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
				
				String pPotencia = request.getParameter("potenciacrear");
				String pDimensiones = request.getParameter("dimensiones");
				
				Float potencia = Float.valueOf(pPotencia.replace(",","."));
				
				v = new Vehiculo();
				v.setId(Long.valueOf(request.getParameter("id")));
				v.setModelo(request.getParameter("modelocrear"));
				v.setPlazas(Integer.valueOf(request.getParameter("plazascrear")));
				
				v.setPotencia(potencia);
				
				mensaje.setClase(mensaje.CLASE_SUCCESS);
				
				
				if(v.getId() > 0){
					
					if(service.update(v)){
						mensaje.setDescripcion("Modificado correctamente");
					}else{
						mensaje.setClase(mensaje.CLASE_DANGER);
						mensaje.setDescripcion("Error al modificar");
					}
					
				}else{
					
					if(service.create(v)){
						mensaje.setDescripcion("Coche creado correctamente");
					}else{
						mensaje.setClase(mensaje.CLASE_DANGER);
						mensaje.setDescripcion("Error al crear");
					}
					
				}
				
				
			} catch (VehiculoException e) {
				
				mensaje.setClase(mensaje.CLASE_DANGER);
				mensaje.setDescripcion(e.getMessage());
				
			} catch (Exception e) {
				
				mensaje.setClase(mensaje.CLASE_DANGER);
				mensaje.setDescripcion("Upps ha habido algun error, lo sentimos...");
				
				
			}finally{
				request.setAttribute("msj", mensaje);
				request.setAttribute("vehiculos", service.getAll());
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
			request.setAttribute("vehiculos", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			
			break;
			
			
		default:
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
