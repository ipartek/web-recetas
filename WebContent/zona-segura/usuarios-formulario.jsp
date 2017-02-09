<%@page import="com.ipartek.formacion.recetas.controller.UsuariosCRUDController"%>
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
       		 <a href="usuarios">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="usuarios" method="post">
        
        	<label for="id">Identificador:</label>
        	<input type="text" name="id" value="${usuario.id}" readonly>
        	<br>
        
        	<label for="nombre">Nombre:</label>
        	<input autofocus type="text" name="nombre" required value="${usuario.nombre}">
        	<br>
        	
        	<label>Apellido 1:</label>
        	<input type="text" name="apellido1" required value="${usuario.apellido1}">
        	<br>
        	
        	<label>Apellido 2:</label>
        	<input type="text" name="apellido2" required value="${usuario.apellido2}">
        	<br>
        	<label>Edad:</label>
        	<input type="number" name="edad" required value="${usuario.edad}">
        	<br>
        	<label>Email:</label>
        	<input type="text" name="email" required value="${usuario.email}">
        	<br>
        	<label>Dni:</label>
        	<input type="text" name="dni" required value="${usuario.dni}">
        	<br>
        	<label>Puesto:</label>
        	<input type="text" name="puesto" required value="${usuario.puesto}">
        	<br>
        	<label>Password:</label>
        	<input type="text" name="password" required value="${usuario.password}">
        	<br>
        	<label>Imagen:</label>
        	<input type="text" name="imagen" required value="${usuario.imagen}">
        	<img style="width:50px;" src="${usuario.imagen}">
            <br>
            <input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_GUARDAR%>">
            
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
	         <form action="usuarios" method="post">	        
	        	<input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_ELIMINAR%>">
	        	<input type="hidden" name="id" value="${usuario.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		