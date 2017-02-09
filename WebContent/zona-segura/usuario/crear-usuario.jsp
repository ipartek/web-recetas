<%@page import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Crear Usuario</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      

      
      <p>Realizamos un formulario para poder crear un nuevo <code>Usuario</code>.</p>
      
     
          	
         <div id="imagenVehiculo">
				<img src="http://www.fancyicons.com/download/?id=2716&t=png&s=256" class="img-responsive img-rounded"
		alt="">
	</div>
		<div id="impresionDatos">
		<%@include file="../../includes/mensaje.jsp" %>
		
		</div>
      <h2> Crear Usuario</h2>   

      <form action="zona-segura/usuario" class="anchuraDivFormulario"  method="post">
		<div class="form-group">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control" size="15" name="nombre" id="nombre"
				placeholder="Introduzca el Usuario" required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="apellido1">Apellido 1 </label> <input type="text"
				class="form-control" name="apellido1" id="apellido1"
				placeholder="Introduzca Apellido 1"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="apellido2">Apellido 2 </label> <input type="text"
				class="form-control" name="apellido2" id="apellido2"
				placeholder="Introduzca Apellido 2"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="edad">Edad </label> <input type="number"
				class="form-control" name="edad" id="edad"
				placeholder="Introduzca Edad"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="email">Email </label> <input type="text"
				class="form-control" name="email" id="email"
				placeholder="Introduzca Email"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="dni">Dni </label> <input type="text"
				class="form-control" name="dni" id="dni"
				placeholder="Introduzca Dni"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="puesto">Puesto </label> <input type="text"
				class="form-control" name="puesto" id="puesto"
				placeholder="Introduzca Puesto"   required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="text"
				class="form-control" name="password" id="password"
				placeholder="Min 6 characters" min="6"  required >
		</div>
		
		
		<input type="hidden" value="<%=UsuarioCRUDController.OP_GUARDAR %>" name="op"> 
		<button type="submit" class="btn btn-primary" value="Crear">Enviar</button>
	</form>  	
  
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>