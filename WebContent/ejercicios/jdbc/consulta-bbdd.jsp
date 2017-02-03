<%@page import="com.ipartek.formacion.recetas.controller.VehiculosCRUDController"%>
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
			
			Ejercicio para realizar a pelo una consulta en BBDD: <code>SELECT * FROM `vehiculo`</code> <br>
			
			
			Además de poder insertar nuevos mediante este formulario: <br>
			<code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, ?, '5', '1500');</code><br>
			<p> Cuando creemos el PreparedStatement reemplaremos el <b>?</b> por el campo del formulario.</p>
			<br>
			
			<form action="jdbc" method="post">
				<input type="text" name="modelo" required>
				<input type="submit" value="Crear Vehiculo">		
			</form>
			
			
			
			<h2>Listado Vehiculos</h2>
			



    </div> 
     <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
                
            </tr>
        </thead>
        <tbody>
         <c:forEach var="v" items="${vehiculos}">
            <tr>
                <td>${v.modelo}</td>
                <td>${v.plazas}</td>
                <td><fmt:formatNumber pattern="#,##0.00" value="${v.dimensiones}"></fmt:formatNumber></td>
                <td><fmt:formatNumber pattern="#,###0.000" value="${v.potencia}"></fmt:formatNumber></td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>