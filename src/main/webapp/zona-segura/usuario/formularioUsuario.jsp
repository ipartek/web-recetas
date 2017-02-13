<%@page import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">               
               	<h1>USUARIO</h1>               		
               </div>
             </div>             
 		</div> 
 	</header> 
  	   
   <div class="container">
   
   	  <a href="usuario">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="zona-segura/usuario" method="post">
        
        	<label for="id">Identificador:</label>
        	<input type="text" name="id" value="${usuario.id}" readonly>
        	<br>
        
        	<label for="nombre">Nombre:</label>
        	<input autofocus type="text" name="nombre" required value="${usuario.nombre}">
        	<br>
        	
        	<label for="apellido1">Apellido1:</label>
        	<input type="text" name="apellido1" required value="${usuario.apellido1}">
        	<br>
        	
        	<label for="apellido2">Apellido2:</label>
        	<input type="text" name="apellido2" required value="${usuario.apellido2}">
        	<br>
        	
        	<label for="edad">Edad:</label>
        	<input type="number" name="edad" required 
        		    value="${usuario.edad}"/>"	   
        	<br>
        	
        	<label for="email">Email:</label>
        	<input type="email" name="email" required value="${usuario.email}">
        	<br>
        	
        	<label for="dni">Dni:</label>
        	<input type="text" name="dni" required value="${usuario.dni}">
        	<br>
        	
        	<label for="puesto">Puesto:</label>
        	<input type="text" name="puesto" required value="${usuario.puesto}">
        	<br>
        	
        	<label for="password">Password:</label>
        	<input type="password" name="password" required value="${usuario.password}">
        	<br>
        	
        	<label for="imagen">Imagen:</label>
        	<img alt="imagenUsu" src="${usuario.imagen}"><br/>
        	<input type="text" name="imagen" required value="${usuario.imagen}">
        	<br>
            
            <input type="hidden" name="op" value="<%=UsuarioCRUDController.OP_GUARDAR%>">
                    	
        	<input type="submit" value="Modificar">
	
        	<input type="hidden" value="modificar" name="crearModificar"> 
        	
        	
        	
        </form>
        
        
        <!-- Formulario Eliminar -->

        <c:if test="${usuario.id != -1}">
	         <form action="zona-segura/usuario" method="post">	        
	        	<input type="hidden" name="op" value="<%=UsuarioCRUDController.OP_ELIMINAR%>">
	        	<input type="hidden" name="id" value="${usuario.id}">	        	
        		<input type="submit"  value="Eliminar" >

        	</form>
        </c:if>	
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>