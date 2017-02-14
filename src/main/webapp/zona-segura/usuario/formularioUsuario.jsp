<%@page
	import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>

<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>USUARIO</h1>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div id="imagenVehiculo">
		<img src="${usuario.imagen}" class="img-responsive img-rounded" alt="">
	</div>
	<div class="row">
		<%@include file="../../includes/mensaje.jsp"%>

		<form action="zona-segura/usuario" class="anchuraDivFormulario"
			method="post">
			<div class="form-group">
				<label for="id">Identificador:</label> <input class="form-control"
					type="text" name="id" value="${usuario.id}" readonly>
			</div>
			<div class="form-group">

				<label for="nombre">Nombre:</label> <input autofocus
					class="form-control" type="text" name="nombre" required
					value="${usuario.nombre}">
			</div>
			<div class="form-group">

				<label for="apellido1">Apellido1:</label> <input
					class="form-control" type="text" name="apellido1" required
					value="${usuario.apellido1}">
			</div>
			<div class="form-group">

				<label for="apellido2">Apellido2:</label> <input
					class="form-control" type="text" name="apellido2" required
					value="${usuario.apellido2}">
			</div>

			<div class="form-group">
				<label for="edad">Edad:</label> <input type="number" name="edad"
					class="form-control" required value="${usuario.edad}" />"
			</div>
			<div class="form-group">

				<label for="email">Email:</label> <input type="email" name="email"
					class="form-control" required value="${usuario.email}">
			</div>
			<div class="form-group">
				<label for="dni">Dni:</label> <input type="text" name="dni" required
					class="form-control" value="${usuario.dni}">
			</div>
			<div class="form-group">
				<label for="puesto">Puesto:</label> <input type="text" name="puesto"
					class="form-control" required value="${usuario.puesto}">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" name="password" required
					value="${usuario.password}">
			</div>
			<div class="form-group">

				<label for="imagen">Imagen:</label> <input type="text"
					class="form-control" name="imagen" required
					value="${usuario.imagen}">
			</div>
			<div class="form-group">

				<input type="hidden" name="op"
					value="<%=UsuarioCRUDController.OP_GUARDAR%>"> <input
					type="submit" value="Modificar" style="display: inline" class="btn btn-success"> <input  type="hidden"
					value="modificar" name="crearModificar">
			</div>
		</form>


		<!-- Formulario Eliminar -->
		<c:if test="${usuario.id != -1}">
			<form action="zona-segura/usuario" method="post">
					<input style="display: inline" class="btn btn-danger"
					type="submit" value="Eliminar">
					<input  type="hidden" name="op"
					value="<%=UsuarioCRUDController.OP_ELIMINAR%>"> 
					<input
					type="hidden" name="id" value="${usuario.id}"> 

			</form>
		</c:if>

		<a href="/zona-segura/usuario"><i
			class="fa fa-chevron-circle-left fa-5x" title="Atras"
			aria-hidden="true"></i> </a>


	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp"%>