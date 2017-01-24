
<%@page import="com.ipartek.formacion.vehiculo.pojo.Mensaje"%>
<%
 	/** 
 		Gestion de Mensajes para el usuario.<br>
 		Debemos enviar un atributo 'msj' desde el Servlet.<br>
 	*/
 
 	if( request.getAttribute("msj") != null ){
 		Mensaje mensaje = (Mensaje)request.getAttribute("msj");
 %>
 
 	<div class="alert <%=mensaje.getClase()%> alert-dismissible" role="alert">
 		  <%=mensaje.getDescripcion()%>
 	</div>
 
 <%
 	} //end if	
 %>