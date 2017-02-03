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
			
			Ejercicio para realizar a pelo una consulta en BBDD <code>SELECT * FROM `vehiculo`</code><br>
			Además poder insertar nuevos mediante este formulario: <br><code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL,  ? , '5', '1500');</code><br>
			<p>Cuando creemos el <code>PreparedStamtement</code> reemplazaremos el <b>?</b> por el campo del formulario.</p>			
			<form action="jdbc" method="post"> 
				<input type="text" name="modelo" required>
				<input type="submit" value="Crear Vehiculo">
			</form>
			
			<h2>Listado Vehiculos</h2>
			${vehiculos}



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
