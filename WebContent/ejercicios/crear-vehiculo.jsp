<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
    <section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>Crear Vehiculo y Excepcion Personalizada</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 
  	
       <div class="container">
           <div class="row">
    	
    	<!-- Mensaje de error o TODO OK -->
  		<%@include file="../includes/mensaje.jsp" %> 
	 	
    	<%
    		//if (request.getAttribute("error") != null){
    	%>
  <!--   		<div class="alert alert-danger alert-dismissible" role="alert">
 		 		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<strong>Error! <%=request.getAttribute("error") %></strong> 
			</div>
 -->
    	<%		
    		//}else if (request.getAttribute("vehiculo") != null){
        		
		%>
		
<!--    		<div class="alert alert-success alert-dismissible" role="alert">
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<strong>Se ha creado correctamente: ${vehiculo}</strong>
			</div>
 -->    	
    	<%
    		//}
    	%>
    		</div>
    	</div>
    	
        <div class="container">
            <div class="row">  
            	<p>Realizamos un formulario para poder crear un nuevo <code>Vehiculo</code>.</p>
			    <p>Al crear un <code>Vehiculo</code> con numero de plazas inferior a 0, lanzara una excepcion personalizada, que es controlada en el Servlet.</p>
			    <p>Tambien tenemos que tener en cuenta los parametros que deben ser casteado a <code>int</code> o <code>float</code>, puede fallar.</p>
			    <p>Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage.</p>
			    <p>Tambien validamos en el front-end con HTML5 <code>required</code> y <code>pattern</code>.<p>
			    <p><code>${vehiculo}</code></p> 
			      
               	<div id="imagenVehiculo">
 					<img src="img/vehiculo.jpg" class="img-responsive img-rounded" alt="">
 				</div>
               	
               	<form class="anchuraDivFormulario" action="crear-vehiculo" method="post">
					<div class="form-group">
	               		<label for="modelo">Modelo: </label>
    	           		<input class="form-control" id="modelo" size="15" type="text" name="modelo" placeholder="Escribre el modelo del vehiculo" required pattern=".{2,255}">
               		</div>
               		
               		<br><br>
               		
               		<div class="form-group">
	               		<label for="plazas">Plazas: </label>
    	           		<input class="form-control" id="plazas" min="2" step="1" type="number" name="plazas" placeholder="Escribre las plazas del vehiculo" required>
        	       	</div>

       	       		<br><br>
        	       	
        	       	<div class="form-group">
	               		<label for="potencia">Potencia: </label>
    	           		<input class="form-control" id="potencia" type="number" name="potencia" placeholder="Escribre la potencia del vehiculo" required>
        	       	</div>

       	       		<br><br>
              		
             		<input class="btn btn-default" type="submit" value="CREAR VEHICULO" >

               	</form>                       	
            </div>
    	</div>
    </section>	       
                

<%@include file="../includes/footer.jsp" %>