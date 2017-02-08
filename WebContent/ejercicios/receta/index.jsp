
<%@page import="com.ipartek.formacion.recetas.controller.RecetasController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
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
		<%@include file="../../includes/mensaje.jsp"%>
		<a class="portfolio-link" href="receta?op=3">Crear Nueva</a>
		<table class="display data-table-mio" width="100%">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Tiempo</th>
					<th>Comensales</th>
					<th>Descripcion</th>
					<th>Imagen</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
			<tbody>
				<c:forEach var="r" items="${recetas}">
					<tr>
						<td>
							<a href="receta?op=<%=RecetasController.OP_VER_DETALLE %>&id=${r.id}">${r.titulo}</a>
						</td>
						<td>
							<a href="receta?op=<%=RecetasController.OP_VER_DETALLE %>&id=${r.id}">${r.tiempo}</a>
						</td>
						<td>
							<a href="receta?op=<%=RecetasController.OP_VER_DETALLE %>&id=${r.id}">${r.comensales}</a>
						</td>
						<td>
							<a href="receta?op=<%=RecetasController.OP_VER_DETALLE %>&id=${r.id}">${r.descripcion}</a>
						</td>
						<td>
							<a href="receta?op=<%=RecetasController.OP_VER_DETALLE %>&id=${r.id}">
								<img src="${r.imagen}" alt="img" style="width:10%">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- 		<c:set var="user" scope="sesion" value="${sessionScope.user}"></c:set> --%>
		<%-- 		<c:choose> --%>
		<%-- 		</c:choose> --%>
		<%-- 		<p><%=user%></p> --%>
		<p>Total Recetas: ${fn:length(recetas)}</p>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<p>
			Fecha:
			<fmt:formatDate pattern="dd-MM-YYY HH:mm" value="${now}" />
		</p>
	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->
<%@include file="../../includes/footer.jsp"%>