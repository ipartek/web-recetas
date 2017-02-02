<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Consulta Base Datos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      
			<%@include file="../../includes/mensaje.jsp" %>
			
			Ejercicio para realizar a pelo una consulta en BBDD:<br>
			
			<code>SELECT * FROM `vehiculo`</code> <br>
			
			<table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
                <th></th>
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
			
			
			<h2>Listado Vehiculos</h2>
			${vehiculos}



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>