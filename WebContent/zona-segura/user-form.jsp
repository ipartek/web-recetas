
<%@page import="com.ipartek.formacion.recetas.controller.UsuarioController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>BBDD Usuarios</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
  	   
   <div class="container">
   
   	  <a href="usuario" class="portfolio-link">Volver al indice</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="zona-segura/usuario" method="post">
        
        <label for="id">Identificador:</label>
			<input type="text" name="id" value="${usuario.id}" readonly class="form-control" />
			<br>
			<label for="nombre">Nombre:</label>
			<input autofocus type="text" name="nombre" required value="${usuario.nombre}" class="form-control" />
			<br>
			<label for="apellido1">Apellido 1:</label>
			<input type="text" name="apellido1" required value="${usuario.apellido1}" class="form-control" />
			<br>
			<label for="apellido2">Apellido 2:</label>
			<input type="text" name="apellido2" value="${usuario.apellido2}" class="form-control" />
			<br>
			<label for="email">E-Mail :</label>
			<input type="text" name="email" value="${usuario.email}" class="form-control" />
			<br>
			<label for="dni">dni :</label>
			<input type="text" name="dni" value="${usuario.dni}" class="form-control" />
			<br>
			<label for="puesto">puesto:</label>
			<input type="text" name="puesto" value="${usuario.puesto}" class="form-control" />
			<label for="edad">edad:</label>
			<input type="number" name="edad" value="${usuario.edad}" class="form-control" />
			<label for="imagen">imagen:</label>
			<input type="text" name="imagen" value="${usuario.imagen}" class="form-control" />
            
            <input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
            
            <c:if test="${usuario.id == -1}">
        		<input type="submit" value="Crear">
        	</c:if>		
        	
        	 <c:if test="${usuario.id != -1}">
        		<input type="submit" value="Modificar">
        	</c:if>		
        	
        	
        </form>
        
        
        <!-- Formulario Eliminar -->
        <br><br>
        <c:if test="${usuario.id != -1}">
	         <form action="zona-segura/usuario" method="post">	        
	        	<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
	        	<input type="hidden" name="id" value="${usuario.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
        
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
