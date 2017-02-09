<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>Usuarios</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
  	   
   <div class="container">

   	  <a href="zona-segura/usuario">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form class="form-horizontal" action="zona-segura/usuario" method="post">
		
		
			<div class="form-group">
				<label for="inputId" class="col-sm-2 control-label">Id:</label>
					<div class="col-sm-10">
						<input type="text" id="inputId" name="id" readonly value="${usuarios.id}">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputNombre" class="col-sm-2 control-label">Nombre:</label>
					<div class="col-sm-10">
						<input type="text" id="inputNombre" name="nombre" required="required" value="${usuarios.nombre}">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputApellido1" class="col-sm-2 control-label">Primer apellido:</label>
					<div class="col-sm-10">
						<input type="text" id="inputApellido1" name="apellido1" required="required" value="${usuarios.apellido1}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputApellido2" class="col-sm-2 control-label">Segundo apellido:</label>
					<div class="col-sm-10">
						<input type="text" id="inputApellido2" name="apellido2" required="required" value="${usuarios.apellido2}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputEdad" class="col-sm-2 control-label">Edad:</label>
					<div class="col-sm-10">
						<input type="number" id="inputEdad" name="edad" required="required" value="${usuarios.edad}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">Email:</label>
					<div class="col-sm-10">
						<input type="text" id="inputEmail" name="email" required="required" value="${usuarios.email}">
					</div>			 
			</div>
			
			<div class="form-group">
				<label for="inputDni" class="col-sm-2 control-label">Dni:</label>
					<div class="col-sm-10">
						<input type="text" id="inputDni" name="dni" required="required" value="${usuarios.dni}">
					</div>			 
			</div>
			
			<div class="form-group">
				<label for="inputPuesto" class="col-sm-2 control-label">Puesto:</label>
					<div class="col-sm-10">
						<input type="text" id="inputPuesto" name="puesto" required="required" value="${usuarios.puesto}">
					</div>			 
			</div>
			
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Contraseña:</label>
					<div class="col-sm-10">
						<input type="text" id="inputPassword" name="password" required="required" value="${usuarios.password}">
					</div>			 
			</div>
			
			<div class="form-group">
				<label for="inputImagen" class="col-sm-2 control-label">Imagen:</label>
					<div class="col-sm-10">
						<input type="text" id="inputImagen" name="imagen" required="required" value="${usuarios.imagen}">
					</div>			 
			</div>
						
			<div class="form-group">
   				<div class="col-sm-offset-2 col-sm-10">
					<c:if test="${op==2}">
						<input type="hidden" name="id" required="required" value="${usuarios.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Modificar Usuario">
					</c:if>
					<c:if test="${op==3}">
						<input type="hidden" name="id" required="required" value="${usuarios.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Crear Usuario">
					</c:if>
				</div>
			</div>
		</form>
        
        
       
        
</div>
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
