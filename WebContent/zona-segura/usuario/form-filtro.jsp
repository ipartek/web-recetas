<%@page import="com.ipartek.formacion.recetas.controller.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Filtro de Formulario</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<p>
			<a href="zona-segura/usuario">Volver</a>
		</p>
		<br>
		<form action="zona-segura/usuario" method="post">
			<input type="hidden" name="op" class="form-control" value="6" />
			<label for="dni">dni :</label>
			<input type="text" name="dni" class="form-control" placeholder="Escribe un DNI" />
			<br>
			<label for="email">E-Mail :</label>
			<input type="text" name="email" class="form-control" placeholder="Escribe un e-mail" />
			<br>
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" class="form-control" placeholder="Escribe un nombre " />
			<label for="apellido1">Apellido 1</label>
			<input type="text" name="apellido1" class="form-control" placeholder="Escribe un el primer apellido " />
			<label for="apellido2">Apellido 2</label>
			<input type="text" name="apellido2" class="form-control" placeholder="Escribe el segundo apellido " />
			<br>
			<label>Edad Minima:</label>
			<input type="range" name="min" min="1" max="130">
			<label>Edad Maxima:</label>
			<input type="range" name="max" min="1" max="130">
			<br>
			<input type="submit" value="Filtrar">
		</form>
	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->
<%@include file="../../includes/footer.jsp"%>