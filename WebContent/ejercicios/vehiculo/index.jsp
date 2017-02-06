<%@page import="com.ipartek.formacion.vehiculo.controller.VehiculoCRUDControllerDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.vehiculo.pojo.Vehiculo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>

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
		<div id="imagenVehiculo">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded" alt="">
		</div>
		<%@include file="../../includes/mensaje.jsp"%>
		<a class="portfolio-link" href="vehiculoDB?op=3">Crear Nuevo</a>
		<table  class="display data-table-mio"  width="100%">
			<thead>
				<tr>
					<th>Modelo</th>
					<th>Plazas</th>
					<th>Dimensiones</th>
					<th>Potencia</th>
					
				</tr>
			</thead>
			<tfoot>
			</tfoot>
			<tbody>
			<c:forEach var="v" items="${vehiculos}">
				<tr>
					<td><a href="vehiculoDB?op=<%=VehiculoCRUDControllerDB.OP_VER_DETALLE %>&id=${v.id}">${v.modelo}</a></td>
					<td>${v.plazas}</td>
					<td><fmt:formatNumber type="number" 
            pattern="##,###0.00" value="${v.dimensiones}" /></td>
					<td><fmt:formatNumber type="number" 
            pattern="##,###0.00" value="${v.potencia}"/></td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<%-- 		<c:set var="user" scope="sesion" value="${sessionScope.user}"></c:set> --%>
		<%-- 		<c:choose> --%>

		<%-- 		</c:choose> --%>
		<%-- 		<p><%=user%></p> --%>
		<p>Total Vehiculos: ${fn:length(vehiculos)}</p>
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