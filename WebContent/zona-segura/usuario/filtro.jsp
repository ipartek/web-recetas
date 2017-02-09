<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>Filtro</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
  	   
   <div class="container">

   	  
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form class="form-horizontal" action="zona-segura/usuario" method="post">
		
		
			<div class="form-group">
				<label for="inputDni" class="col-sm-2 control-label">Dni:</label>
					<div class="col-sm-10">
						<input type="text" id="inputDni" name="dni" value="">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="text" id="inputEmail" name="email"  value="">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputBusqueda" class="col-sm-2 control-label">Nombre y/o apellidos:</label>
					<div class="col-sm-10">
						<input type="text" id="inputBusqueda" name="busqueda"  value="">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEdad" class="col-sm-2 control-label">Edad:</label>
					<div class="col-sm-10">
						<input type="number" id="inputEdad" name="edadMin"  value="${usuarios.edadMin}">
						<input type="number" id="inputEdad" name="edadMax"  value="${usuarios.edadMax}">
					</div>
			</div>
			
			
						
			<div class="form-group">
   				<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="op" value="6">
						<input type="submit" value="Buscar">
				</div>
			</div>
		</form>
        
        
       <a href="zona-segura/usuario">Volver</a>
        
</div>
    </div> 
 

<%@include file="../../includes/footer.jsp" %>
