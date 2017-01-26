<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>

    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Gestion de Paginas de Error</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      <p>Cuando se lanza un excepcion en una JSP se puede redirigir a una pagina de error.</p>
      <p>Debemos usar las directivas <code>&lt;%@page errorPage%&gt;</code> y <code>&lt;%@page isErrorPage%&gt;</code> </p>
      <p>Mirar en el libro pagina 286.</p>

	  <p><a href="ejercicios/error-lanza-exception.jsp">Ir a JSP que lanza una Exception</a></p>	
    	
  
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>