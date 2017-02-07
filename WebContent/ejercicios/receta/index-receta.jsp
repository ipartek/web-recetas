<%@page import="com.ipartek.formacion.recetas.controller.RecetaController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1> CRUD Recetas</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
	<%@include file="../../includes/mensaje.jsp" %>
	
	<a href ="receta?op=3">Crear nueva Receta.</a>

<table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Imagen</th>
                <th>Tiempo</th>
                <th>Comensales</th>
                <th>Dificultad</th>
                <th>Descripcion</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${recetas}">
            <tr>
                <td><a href="receta?op=2&id=${r.id}">${r.id}</a></td>
                <td>${r.titulo}</td>
                <td>${r.imagen}</td>
                <td>${r.tiempo}</td>
                <td>${r.comensales}</td>
                <td>${r.dificultad}</td>
                <td>${r.descripcion}</td>
                <td><a href="receta?op=5&id=${r.id}">Eliminar</a></td>
            </tr>
           </c:forEach>
       </tbody>
    </table>

	<br>
	<br>
		<c:set var="conectado" scope="session" value="${sessionScope.usuario.nombre}"/>
		<c:out value="Usuario: ${conectado}"></c:out>
		<c:if test="${sessionScope.usuario==null}">
		<c:out value="No conectado"></c:out>
		</c:if>
		
		
		
		
		<p>Total Recetas:${fn:length(recetas)}</p>
		
		<c:set var="now" value="<%=new java.util.Date()%>"/>
		<p>Fecha:<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p>
</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
