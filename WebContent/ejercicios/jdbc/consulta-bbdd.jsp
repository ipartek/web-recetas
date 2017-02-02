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
			
			<h2>Listado Vehiculos</h2>
			${vehiculos}



    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>