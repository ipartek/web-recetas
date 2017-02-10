<%@page import="com.ipartek.formacion.recetas.controller.UsuarioController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>Filtro de Formulario</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
 	<div class="container">
      <div class="row">

     
     <%@include file="../../includes/mensaje.jsp" %>
     
    <p><a href="zona-segura/usuario">Volver</a></p><br>
    
 	<form action="zona-segura/usuario" method="post">
        
        	<input type="hidden" name="op" class="form-control" value="6"/>
        
			<label for="dni">DNI :</label>
			<input type="text" name="dni" class="form-control" placeholder="Escribe un DNI" autofocus/>
			<br>
			<label for="email">E-Mail :</label>
			<input type="text" name="email" class="form-control" placeholder="Escribe un e-mail"/>
			<br>
			<label for="nombre">Nombre </label>
			<input type="text" name="nombre" class="form-control" placeholder="Escribe un nombre"/>
			<br>
			<label for="apellido1">Primer Apellido </label>
			<input type="text" name="apellido1" class="form-control" placeholder="Escribe el primer apellido"/>
			<br>
			<label for="apellido2">Segundo Apellido </label>
			<input type="text" name="apellido2" class="form-control" placeholder="Escribe el segundo apellido"/>
			<br>
			<label>Rango mínimo edad: <%=UsuarioController.EDAD_MIN %></label>
			<input type="range" name="edad" min="<%=UsuarioController.EDAD_MIN %>" max="<%=UsuarioController.EDAD_MAX %>" value="<%=UsuarioController.EDAD_MIN %>" >
			<br>
			<label>Rango máximo edad: <%=UsuarioController.EDAD_MAX %></label>
			<input type="range" name="edad" min="<%=UsuarioController.EDAD_MIN %>" max="<%=UsuarioController.EDAD_MAX %>" value="<%=UsuarioController.EDAD_MAX %>">
			<br>
			<input type="submit" value="Filtrar">
			</form>
 	    </div> 
    <!--  <div class="row"> -->
    <a href="zona-segura/usuario">Volver</a>
</div>    
<!-- <div class="container"> -->


<%@include file="../../includes/footer.jsp" %>