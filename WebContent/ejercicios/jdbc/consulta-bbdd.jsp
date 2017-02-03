<%@include file="../../includes/header.jsp" %>
<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Conexion Base de datos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
<div class="container">
      <div class="row">
<%@include file="../../includes/Mensaje.jsp" %>
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
</div>

<%@include file="../../includes/footer.jsp" %>
<!-- nombre, apellido 1, apellido 2, edad, email, dni, puesto

separar con split.crear tabla persona, con un id automático. -->