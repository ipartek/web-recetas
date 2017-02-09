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
   
   	  <a href="vehiculo">Volver</a>
   	  
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
        <form action="vehiculo" method="post">
        
        	<label for="id">Identificador:</label>
        	<input type="text" name="id" value="${vehiculo.id}" readonly>
        	<br>
        
        	<label for="modelo">Modelo:</label>
        	<input autofocus type="text" name="modelo" required value="${vehiculo.modelo}">
        	<br>
        	
        	<label for="plazas">Plazas:</label>
        	<input type="number" name="plazas" required value="${vehiculo.plazas}">
        	<br>
        	
        	<label for="potencia">Potencia:</label>
        	<input type="text" name="potencia" required 
        	       value="<fmt:formatNumber pattern="#,##0.00" value="${vehiculo.potencia}"/>">
        	<br>
        	
        	<label for="dimensiones">Dimensiones:</label>
        	<input type="text" name="dimensiones" required 
        		   value="<fmt:formatNumber pattern="#,##0.00" value="${vehiculo.dimensiones}"/>"
        		   >
        	<br>
            
            <input type="hidden" name="op" value="<%=%>">
            
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
	        	<input type="hidden" name="op" value="<%=%>">
	        	<input type="hidden" name="id" value="${vehiculo.id}">	        	
        		<input type="submit" value="Eliminar">
        	</form>
        </c:if>	
        
        

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>