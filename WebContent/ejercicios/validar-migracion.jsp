<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>


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
      
			<%@include file="../includes/mensaje.jsp" %>
			
			<form action="migracion" method="POST">				
				<input type="submit" value="Migracion">
				${tiempo}
			</form>
			


    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>