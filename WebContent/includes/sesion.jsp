<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>

<%
	// Gestion de mensajes para el usuario.
	// Debemos enviar un atributo 'msj' desde el Servlet.
	Usuario usuario = (Usuario)session.getAttribute("usuario");
	if (usuario != null){
		
%>
	<div class="sessionbar">
		<p><%=usuario.getNombre() %><img src="<%=usuario.getImagen() %>">   <a href="logout">Logout[(${sessionScope.usuario.nombre})]</a>
	
	
	
	
	
	</div>

<%
	} //endif
%>