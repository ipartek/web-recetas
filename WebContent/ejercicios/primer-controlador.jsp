<%@include file="../includes/header.jsp" %>
 <%@include file="../includes/nav.jsp" %>
    
    <section>
    	<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>Mi Primer Controlador</h1>
                	</div>
              	</div>  
  			</div> 
  		</header>
    	
    	<%
    		if (request.getAttribute("error") != null){
    	%>
    		<div class="alert alert-warning alert-dismissible" role="alert">
 		 		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<strong>Error! <%=request.getAttribute("error") %></strong> 
			</div>
    	<%		
    		}
    	%>
        <div class="container">
            <div class="row">
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
               		<!-- Recordar que para mapear este campo input es importante el atributo name -->
               		<input type="text" name="nombre" placeholder="Escribe tu nombre">
               		<br>
               		<input type="text" name="ape1" placeholder="Escribe tu 1º Apellido">
               		<br>
  					<input type="text" name="ape2" placeholder="Escribe tu 2º Apellido">
  					<br>
               		<input type="submit" value="Enviar">
               	</form>            	
            </div>
    	</div>
    </section>	       
                
                
	<h2>Respuesta</h2>
	<%
		if (request.getAttribute("nombre") != null){
			String nombre = (String) request.getAttribute("nombre");
			out.print("Nombre: " + nombre);
			String ape1 = (String) request.getAttribute("ape1");
			out.print("1º Apellido: " + ape1);
			String ape2 = (String) request.getAttribute("ape2");
			out.print("2º Apellido: " + ape2);
	%>
    
    <p>Apellido 1: ${ ape1 }</p>
    <p>Apellido 2: ${ ape2 }</p>
    
    <%
    	} //end if
	%>
	
<%@include file="../includes/footer.jsp" %>