<%@include file="../includes/header.jsp" %>



    <section id="controllers">
    <h1>Tercer ejercicio</h1>
    	<h1>Crear Vehículo con controlador [POST]</h1>
        <div class="container">
            <div class="row">
            <%
            if(request.getAttribute("error")!=null){
            
            %>
            <div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>ERROR!</strong> <%=request.getAttribute("error") %>
</div>
<% } 
            
            if (request.getAttribute("vehiculo")!=null) {
            
            
            %> 	
            
            <div class="alert alert-success" role="alert">
  <p> El coche ha sido creado con éxito.</p>
</div>
            
            <% } %>	

            </div>
            <h2>ENVIO POST</h2>
            
            <form action="crear-vehiculo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el método por el que lo enviaremos es post. -->
             Modelo: <input type="text" name="modelo" placeholder="Escriba el modelo del coche"> <!-- Para mapear es importante el name -->
            <br>Plazas: <input type="number" name="plazas" placeholder="Escriba las plazas del coche">
             <br>Potencia: <input type="number" name="potencia" placeholder="Escriba la potencia del coche">
           <br> <input type="submit" value="CREAR COCHE">
            </form>
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



<%@include file="../includes/footer.jsp" %>
