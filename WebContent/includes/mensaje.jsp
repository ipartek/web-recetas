<%@page import="com.ipartek.formacion.recetas.pojo.Mensaje"%>
<%
/** Gestion de Mensajes para el usuario.
Debemos enviar un atributo 'msj' desde el Servlet.
*/

if(request.getAttribute("msj") != null){
	Mensaje mensaje = (Mensaje)request.getAttribute("msj");
%>

<div class="alert alert <%=mensaje.getClase()%> alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <%=mensaje.getDescripcion() %>
</div>

<%
} //end if
%>