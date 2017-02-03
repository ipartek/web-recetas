<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


	<header>
    	<div class="container header-content">
        	<div class="row">
            	<div class="col-lg-12">
               		<h1>Proceso de Migracion de Personas</h1>
               	</div>
			</div>             
		</div> 
	</header> 

	<div class="container">
		<div class="row">
      		<p>descripcion.....</p><br>
      		
      		<form action="migracion" method="post">
      			<input type="submit" value="MIGRACION">
      		</form>
      		
      		<br>
      		<p>Se ha insertado X personas en la BBDD.</p>
      		<p>X personas incorrectas sin incluir en la BBDD.</p>
      		
      		${personas}
      		
		</div> 
		<!--  <div class="row"> -->
	</div>    
	<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>