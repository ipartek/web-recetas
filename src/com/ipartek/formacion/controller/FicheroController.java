package com.ipartek.formacion.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/files")
public class FicheroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EXTENSION = ".txt";
	public static final String PATH = "c:\\desarrollo\\workspace\\web-recetas\\ficheros\\";
	private static final String PATH_2 = "/home/suglur/dat/Workspaces/eclipse/web-recetas/WebContent/files/";

	/**
	 * Busca un fichero ,y lo pinta
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;

		try {

			msj = new Mensaje();
			// recoger parametros

			String pFile = request.getParameter("file");

			// abrir y asociar al buffer
			FileReader file = new FileReader(PATH + pFile);
			BufferedReader bf = new BufferedReader(file);
			// leer linea
			String linea = "";
			String contenido = "";
			while ((linea = bf.readLine()) != null) {
				contenido += linea;

			}
			// cerrar buffer y file
			bf.close();
			file.close();
			// mensaje
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Leido con Exito");

			// pasar att jsp
			request.setAttribute("filename", pFile);
			request.setAttribute("filecontent", contenido);

		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/listar-ficheros.jsp").forward(request, response);
		}

	}

	/**
	 * Crea un fichero
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		FileWriter fw = null;
		try {

			msj = new Mensaje();
			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");

			// crear Fichero
			fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();
			// mensaje usuario
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero creado: <b>" + pNombre + EXTENSION + "</b> <br> ruta: " + PATH);
		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/crear-fichero-texto.jsp").forward(request, response);
		}

	}

}
