 <%@include file="../includes/header.jsp" %>
  
 <%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>

<%@include file="../includes/nav.jsp" %>

<a href="index.jsp">Volver Inicio</a>


<%
	//esto es un scriplet y sirve para escribir java
	for ( int i=1; i <= 6; i++ ){
		out.print("<h"+i+">Cabecera H"+i+" </h"+i+">");
	}

	String saludo = "Ongi Etorri";

%>

<p>Saludo: <%=saludo%></p>


<%
	Receta  marmitako = new Receta("marmitako");
	//TODO meter ingredientes y resto de atributos
	marmitako.setImagen("http://www.clubcampos.com/upload/recetas/gourmet_elaboradas/MarmitakodeAtunCampos.jpg");
	
	
%>

<h2><%=marmitako.getTitulo()%></h2>

<img src="<%=marmitako.getImagen()%>" />














