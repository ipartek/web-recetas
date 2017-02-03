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
			
			<p>Ejercicio para realizar a pelo una consulta en BBDD:</p>
			
			<code>SELECT * FROM `vehiculo`</code> <br><br>
			
			<p>Además de poder insertar nuevos mediante este formulario:</p>
			<code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, ? , '5', '1500');</code> <br><br>
			
			<p>Cuando creemos el <code>PreparedStatement</code> reemplazaremos el <b>?</b> por el campo del formulario</p><br>
			<form action="jdbc" method="post">
				<input type="text" name="modelo" required>	
				<input type="submit" value="Crear Vehiculo">
			</form>
			
			<h2>Listado Vehiculos</h2>
			${vehiculos}
			
			<table class="display data-table-mio miTabla">
			
			</table>



	    </div> 
	    <!--  <div class="row"> -->
	</div>    
	<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>