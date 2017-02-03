<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Proceso Migraci�n Base Datos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      
			<%@include file="../../includes/mensaje.jsp" %>
			
			<p>Ejercicio para realizar una migraci�n de BBDD: <code>SELECT * FROM `persona`</code> </p> <br>
			
			
			<form action="jdbc" method="post">
				<input type="submit" value= "Ejecutar migraci�n">
			</form>
			
			<br><hr><br>
			
			<h2>Resultado de la migraci�n</h2> <br>
			<p>N�mero de entradas de persona insertadas: </p> <!-- ${vehiculos} --> 
			<p>N�mero de entradas de persona incorrectas: </p> <!-- ${vehiculos} --> 
			<p>N�mero de entradas leidas: </p> <!-- ${vehiculos} --> <br>
			<p>Tiempo de ejecuci�n de la migraci�n: </p> <!-- ${vehiculos} --> <br>
			
			



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
