<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Proceso Migración Base Datos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      
			<%@include file="../../includes/mensaje.jsp" %>
			
			<p>Ejercicio para realizar una migración de BBDD: <code>SELECT * FROM `persona`</code> </p> <br>
			
			
			<form action="jdbc" method="post">
				<input type="submit" value= "Ejecutar migración">
			</form>
			
			<br><hr><br>
			
			<h2>Resultado de la migración</h2> <br>
			<p>Número de entradas de persona insertadas: </p> <!-- ${vehiculos} --> 
			<p>Número de entradas de persona incorrectas: </p> <!-- ${vehiculos} --> 
			<p>Número de entradas leidas: </p> <!-- ${vehiculos} --> <br>
			<p>Tiempo de ejecución de la migración: </p> <!-- ${vehiculos} --> <br>
			
			



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
