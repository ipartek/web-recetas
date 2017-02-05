package com.ipartek.formacion.recetas.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceMigrar {
	
	//Declaracion
	

	//Singleton
	private static ServiceMigrar INSTANCE;
	
	public static ServiceMigrar getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceMigrar();

		}
	}
	
	//Constructor
	private ServiceMigrar(){
		
	}
		
	/** @return Connection 
	 * @throws ClassNotFoundException
	 * @throws SQLException */
	public Connection abrirConexionBD() throws ClassNotFoundException, SQLException {
		final String URL = "jdbc:mysql://localhost:3306/concesionario";		
		final String DB_USER = "root";
		final String DB_PASS = "";
		final String DRIVER = "com.mysql.jdbc.Driver";
		Connection conn = null;
		
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
		
		return conn;
				
	}
	
	/** @param conn Connection
	 * @throws SQLException */
	public void cerrarConexionBD(Connection conn) throws SQLException {
		conn.close();	

	}	
	
	/** @param txt
	 * @return ArrayList<String[]>
	 * @throws FileNotFoundException
	 * @throws IOException */
	public ArrayList<String[]> leerArchivo(String txt) throws FileNotFoundException, IOException {
		FileReader fr;
		BufferedReader bf;
		String linea = null;
		String[] arrayLinea = null;
		ArrayList<String[]> arrayTabla = new ArrayList<String[]>();
		
		fr = new FileReader("C:/java/workspace/web-recetas/data/" + txt + ".txt");
		bf = new BufferedReader(fr);

		while ((linea = bf.readLine()) != null) {
			arrayLinea = linea.split(",");
			arrayTabla.add(arrayLinea);
			arrayLinea = null;
		}
		
		bf.close();
		fr.close();
		return arrayTabla;
		
	}
	
	/** @param conn Connection
	 * @param arrayTabla ArrayList<String[]> 
	 * @return ArrayList<String[]> 
	 * @throws SQLException */
	public ArrayList<String[]> insertarArchivo(Connection conn, ArrayList<String[]> arrayTabla ) throws SQLException {
		PreparedStatement pst;
		String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`,`apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , ? , ? , ? , ? , ? , ?);";
		ArrayList<String[]> sqlEquivocado = new ArrayList<String[]>();
		
		for (String[] strings : arrayTabla) {
	
				if (strings.length != 7) {
					sqlEquivocado.add(strings);
				
				} else {
					pst = conn.prepareStatement(sql);
					pst.setString(1, strings[0]);
					pst.setString(2, strings[1]);
					pst.setString(3, strings[2]);
					pst.setInt(4, Integer.parseInt(strings[3]));
					pst.setString(5, strings[4]);
					pst.setString(6, strings[5]);
					pst.setString(7, strings[6]);
					pst.executeUpdate();
					pst.close();
				}
				
		}
	return sqlEquivocado;
	}
	
	public void guardarIncompletas(ArrayList<String[]> sqlEquivocado) throws IOException{
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		fos = new FileOutputStream("C:/java/workspace/web-recetas/data/personas-incompletas.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(sqlEquivocado);
		oos.close();
		fos.close();

}
	
}
