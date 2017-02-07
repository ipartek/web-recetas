<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Zona Segura</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
			<p>* No deberias poder acceder a esta url a menos que estes logeado.</p>
			<p>Usamos un filtro <code>FilterZonaSegura</code> para comprobar la seguridad en las urls <code>/zona-segura/*</code></p>
			<p>Usted esta logeado como:</p>
			<p>${usuario.nombre}</p>
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		