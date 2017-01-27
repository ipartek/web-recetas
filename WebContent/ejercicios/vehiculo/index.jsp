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
      <!-- 
		<ol>
		<c:forEach items="${vehiculos}" var="v" >
        	<li>${v.modelo}</li>
    	</c:forEach>
		</ol>
		 -->
		 <a href="vehiculo?op=3">Crear</a>
		<table class="display data-table-mio" >
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehiculos}" var="v" >
            <tr>
                <td><a href="vehiculo?op=2&id=${v.id}">${v.modelo}</a></td>
                <td>${v.plazas}</td>
                <td>${v.dimensiones}</td>
                <td>${v.potencia}</td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
				
		
		<p>Usuario: ${sessionScope.usuario!=null ? sessionScope.usuario.nombre : "no conectado"}</p>
		
		<p>Total Vehiculos: ${fn:length(vehiculos)}</p>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p>
		
		

</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->



<%@include file="../../includes/footer.jsp" %>
