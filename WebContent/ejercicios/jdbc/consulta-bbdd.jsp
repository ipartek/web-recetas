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
			
			Ejercicio para realizar a pelo una consulta en BBDD ademas de poder insertar nuevos mediante este formulario:<br>
			
			<code>SELECT * FROM `vehiculo`</code> <br>
			
			<code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, ?, '5', '1500');</code>
			
			<p>Cuando creemos el PreparedStatement reemplazaremos el <b>?</b> por el campo del formulario.
			
			<form action="jdbc" method ="post">
				<input type="text" name ="modelo" required>
				<input type="submit" value="Crear vehiculo">
			</form>
			
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
		                <td>${v.dimensiones}</td>      
		                <td>${v.potencia}</td>
		                
         		   </tr>
           </c:forEach>
       </tbody>
    </table>
			



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>