<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Migración</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      
			<%@include file="../../includes/mensaje.jsp" %>
			
			<p>Ejercicio para realizar una migración de datos desde un fichero de texto a una Base Datos.</p>
			<p>Aprenderemos ha realizar transacciones atomicas, con <code>commit</code> y <code>rollback</code></p>
			<form action="migracion" method="post">				
				<input type="submit" value="Lanzar Proceso">
				${tiempo}
			</form>
			


    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
