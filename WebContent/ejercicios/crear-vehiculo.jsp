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
      
      <%@include file="../includes/mensaje.jsp" %>
      
      <p>Realizamos un formulario para poder crear un nuevo <code>Vehiculo</code>.</p>
      <p>Al crear un <code>Vehiculo</code> con numero de plazas inferior a 0, lanzara una excepcion personalizada, que es controlada en el Servlet.</p>
      <p>Tambien tenemos que tener en cuenta los parametros que deben ser casteado a <code>int</code> o <code>float</code>, puede fallar.</p>
      <p>Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage.</p>
      <p>Tambien validamos en el front-end con HTML5 <code>required</code> y <code>pattern</code>.<p>
      <p><code>${vehiculo}</code></p> 
          	
      <h2>Formulario Crear Coche</h2>    	
      <form action="crear-vehiculo" method="post">
      
      	<label for="modelo">Modelo:</label>
      	<input type="text" name="modelo" id="modelo" placeholder="Modelo" required pattern=".{2,255}">
      	<br>	
      	<label for="plazas">Plazas:</label>
      	<input type="number" min="1" step="1" name="plazas" id="plazas" value="1"  required>
      	<br>
      	<label for="potencia">Potencia:</label>
      	<input type="text" name="potencia" id="potencia" placeholder="0 cvv"  required>
      	<br>
      	
      	<input type="submit" value="Crear">
      </form>    	
  
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>
