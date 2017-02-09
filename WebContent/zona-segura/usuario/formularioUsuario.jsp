<%@page import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>Vehiculo</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
  	   
   <div class="container">
   
   	  <a href="usuario">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="zona-segura/usuario/indexUsuario" method="post">
        
        	<label for="id">Identificador:</label>
        	<input type="text" name="id" value="${u.id}" readonly>
        	<br>
        
        	<label for="nombre">Nombre:</label>
        	<input autofocus type="text" name="nombre" required value="${u.nombre}">
        	<br>
        	
        	<label for="apellido1">Apellido1:</label>
        	<input type="text" name="apellido1" required value="${u.apellido1}">
        	<br>
        	
        	<label for="apellido2">Apellido2:</label>
        	<input type="text" name="apellido2" required value="${u.apellido2}">
        	<br>
        	
        	<label for="edad">Edad:</label>
        	<input type="number" name="edad" required 
        		    value="${u.edad}"/>"	   
        	<br>
        	
        	<label for="email">Email:</label>
        	<input type="email" name="email" required value="${u.email}">
        	<br>
        	
        	<label for="dni">Dni:</label>
        	<input type="text" name="dni" required value="${u.dni}">
        	<br>
        	
        	<label for="puesto">Puesto:</label>
        	<input type="text" name="puesto" required value="${u.puesto}">
        	<br>
        	
        	<label for="password">Password:</label>
        	<input type="password" name="password" required value="${u.password}">
        	<br>
        	
        	<label for="imagen">Imagen:</label>
        	<input type="image" name="imagen" required value="${u.imagen}">
        	<br>
            
            
            <input type="hidden" name="op" value="<%=%>">
            
            <c:if test="${u.id == -1}">
        		<input type="submit" value="Crear">
        	</c:if>		
        	
        	 <c:if test="${u.id != -1}">
        		<input type="submit" value="Modificar">
        	</c:if>		
        	
        	
        </form>
        
        
        <!-- Formulario Eliminar -->
        
        <c:if test="${u.id != -1}">
	         <form action="usuario" method="post">	        
	        	<input type="hidden" name="op" value="<%=%>">
	        	<input type="hidden" name="id" value="${u.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>