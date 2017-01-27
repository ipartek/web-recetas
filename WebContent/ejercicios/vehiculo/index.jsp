<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.controller.VehiculoController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>

<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
    <section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>CRUD Vehiculo</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 
  	

        <div class="container">
            <div class="row">  
				<%@include file="../../includes/mensaje.jsp" %>
				
				<div id="crearNuevo">
					<a href="vehiculo?op=3">Crear nuevo</a>
				</div>
					<table class="display data-table-mio miTabla">
						<thead>
							<tr>
<!-- 								<th>ID</th> -->
								<th>Modelo</th>
								<th>Plazas</th>
								<th>Dimensiones</th>
								<th>Potencia</th>
<!--								<th></th>-->
							</tr>
						</thead>
						
<!-- 						<tfoot>
							<tr>
								<th>ID</th>
								<th>Modelo</th>
								<th>Plazas</th>
								<th>Dimensiones</th>
								<th>Potencia</th>
								<th></th> 
							</tr>
						</tfoot>
 -->						
						<tbody>
					
							<c:forEach var="v" items="${vehiculos}">
								
								<tr>
<!-- 									<td>${v.id}</td>  -->
									<td><a href="vehiculo?op=2&id=${v.id}">${v.modelo}</a></td>
									<td>${v.plazas}</td>
									<td>${v.dimensiones}</td>
									<td>${v.potencia}</td>
<!--									<td>
										<img alt="" src="img/lapiz_mini.png">
										<img alt="" src="img/cubo_basura_mini.png">
									</td>-->
								</tr>
							</c:forEach>
						
						</tbody>
					</table>
	

				<c:choose>
					<c:when test="${empty sessionScope.usuario.nombre}">
						<c:set var="usuarioConectado" scope="session" value="No conectado"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="usuarioConectado" scope="session" value="${sessionScope.usuario.nombre}"></c:set>
					</c:otherwise>
				</c:choose>
				
				<div id="info">
					<p>Usuario: ${usuarioConectado}</p>
					<p>Total Vehiculos: ${fn: length(vehiculos)}</p>
					<c:set var="now" value="<%=new java.util.Date()%>"/>
					<p>Fecha: <fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value="${now}"/></p>
				</div>
				
            </div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>