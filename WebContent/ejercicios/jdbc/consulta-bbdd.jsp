
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<%@ page import="java.io.*"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Ejercicio para realizar consulta en BBDD</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<br>
			<h2>
				Listado vehiculos
				<br>
				<code> SELECT * FROM `vehiculo`</code>
			</h2>
			${vehiculos}
			<table class="display data-table-mio">
				<thead>
					<tr>
						<th>Id</th>
						<th>Modelo</th>
						<th>Plazas</th>
						<th>Potencia</th>
					</tr>
				</thead>
				<tfoot>
				</tfoot>
				<tbody>
					<c:forEach var="v" items="${vehiculos}">
						<tr>
							<td>${v.id}</td>
							<td>${v.modelo}</td>
							<td>${v.plazas}</td>
							<td>
								<fmt:formatNumber type="number" pattern="##,###0.00" value="${v.potencia}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h2>
				Crear vehiculo
			</h2>
			<p>Al crear el <code>preparedStatement</code> sustiyuimos el interrogante por el valor del campo nombre</p>
			<form action="jdbc" method="post">
				<div class="form-group">
					<label for="modelo">Modelo</label>
					<input type="text" class="form-control" id="modelo" name="modelo" placeholder="Modelo" required="required" pattern="[A-Za-z]{2,255}">
					<label for="plazas">Nº plazas</label>
					<input type="number" min="1" max="15" step="1" class="form-control" id="plazas" name="plazas" placeholder="minimo 1" required="required">
					<label for="potencia">Potencia</label>
					<input type="text" class="form-control" id="potencia" name="potencia" placeholder="0 cvv" required="required">
				</div>
				<button type="submit" class="btn btn-default">Crear Vehiculo</button>
				<br>
				<br>
			</form>
		</div>
	</div>
</div>
<%@include file="../../includes/footer.jsp"%>