package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/files")
public class FicheroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String EXTENSION = ".txt";
	public static final String PATH = "c:\\desarrollo\\workspace\\web-recetas\\ficheros\\";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;
		try {
			msj = new Mensaje();

			// Recoger parametros
			String file = request.getParameter("file");

			// Abrir fichero y asociar buffer
			FileReader fr = new FileReader(PATH + file);
			BufferedReader bf = new BufferedReader(fr);

			// Leer Linea a linea
			String linea = null;
			String contenido = null;
			while ((linea = bf.readLine()) != null) {
				contenido += linea;
			}

			bf.close();
			fr.close();

			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero Leido con Exito");

			request.setAttribute("msj", msj);
			request.setAttribute("filename", file);
			request.setAttribute("filecontent", contenido);

		} catch (Exception e) {
			e.printStackTrace();
			msj = new Mensaje();
			msj.setDescripcion(e.getMessage());

		} finally {

			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/leer-fichero.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		FileWriter fw = null;
		try {
			msj = new Mensaje();

			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");

			// crear fichero
			fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero creado: <b>" + pNombre + EXTENSION + "</b> <br> ruta: " + PATH);

		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {

			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/crear-fichero.jsp").forward(request, response);
		}

	}

}