<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
	   <header>
	        <div class="container header-content">
	            <div class="row">
	                <div class="col-lg-12">
	                	<h1>Mi Primer Controlador</h1>
	                </div>
	              </div>  
	  		</div> 
	  	</header> 
    	
        <div class="container">
            <div class="row">
            	
            	
            	<%
            		if ( request.getAttribute("error") != null ){
            	%>
            		<div class="alert alert-danger alert-dismissible" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  <strong><%=request.getAttribute("error")%></strong>
					</div>
            	<%		
            		}
            	%>	
            		
            		
               	<p>Los <b>Controladores</b> en Java son <b>Servlets</b>.</p>
               	<p>Un controlador se encarga de recibir <b>Request</b> del cliente y darle una<b>Response</b>.</p>
               	<p>Puede recibir y retornar parametros.</p>
               	<p>Puede aceptar peticiones de tipo <b>GET</b> o <b>POST</b>.</p>
               	
               	<p>Mapping del Servlet:<b>/saludo</b></p>
               	<p>Clase: <b>com.ipartek.formacion.recetas.controller.SaludoController</b></p>
               	<h2>Petición GET</h2>
               	<p>Vamos a enviar tres parametros para que el Servlet nos retorne un saludo con nuestro nombre y apellidos.</p>
               	<p>Las peticiones GET se hacen mediante enlaces,links o anclas.</p>
               	<p>pulsa enlace para realizar petición GET <a href="saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola">/saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola</a></p>
               	
               	<h2>Petición POST</h2>
               	
               	<form action="saludo" method="post">
               		
               		<input type="text" name="nombre" placeholder="Escribe tu nombre">
               		<br>
               		<input type="text" name="apellido1" placeholder="Escrtibe tu primer Apellido">
               		<br>
               		<input type="text" name="apellido2" placeholder="Escrtibe tu segundo Apellido">
               		<br>
               		<input type="submit" value="Enviar">
               	</form>
               	
               	                	
            </div>
    	
    
    
    <div class="row">
    <h2>Respuesta</h2>    
    <%
    	if ( request.getAttribute("nombre") != null ){
    		String nombre = (String)request.getAttribute("nombre");
    		out.print("Nombre: " + nombre);	
    	
    %>    
	    <p>Apellido1: ${apellido1}</p>
	    <p>Apellido2: ${apellido2}</p>
    
    <%
    	} //end if    	
     %>
    
    
    </div>      
    
</div>    

<%@include file="../includes/footer.jsp" %>







