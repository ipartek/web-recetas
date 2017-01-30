<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
    <section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>Formulario Vehiculo</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 

        <div class="container">
            <div class="row">  
               	<div id="imagenVehiculo">
 					<img src="img/vehiculo.jpg" class="img-responsive img-rounded" alt="">
 				</div>
               	
             	<c:choose>
               		<c:when test="${vehiculo.id == -1}">
	               		<c:set var="isNew" value="true"></c:set>
	               	</c:when>
	               	<c:otherwise>
	               		<c:set var="isNew" value="false"></c:set>
	               	</c:otherwise>
	            </c:choose>  
	        
	        
<!-- 	        	<h2>¿ES nuevo?: ${isNew}</h2>  -->
 				
				<%@include file="../../includes/mensaje.jsp"%>
 				    
 				<div class="vinculos">
					<a href="vehiculo">Volver</a>
				</div>
						
               	<form class="anchuraDivFormulario" action="vehiculo" method="post">
               	
               		<input type="hidden" name="op" value="<%=VehiculoCRUDController.OP_GUARDAR%>">
               		
               		<input type="hidden" name="id" value="${vehiculo.id}" readonly="readonly">
               	
					<div class="form-group">
	               		<label for="modelo">Modelo: </label>
    	           		<input class="form-control" id="modelo" size="15" type="text" name="modelo" placeholder="Escribre el modelo del vehiculo" value="${vehiculo.modelo}" required pattern=".{2,255}" autofocus>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="plazas">Plazas: </label>
    	           		<input class="form-control" id="plazas" min="1" step="1" type="number" name="plazas" placeholder="Escribre las plazas del vehiculo" value="${vehiculo.plazas}" required>
        	       	</div>

       	       		<br>
       	       		
        	       	<div class="form-group">
	               		<label for="plazas">Dimensiones: </label>
    	           		<input class="form-control" id="dimensiones" type="text" name="dimensiones" placeholder="Escribre las dimensiones del vehiculo" value="${vehiculo.dimensiones}" required>
        	       	</div>

       	       		<br>
       	       		
        	       	<div class="form-group">
	               		<label for="potencia">Potencia: </label>
    	           		<input class="form-control" id="potencia" type="text" name="potencia" placeholder="Escribre la potencia del vehiculo" value="${vehiculo.potencia}" required>
        	       	</div>

       	       		<br>
              		
              		<c:choose>
	               		<c:when test="${isNew}">
		               			<input class="btn btn-default" type="submit" value="CREAR VEHICULO" >
		               	</c:when>
		               	<c:otherwise>
		               			<input class="btn btn-default" type="submit" value="MODIFICAR" >
		               	</c:otherwise>
	           		 </c:choose>  
               	</form>           
               	
               	<c:if test="${!isNew}">
               	
               		 	<form class="anchuraDivFormulario" action="vehiculo" method="post">               	
			               		<input type="hidden" name="op" value="4">	<!-- OP=4 -> eliminar -->		               		
			               		<input type="hidden" name="id" value="${vehiculo.id}" readonly="readonly">
			               		<br>
			               		<input id="btnEliminar" class="btn btn-default" type="submit" value="ELIMINAR">
               			</form>    
               	
               	
               	</c:if>
               	
               	
               	            	
            </div>
    	</div>
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>