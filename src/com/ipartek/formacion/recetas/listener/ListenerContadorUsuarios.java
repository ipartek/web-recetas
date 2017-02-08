package com.ipartek.formacion.recetas.listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.recetas.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class ListenerContadorUsuarios
 *
 */
@WebListener
public class ListenerContadorUsuarios implements HttpSessionListener, HttpSessionAttributeListener {

	// 192.168.0.16

	public static ArrayList<Usuario> usuariosLogeados = null;

	public ListenerContadorUsuarios() {
		super();
		usuariosLogeados = new ArrayList<Usuario>();
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session Creada");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destruida");
	}

	/**
	 * @see com.ipartek.formacion.recetas.controller.LoginController
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Atributo añadido");

		if ("usuario".equals(se.getName())) {
			// Se acaba de logear con exito un usuario nuevo
			usuariosLogeados.add((Usuario) se.getValue());
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Atributo destruido");

		if ("usuario".equals(se.getName())) {
			// Se acaba de logear con exito un usuario nuevo
			usuariosLogeados.remove((Usuario) se.getValue());
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
	}

}
