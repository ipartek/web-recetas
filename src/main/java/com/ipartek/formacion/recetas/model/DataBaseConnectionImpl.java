package com.ipartek.formacion.recetas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionImpl implements DataBaseConnection {

	private Connection conexion;
	private static DataBaseConnectionImpl INSTANCE = null;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	private static final String USER = "root";
	private static final String PASS = "";

	private DataBaseConnectionImpl() {
		conexion = null;
		conectar();
	}

	public static DataBaseConnectionImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}

		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DataBaseConnectionImpl();
		}
	}

	@Override
	public void conectar() {

		if (conexion == null) {
			try {
				Class.forName(DRIVER);
				conexion = DriverManager.getConnection(URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				System.out.println("Falta libreria para driver " + DRIVER);
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("No se puede establecer conexion " + URL);
				e.printStackTrace();
			}
		}

	}

	@Override
	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar conexion");
				e.printStackTrace();
			}
		}

	}

	@Override
	public Connection getConexion() {
		conectar();
		return conexion;
	}

}
