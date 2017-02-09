
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>CRUD Usuario</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<%@include file="../../includes/mensaje.jsp"%>
		<a href="zona-segura/usuario?op=3">Crear Nuevo</a>
		
		<p>Mostrando 500 usuarios de ${totalUsers} totales que se encuentran en la BBDD.</p>
		<p>Para buscar un usuario ver: <a href="zona-segura\usuario\form-filtro.jsp">Fitro Buscar Usuario en BBDD</a></p><br>
		
		<table class="display data-table-mio" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido 1</th>
					<th>Apellido 2</th>
					<th>Email</th>
					<th>Dni</th>
					<th>Puesto</th>
					<th>edad</th>
					<th>Imagen</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${usuarios}">
					<tr>
						<td>
							<a href="zona-segura/usuario?op=2&id=${u.id}">${u.nombre}</a>
						</td>
						<td>${u.apellido1}</td>
						<td>${u.apellido2}</td>
						<td>${u.email}</td>
						<td>${u.dni}</td>
						<td>${u.puesto}</td>
						<td>${u.edad}</td>
						<td>
							<img src="${u.imagen}" alt="usr-image" style="width:20%">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:set var="user" scope="session" value="${sessionScope.usuario}"></c:set>
		<c:choose>
			<c:when test="${user==null}">
				<p>Usuario No Conectado</p>
			</c:when>
			<c:when test="${user!=null}">
				<p>Usuario: ${usuario.nombre}</p>
			</c:when>
		</c:choose>
 		<p>Total Usuarios: ${totalUsers}</p> 
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<p>
			Fecha:
			<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" />
		</p>
	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->
<%@include file="../../includes/footer.jsp"%>
