<%@page import="com.ipartek.formacion.recetas.controller.UsuarioController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>Filtro de Formulario</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
 		
 	<div class="container">
      <div class="row">
      
    <p><a href="zona-segura/usuario">Volver</a></p><br>
    
 	<form action="zona-segura/usuario" method="post">
        
        <label for="dni">dni :</label>
			<input type="text" name="dni" class="form-control" placeholder="Escribe un DNI"/>
			<br>
			<label for="email">E-Mail :</label>
			<input type="text" name="email" class="form-control" placeholder="Escribe un e-mail"/>
			<br>
			<label for="nombre_apellido">Nombre y Apellidos </label>
			<input type="text" name="email" class="form-control" placeholder="Escribe un nombre y los dos apellidos"/>
			<br>
			<label>Rango edad:</label>
			<input type="range" name="edad" min="1" max="130">
			<br>
			<input type="submit" value="Filtrar">
			</form>
 	    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>