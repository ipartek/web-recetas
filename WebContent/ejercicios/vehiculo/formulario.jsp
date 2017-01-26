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
	               		<c:set var="vehiculoModelo" scope="session" value=""></c:set>
	               	</c:when>
	               	<c:otherwise>
	               		<c:set var="vehiculoModelo" scope="session" value="${vehiculo.modelo}"></c:set>
	               	</c:otherwise>
	            </c:choose>  
	            		
               	<form class="anchuraDivFormulario" action="/vehiculo" method="post">
					<div class="form-group">
	               		<label for="modelo">Modelo: </label>
    	           		<input class="form-control" id="modelo" size="15" type="text" name="modelo" placeholder="Escribre el modelo del vehiculo" value="${vehiculoModelo}" required pattern=".{2,255}">
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="plazas">Plazas: </label>
    	           		<input class="form-control" id="plazas" min="2" step="1" type="number" name="plazas" placeholder="Escribre las plazas del vehiculo" required>
        	       	</div>

       	       		<br>
       	       		
        	       	<div class="form-group">
	               		<label for="plazas">Dimensiones: </label>
    	           		<input class="form-control" id="plazas" min="2" step="1" type="number" name="plazas" placeholder="Escribre las plazas del vehiculo" required>
        	       	</div>

       	       		<br>
       	       		
        	       	<div class="form-group">
	               		<label for="potencia">Potencia: </label>
    	           		<input class="form-control" id="potencia" type="number" name="potencia" placeholder="Escribre la potencia del vehiculo" required>
        	       	</div>

       	       		<br>
              		
             		<input class="btn btn-default" type="submit" value="CREAR VEHICULO" >

               	</form>                       	
            </div>
    	</div>
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>