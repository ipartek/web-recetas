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
				
				<div class="table-responsive">	
					<table class="table table-striped" id="listarTabla">
						<tr>
							<th>ID</th>
							<th>Modelo</th>
							<th>Plazas</th>
							<th>Dimensiones</th>
							<th>Potencia</th>
							<th></th>
						</tr>
					
						<c:forEach var="v" items="${vehiculos}">
							
							<tr>
								<td>${v.id}</td>
								<td>${v.modelo}</td>
								<td>${v.plazas}</td>
								<td>${v.dimensiones}</td>
								<td>${v.potencia}</td>
								<td>
									<img alt="" src="img/lapiz_mini.png">
									<img alt="" src="img/cubo_basura_mini.png">
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				

				<c:choose>
					<c:when test="${empty sessionScope.usuario.nombre}">
						<c:set var="usuarioConectado" scope="session" value="No conectado"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="usuarioConectado" scope="session" value="${sessionScope.usuario.nombre}"></c:set>
					</c:otherwise>
				</c:choose>
				
				<p>Usuario: ${usuarioConectado}</p>
				<p>Total Vehiculos: ${fn: length(vehiculos)}</p>
				<c:set var="now" value="<%=new java.util.Date()%>"/>
				<p>Fecha: <fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value="${now}"/></p>
				
				<!--  end: <div class="table-responsive"> -->
            </div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>