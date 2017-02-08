<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
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
   
   	  <a href="vehiculo">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="vehiculo" method="post">
        
        	<label for="id">Identificador:</label>
        	<input type="text" name="id" value="${usuario.id}" readonly class="form-control">
        	<br>
        
        	<label for="nombre">Nombre:</label>
        	<input autofocus type="text" name="nombre" required value="${usuario.nombre}" class="form-control">
        	<br>
        	
        	<label for="apellido1">Apellido 1:</label>
        	<input type="text" name="apellido1" required value="${usuario.apellido1}" class="form-control">
        	<br>
        	
        	<label for="apellido2">Apellido 2:</label>
        	<input type="text" name="apellido2"  value="${usuario.apellido2}" >
        	<br>
        	
        	<label for="dimensiones">Dimensiones:</label>
        	<input type="text" name="dimensiones" required 
        		   value="<fmt:formatNumber pattern="#,##0.00" value="${usuario.dimensiones}"/>"
        		   >
        	<br>
            
            <input type="hidden" name="op" value="<%=VehiculoCRUDController.OP_GUARDAR%>">
            
            <c:if test="${vehiculo.id == -1}">
        		<input type="submit" value="Crear">
        	</c:if>		
        	
        	 <c:if test="${vehiculo.id != -1}">
        		<input type="submit" value="Modificar">
        	</c:if>		
        	
        	
        </form>
        
        
        <!-- Formulario Eliminar -->
        <br><br>
        <c:if test="${vehiculo.id != -1}">
	         <form action="vehiculo" method="post">	        
	        	<input type="hidden" name="op" value="<%=VehiculoCRUDController.OP_ELIMINAR%>">
	        	<input type="hidden" name="id" value="${vehiculo.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
        
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
