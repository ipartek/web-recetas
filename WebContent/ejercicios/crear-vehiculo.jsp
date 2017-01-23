<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
    <section>
    	<h1>CREAR VEHICULO</h1>
    	
    	<!-- Mensaje de error o TODO OK -->
    	
    	<%
    		if (request.getAttribute("error") != null){
    	%>
    		<div class="alert alert-danger alert-dismissible" role="alert">
 		 		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<strong>Error! <%=request.getAttribute("error") %></strong> 
			</div>
    	<%		
    		}else if (request.getAttribute("vehiculo") != null){
        		
		%>
		
    		<div class="alert alert-success alert-dismissible" role="alert">
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  				<strong>Se ha creado correctamente: ${vehiculo}</strong>
			</div>
    	
    	<%
    		}
    	%>
    	
        <div class="container">
            <div class="row">  
               	<form class="navbar-form navbar-left form-control" action="crear-vehiculo" method="post">

               		<p>Modelo: </p>
               		<input class="form-control" type="text" name="modelo" placeholder="Escribre el modelo del vehiculo">
               		<br><br>
               		<p>Plazas: </p>
               		<input class="form-control" type="number" name="plazas" placeholder="Escribre las plazas del vehiculo">
               		<br><br>
               		<p>Potencia: </p>
               		<input class="form-control" type="number" name="potencia" placeholder="Escribre la potencia del vehiculo">
               		<br><br>
              		
             		<input class="btn btn-default" type="submit" value="CREAR VEHICULO" >

               	</form>                       	
            </div>
    	</div>
    </section>	       
                

<%@include file="../includes/footer.jsp" %>