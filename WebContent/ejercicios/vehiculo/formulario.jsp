
<%@page import="com.ipartek.formacion.vehiculo.controller.VehiculoCRUDControllerDB"%>
<%@page import="com.ipartek.formacion.vehiculo.pojo.Vehiculo"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>CRUB</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		`
		<div id="imagenVehiculo">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded" alt="">
		</div>
		<%@include file="../../includes/mensaje.jsp"%>
		<p>
			Realizamos un formulario para poder crear un nuevo
			<code>Vehiculo</code>
		</p>
		<p>
			Al crear un
			<code>Vehiculo</code>
			con numero de plazas inferior a 0, lanzara una excepcion personalizada, que es controlada en el Servlet.
		</p>
		<p>
			Tambien tenemos que tener en cuenta los parametros que deben ser casteado a
			<code>int</code>
			o
			<code>float</code>
			, puede fallar.
		</p>
		<p>Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage.</p>
		<p>
			Tambien validamos en el front-end con HTML5
			<code>required</code>
			y
			<code>pattern</code>
		<p>
		<p>
			<code>${vehiculo}</code>
		</p>
		<a href="vehiculoDB">volver</a>
		<form action="vehiculoDB" method="post">
			<div class="form-group">
				<label for="modelo">Modelo</label>
				<input type="text" autofocus value="${vehiculo.modelo}" class="form-control" id="modelo" name="modelo" placeholder="Modelo" required="required">
				<label for="plazas">Nºplazas</label>
				<input type="number" min="1" value="${vehiculo.plazas}" max="15" step="1" class="form-control" id="plazas" name="plazas" placeholder="minimo 1" required="required">
				<label for="dimensiones">Dimensiones</label>
				<input type="text" value="<fmt:formatNumber type="number" 
            pattern="##,###0.00" value="${vehiculo.dimensiones}" />" class="form-control" id="dimensiones" name="dimensiones"
					placeholder="m" required="required">
				<label for="potencia">Potencia</label>
				<input type="text" value="<fmt:formatNumber type="number" 
            pattern="##,###0.00" value="${vehiculo.potencia}" />" class="form-control" id="potencia" name="potencia" placeholder="0 cvv"
					required="required">
				<input type="hidden" name="op" value="<%=VehiculoCRUDControllerDB.OP_GUARDAR%>">
				<label for="id">Identificador:</label>
				<input type="text" name="id" value="${vehiculo.id}" readonly>
				<br>
				<!-- puede estar disable y visible read only -->
			</div>
			<c:if test="${vehiculo.id == -1}">
				<button type="submit" class="btn btn-default" value="Crear">Crear</button>
			</c:if>
			<c:if test="${vehiculo.id != -1}">
				<button type="submit" class="btn btn-default" value="Modificar">Modificar</button>
			</c:if>
			<!-- formulario eliminar -->
		</form>
	</div>
	<c:if test="${vehiculo.id != -1}">
		<form action="vehiculo" method="post">
			<input type="hidden" name="op" value="<%=VehiculoCRUDControllerDB.OP_ELIMINAR%>">
			<br>
			<br>
			<br>
			<input type="hidden" name="id" value="${vehiculo.id}">
			<input type="submit" value="Eliminar">
		</form>
	</c:if>
	<div class="row"></div>
</div>
<%@include file="../../includes/footer.jsp"%>