<%@page import="com.ipartek.formacion.recetas.controller.RecetaCRUDController"%>
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
   
   	  <a href="receta">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="receta" method="post">
        
        	<label for="id">ID:</label>
        	<input type="text" name="id" value="${receta.id}" readonly>
        	<br>
        
        	<label for="modelo">NOMBRE:</label>
        	<input autofocus type="text" name="titulo" required value="${receta.titulo}">
        	<br>
        	            
            <input type="hidden" name="op" value="<%=RecetaCRUDController.OP_GUARDAR%>">
            
            <c:if test="${receta.id == -1}">
        		<input type="submit" value="Crear">
        	</c:if>		
        	
        	 <c:if test="${receta.id != -1}">
        		<input type="submit" value="Modificar">
        	</c:if>		
        	
        	
        </form>
        
        
        <!-- Formulario Eliminar -->
        <br><br>
        <c:if test="${receta.id != -1}">
	         <form action="vehiculo" method="post">	        
	        	<input type="hidden" name="op" value="<%=RecetaCRUDController.OP_ELIMINAR%>">
	        	<input type="hidden" name="id" value="${receta.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
        
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
