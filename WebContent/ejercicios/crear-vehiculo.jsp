<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>
 <%@include file="../includes/nav.jsp" %>
    
    <section>
    	<h1>Crear vehiculo</h1>
        <div class="container">
            <div class="row">
            
            <%@include file="../includes/mensaje.jsp" %>
            
            <%
            //Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage. ( <code>${vehiculo}</code> )
            //Tambien validamos en el front-end con HTML5 required, pattern.
            %>
            
                	<h2>Formulario Crear Coche</h2>
                	<form action="crear-vehiculo" method="post">
                		
                		<label for="modelo"> Modelo:</label>
                		<input type="text" name="modelo" id="modelo" placeholder="Escribe el modelo" required pattern=".{2,255}"><br><br>
                		
                		<label for="plazas"> Plazas</label>
                		<input type="number" min="1" step="1" name="plazas" id="plazas" placeholder="Numero de plazas" required><br><br>
                		
                		<label for="potencia"> Potencia</label>
                		<input type="number" name="potencia" id="potencia" placeholder="Potencia del Vehiculo" required><br><br>
                		
                		<input type="submit" value= "Crear">
                	</form>
            </div>
    	</div>
    </section>	       
    
    <h2>Respuesta:</h2>
    <p><code>${vehiculo}</code></p>
    
    
 <%@include file="../includes/footer.jsp" %>