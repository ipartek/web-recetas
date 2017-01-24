<%@include file="../includes/header.jsp" %>



    <section id="controllers">
    <h1>Tercer ejercicio</h1>
    
    <p class="anotaciones">El formulario tiene algunas validaciones de HTML 5. Ver el código para entender mejor el funcionamiento. Al lado se encuentra explicado en un comentario HTML el funcionamiento de alguno de esos parámetros de validación.</p>
    
    	<h1>Crear Vehículo con controlador [POST]</h1>
        <div class="container">
            <div class="row">
            <%@include file="../includes/Mensaje.jsp" %>

            </div>
            <h2>ENVIO POST</h2>
            
            <form action="crear-vehiculo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el método por el que lo enviaremos es post. -->
             <label>Modelo:</label> <input type="text" name="modelo" id="modelo" placeholder="Escriba el modelo del coche" PATTERN=".{2,255}" required> <!-- Para mapear es importante el name -->
            <br><label>Plazas:</label> <input type="number" min="1" step="1" name="plazas" id="plazas" placeholder="Escriba las plazas del coche" required>
             <br><label>Potencia:</label> <input type="number" name="potencia" id="potencia" placeholder="Escriba la potencia del coche" required>
           <br> <input type="submit" value="CREAR COCHE">
            </form> <!-- STEP SIRVE PARA INDICAR EL VALOR MÍNIMO DE UN INPUT NUMÉRICO. EN LAS EXPRESIONES REGULARES, EL PUNTO NOS PERMITE PONER CUALQUIER COSA. -->
             <h2 id="respuesta">RESPUESTA POST</h2>
             <p class="anotaciones">
             Vamos a visualizar los datos introducidos del coche.<br><br>
             <%
             if (request.getAttribute("vehiculo")!=null){
     			String modelo = (String) request.getAttribute("modelo");
     			  
     			out.print("<b>Modelo: </b>"+modelo);
     			String plazas = (String) request.getAttribute("plazas");%>
     			<br><% 
     			out.print("<b>Plazas: </b>"+plazas);
     			String potencia = (String) request.getAttribute("potencia");
     			%> <br>
     			<% 
     			out.print("<b>Potencia: </b>"+potencia);
     %>
     		
     		<%
     }	 //end if 
             %>
             
             </p>
            <br><br>

    	</div>
    </section>	       

<!-- Código que no es del profe -->

 <%
         //   if(request.getAttribute("error")!=null){
            
            %>
         <!--     <div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>ERROR!</strong> <%=request.getAttribute("error") %>
</div> -->
<% //} 
            
      //      if (request.getAttribute("vehiculo")!=null) {
            
            
            %> 	
            
       <!--   <div class="alert alert-success" role="alert">
  <p> El coche ha sido creado con éxito.</p>
</div> -->   
            
            <% // } %>	




<%@include file="../includes/footer.jsp" %>
