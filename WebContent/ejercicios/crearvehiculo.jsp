<%@include file="../includes/header.jsp" %>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<body id="" class="index">
    
    <section>
    	<h1>Le concesionaire</h1>
        <div class="container">
            <div class="row">
            
            	<%
            		if (request.getAttribute("error") != null){
            	%>
            		<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
 					<strong><%=request.getAttribute("error") %></strong>
					</div>
            	<% 		
            		} 
            	
            	if (request.getAttribute("bien") != null){
            	%>
                	<div class="alert alert-success alert-dismissible" role="alert">
    				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
     				<strong><%=request.getAttribute("bien") %></strong>
    				</div>
                <% 			
            		}
            	%>
            	
          
               	
               	<form action="crear-vehiculo" method="post">
               		
               		<p> Modelo: </p><input type="text" name="modelo" placeholder="Escribe el modelo del coche">
               		<p> Plazas: </p><input type="text" name="plazas" placeholder="Escribe el numero de plazas">
               		<p> Potencia: </p><input type="text" name="potencia" placeholder="Escribe la potencia">
               		<br>
               		<input type="submit" value="Enviar">
               	</form>
               	
               	                	
            </div>
    	</div>
    </section>	 
    
    <h2>Respuesta</h2>    
    <%
    	if ( request.getAttribute("vehiculo") != null ){
    		Vehiculo v = (Vehiculo)request.getAttribute("vehiculo");
    		out.print(v);	
    	}    	
    %>
                
 <%@include file="../includes/footer.jsp" %>