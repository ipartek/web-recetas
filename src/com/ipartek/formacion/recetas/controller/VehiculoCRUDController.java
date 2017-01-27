package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculo;
import com.ipartek.formacion.recetas.services.ServiceVehiculoArrayList;

/**
 * Servlet implementation class VehiculoCRUDController
 */
@WebServlet("/vehiculo")
public class VehiculoCRUDController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// vistas
	private static final String VIEW_LIST = "ejercicios/vehiculo/index.jsp";
	private static final String VIEW_FORM = "ejercicios/vehiculo/formulario.jsp";

	// Operaciones que puede realizar
	public static final String OP_LISTAR = "1";
	public static final String OP_VER_DETALLE = "2";
	public static final String OP_VER_NUEVO = "3";
	public static final String OP_CREAR_COCHE = "4";
	public static final String OP_ELIMINAR = "5";
	public static final String OP_EDITAR = "6";

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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Antes de Realizar doGet o doPost");
		super.service(req, resp);
		System.out.println("Tras realizar doGet o doPost");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// buscar operacion a realizar
		String op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR; // 1
		}

		switch (op) {

		case OP_VER_NUEVO: // 3
			request.setAttribute("vehiculo", new Vehiculo());
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		case OP_VER_DETALLE: // 2
			long id = Long.valueOf(request.getParameter("id"));
			request.setAttribute("vehiculo", service.getById(id));
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
			break;

		case OP_CREAR_COCHE: // 4

			// cogemos el valor minimo de ID que hemos definido y le sumamos 1
			id = Long.valueOf(request.getParameter("id")) + 1;

			// Creamos variables para que recojan la información de los
			// parámetros de los formularios.
			// el valueOf retorna un argumento de un atributo o un parámetro. En
			// este caso, son parámetros.
			// request.getParameter("parametro_a_evaluar") lo que hace es
			// recoger el parámetro en cuestión.
			//
			String modelo = String.valueOf(request.getParameter("modelo"));
			long plazas = Long.valueOf(request.getParameter("plazas"));
			long dimensiones = Long.valueOf(request.getParameter("dimensiones"));
			long potencia = Long.valueOf(request.getParameter("potencia"));

			// creamos un nuevo coche/vehiculo, usando la clase vehiculo
			// ya que es donde está todo el código de los vehículos y su
			// creación.
			Vehiculo coche = new Vehiculo();
			coche.setId(id);
			coche.setModelo(modelo);
			coche.setPlazas(plazas);
			coche.setDimensiones(dimensiones);
			coche.setPotencia(potencia);

			// Ahora llamamos al service que es donde está el arrayList etc con
			// toda la información
			// de los coches etc. Es donde deberemos introducir un nuevo ID,
			// nombre del coche, etc.
			// se le añade al service (arraylist) un nuevo atributo.
			// Hay que mencionarle el atributo vehículo y luego donde debe
			// añadirse.
			request.setAttribute("vehiculo", service.create(coche));

			// Ahora vamos a donde se encuentra la tabla y lo mostramos allí.
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);

		case OP_ELIMINAR: // 5

		case OP_EDITAR: // 6

		default:
			// listar
			request.setAttribute("vehiculo", service.getAll());
			request.getRequestDispatcher(VIEW_LIST).forward(request, response);
			break;
		}// end switch

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}