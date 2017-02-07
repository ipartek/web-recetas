<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
    <section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>CRUD Receta</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 
  	

        <div class="container">
            <div class="row">  
				<%@include file="../../includes/mensaje.jsp" %>
				
				<div class="vinculos">
					<a href="receta?op=3">Crear nuevo</a>
				</div>
					<table class="display data-table-mio miTabla">
						<thead>
							<tr>
								<th>Titulo</th>
								<th>Imagen</th>
								<th>Tiempo</th>
								<th>Dificultad</th>
								<th>Comensales</th>
								<th>Descripcion</th>
							</tr>
						</thead>
						

						<tbody>
					
							<c:forEach var="r" items="${recetas}">
								
								<tr>
									<td><a href="receta?op=2&id=${r.id}">${r.titulo}</a></td>
									<td>${r.tiempo}</td>
									<td>${r.imagen}</td>
									<td>${r.dificultad}</td>
									<td>${r.comensales}</td>
									<td>${r.descripcion}</td>
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
					<p>Total Recetas: ${fn: length(recetas)}</p>
					<c:set var="now" value="<%=new java.util.Date()%>"/>
					<p>Fecha: <fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value="${now}"/></p>
				</div>
				
            </div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>