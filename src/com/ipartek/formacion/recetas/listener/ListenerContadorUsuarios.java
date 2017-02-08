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
	

	public static ArrayList<Usuario> usuarioslogeados = null;
	
	
	
	public ListenerContadorUsuarios() {
		super();
		usuarioslogeados = new ArrayList();
	}

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Sesion creada");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    	System.out.println("Sesion destruida");// TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("atributo añadido");
    	
    	if("usuario".equals(se.getName())){
    		usuarioslogeados.add((Usuario) se.getValue());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("atributo removido");
    	if("usuario".equals(se.getName())){
    		usuarioslogeados.remove(se.getValue());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("atributo reemplazado");
         // TODO Auto-generated method stub
    }
	
}
