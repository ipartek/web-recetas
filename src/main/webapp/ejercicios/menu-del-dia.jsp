<%@include file="../includes/header.jsp" %>

<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>

<a href="index.jsp">Volver Inicio</a>


<p>Ejercicio básico para aprender como funciona una JSP.</p>
<p>Aprendermos a juntar HTML con Java, usando scriplets <code>&lt;% %&gt;</code></p>
<p>Tambien realizaremos <code>import</code> de la clase <code>Receta</code></p>


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





<%@include file="../includes/footer.jsp" %>








