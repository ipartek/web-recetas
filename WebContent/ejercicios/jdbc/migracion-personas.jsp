<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


	<header>
    	<div class="container header-content">
        	<div class="row">
            	<div class="col-lg-12">
               		<h1>Proceso de Migracion de Personas</h1>
               	</div>
			</div>             
		</div> 
	</header> 

	<div class="container">
		<div class="row">
		
			<%@include file="../../includes/mensaje.jsp" %>
		
      		<p>Ejercicio para realizar una migracion de datos desde un fichero de texto a una Base de Datos</p><br>
      		<p>Aprenderemos a realizar transacciones atomicas, con <code>commit</code> y <code>rollback</code></p><br>
      		
      		<form action="migracion" method="post">
      			<input type="submit" value="MIGRACION">
      		</form>
      		
      		<br>
      		
      		<c:if test="${personas !=null}">
	      		<p>Registros totales: ${numTotalFichero}<p>
	      		<p>Tiempo transcurrido: ${tiempo} ms<p>
	      		<p>Se han insertado ${numInsertado} personas en la BBDD.</p>
	      		<p>${numTotalFichero-numInsertado} personas incorrectas sin incluir en la BBDD.</p>
	      		<br>
	      		
	      		<table class="display data-table-mio miTabla">
	      			<thead>
						<tr>
							<th>Nombre</th>
							<th>1º Apellido</th>
							<th>2º Apellido</th>
							<th>Edad</th>
							<th>Email</th>
							<th>DNI</th>
							<th>Puesto</th>
						</tr>
					</thead>
					
					<tbody>				
						<c:forEach var="p" items="${personas}">	
							<tr>
								<td>${p.nombre}</td>
								<td>${p.apellido1}</td>
								<td>${p.apellido2}</td>
								<td>${p.edad}</td>
								<td>${p.email}</td>
								<td>${p.dni}</td>
								<td>${p.puesto}</td>
							</tr>
						</c:forEach>
					
					</tbody>
	      		</table>
	      	</c:if> 		
		</div> 
		<!--  <div class="row"> -->
	</div>    
	<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>