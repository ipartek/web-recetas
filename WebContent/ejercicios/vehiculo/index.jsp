<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1> CRUD Vehiculo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
	<%@include file="../../includes/mensaje.jsp" %>
	
<table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
                <th><a href ="vehiculo?op=3">Crear nuevo Vehiculo.</a></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="v" items="${vehiculos}">
            <tr>
                <td><a href="vehiculo?op=2&id=${v.id}">${v.modelo}</a></td>
                <td>${v.plazas}</td>
                <td>${v.dimensiones}</td>      
                <td>${v.potencia}</td>
                <td><a href="vehiculo?op=5&id=${v.id}">Eliminar</a></td>
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
		
		
		
		
		<p>Total Vehiculos:${fn:length(vehiculos)}</p>
		
		<c:set var="now" value="<%=new java.util.Date()%>"/>
		<p>Fecha:<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p>
</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->






































<%@include file="../../includes/footer.jsp" %>