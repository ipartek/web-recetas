

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
			.
		</p>
		<p>
			Al crear un
			<code>Vehiculo</code>
			con numero de plazas inferior a 0, lanzara una excepcion
			personalizada, que es controlada en el Servlet.
		</p>
		<p>
			Tambien tenemos que tener en cuenta los parametros que deben ser
			casteado a
			<code>int</code>
			o
			<code>float</code>
			, puede fallar.
		</p>
		<p>Si creamos coche con exito, mostrar Vehiculo usando Expresion
			Lenguage.</p>
		<p>
			Tambien validamos en el front-end con HTML5
			<code>required</code>
			y
			<code>pattern</code>
			.
		<p>
		<p>
			<code>${vehiculo}</code>
		</p>

		<c:set var="vehiculo" scope="session" value="${vehiculo}" />
		<c:set var="isNew" scope="session" value="${vehiculo.id!=-1}" />

		<form action="vehiculo" method="post">
			<div class="form-group">
				<label for="modelo">Modelo</label>
				 <input type="text" class="form-control" id="modelo" name="modelo" placeholder="Modelo" required="required" pattern="[A-Za-z]{2,255}"> 
				<label for="plazas">Nº plazas</label>
				<input type="number" min="1" max="15" step="1" class="form-control" id="plazas" name="plazas" placeholder="minimo 1" required="required"> 
				<label  for="potencia">Potencia</label>
				 <input type="text" class="form-control" id="potencia" name="potencia" placeholder="0 cvv" required="required">
                <label for="potencia">Potencia</label> <input type="text" class="form-control" id="potencia" name="potencia" placeholder="0 cvv" required="required">
			</div>
			<c:set var="isNew" scope="session" value="${vehiculo.isNew}" />
			<c:if test="${isNew}">
				<button type="submit" class="btn btn-default">Crear</button>
			</c:if>
			<c:if test="${!isNew}">
				<button type="submit" class="btn btn-default">Modificar</button>
			</c:if>
		</form>
	</div>
 <div class="row"> 
</div>


<%@include file="../../includes/footer.jsp"%>