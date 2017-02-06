package com.ipartek.formacion.model;

import java.sql.Connection;

public interface DataBaseConnection {

	void conectar();

	void desconectar();

	Connection getConexion();

}