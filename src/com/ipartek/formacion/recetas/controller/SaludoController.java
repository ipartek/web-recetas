package com.ipartek.formacion.recetas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet(description = "Servlet para aprender a usar las peticiones GET y POST", urlPatterns = { "/saludo" })
public class SaludoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Esto lo pinta por pantalla pero hay que ir uno a uno. Se queda para
		 * ver como se hace por si en algún momento esto fuese útil. PrintWriter
		 * out = response.getWriter();
		 * 
		 * out.append("Petición GET: <br>"); // escribe out.append(
		 * "Parámetros: <br>");// escribe out.append("nombre " +
		 * request.getParameter("nombre") + "<br>");// escribe // nombre // y //
		 * mediante // request.getParameter("nombre") // agarra // el //
		 * parámetro // definido // entre // las // comillas // (nombre). // Hay
		 * // que // escribir // el // parámetro // exactamente // como //
		 * aparece. out.append("primer apellido " + request.getParameter("ape1")
		 * + "<br>");// escribe // nombre // y // mediante //
		 * request.getParameter("Ape1") // agarra // el // parámetro // definido
		 * // entre // las // comillas // (Ape1). // Hay // que // escribir //
		 * el // parámetro // exactamente // como // aparece. out.append(
		 * "primer apellido " + request.getParameter("ape2") + "<br>"); // leer
		 * // la // explicación // anterior
		 */
		// para
		// comprender
		// response.getWriter().append("petición GET: ");
		// forma mas elegante y mejor de hacer lo anterior
		// recoger parametros. Mirar gráfico página 17 de apuntes ("libreta")
		// para comprender parametros y atributos.
		// Recojamos ahora los parametros.
		/*
		 * *********************************************************************
		 * **************** GET
		 ************************************************************************************/
		String pNombre = request.getParameter("nombre");
		String pApe1 = request.getParameter("Ape1");
		String pApe2 = request.getParameter("Ape2");

		// TODO validar parametros

		// enviar atributos a JSP

		request.setAttribute("nombre", pNombre.toUpperCase());
		request.setAttribute("Ape1", pApe1.toUpperCase());
		request.setAttribute("Ape2", pApe2.toUpperCase());

		// request interna (forward) la JSP, ir a la JSP. Forward es como se le
		// llama a esta acción.
		String vistaJSP = "ejercicios/primer-Controlador.jsp"; // hay
																// que
		// especificar
		// la carpeta
		request.getRequestDispatcher(vistaJSP).forward(request, response);

		/*
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 * *********************************************************************
		 * *****************
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PARA POST

		try {
			String pNombre2 = request.getParameter("nombre2");

			// TODO validar parametros

			// enviar atributos a JSP

			request.setAttribute("nombre2", pNombre2.toLowerCase());

			// FIN DEL POST

			// primer apellido
			String ape1 = request.getParameter("apel1");
			request.setAttribute("apel1", ape1.toLowerCase());
			// Segundo apellido
			String ape2 = request.getParameter("apel2");
			request.setAttribute("apel2", ape2.toLowerCase());

		} catch (Exception e) {
			request.setAttribute("error", "Se produjo un error, lo sentimos");
			e.printStackTrace();
		} finally {
			// donde va todo
			// request interna (forward) la JSP, ir a la JSP. Forward es como se
			// le
			// llama a esta acción.
			String vistaJSP2 = "ejercicios/primer-Controlador.jsp"; // hay que
			// especificar
			// la carpeta
			request.getRequestDispatcher(vistaJSP2).forward(request, response);
		}

	}

}
