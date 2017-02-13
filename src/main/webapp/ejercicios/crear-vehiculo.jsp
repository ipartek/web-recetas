<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
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
      

      
      <p>Realizamos un formulario para poder crear un nuevo <code>Vehiculo</code>.</p>
      <p>Al crear un <code>Vehiculo</code> con numero de plazas inferior a 0, lanzara una excepcion personalizada, que es controlada en el Servlet.</p>
      <p>Tambien tenemos que tener en cuenta los parametros que deben ser casteado a <code>int</code> o <code>float</code>, puede fallar.</p>
      <p>Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage.</p>
      <p>Tambien validamos en el front-end con HTML5 <code>required</code> y <code>pattern</code>.<p>
      <p><code>${vehiculo}</code></p> 
          	
         <div id="imagenVehiculo">
				<img src="img/vehiculo.jpg" class="img-responsive img-rounded"
		alt="">
	</div>
		<div id="impresionDatos">
		<%@include file="../includes/mensaje.jsp" %>
		<%
	 		Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo");
			if(vehiculo!=null)
			{
				out.println("<p><b>Modelo:</b> " + vehiculo.getModelo() + "</p>");
				out.println("<p><b>Plazas:</b> " + vehiculo.getPlazas() + "</p>");
				out.println("<p><b>Potencia:</b> " + vehiculo.getPotencia() + " CV</p>");
			}
		%> 
		</div>
      <h2>Formulario Crear Coche</h2>   

      <form action="crear-vehiculo" class="anchuraDivFormulario"  method="POST">
		<div class="form-group">
			<label for="modelo">Modelo</label> <input type="text"
				class="form-control" size="15" name="modelo" id="modelo"
				placeholder="Introduzca el modelo" required pattern=".{2-255}">
		</div>
		<div class="form-group">
			<label for="plazas">Plazas </label> <input type="number"
				class="form-control" name="plazas" id="plazas"
				placeholder="Introduzca las plazas" min="2"   required>
		</div>
		<div class="form-group">
			<label for="potencia">Potencia:</label> <input type="number"
				class="form-control" name="potencia" id="potencia"
				placeholder="0 cvv" required>
		</div>
		<button type="submit" class="btn btn-primary" value="Crear">Enviar</button>
	</form>  	
  
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>
