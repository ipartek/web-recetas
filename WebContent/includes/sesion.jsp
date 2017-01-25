<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>
<%
	Usuario usuar = (Usuario)session.getAttribute("usuario");
	if( session.getAttribute("usuario") != null ){		
%>
	<div class="sessionbar">
		<p><%=usuar.getNombre()%> <a href="logout">[X]</a><img src="<%=usuar.getImagen()%>"></p>
	</div>
<% 	
    }else{} 
%>