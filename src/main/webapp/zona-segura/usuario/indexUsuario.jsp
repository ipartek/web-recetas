<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<%@page
	import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>


<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Usuarios</h1>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div class="row">

		<%@include file="../../includes/mensaje.jsp"%>

		<br />
		
		<button style="display: inline" type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#modalFiltro">Filtrar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<form style="display: inline" action="zona-segura/usuario" method="post">
				<input type="submit" class="btn btn btn-danger"
					value="Eliminar Filtro"> <input type="hidden" name="op"
					value="<%=UsuarioCRUDController.OP_LISTAR%>">
			</form>

		<!-- Modal -->
		<div class="modal fade" id="modalFiltro" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Filtrar</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="zona-segura/usuario" method="post">

							<label class="radio-inline"><input type="radio"
								name="optradio" value="nombre" checked="checked">Nombre</label>
							<label class="radio-inline"><input type="radio"
								name="optradio" value="dni">Dni</label> <label
								class="radio-inline"><input type="radio" name="optradio"
								value="email">Email</label> <input type="text" name="filtro"
								class="form-control" id="filtro" required="required"><br />
							<input type="submit" class="btn btn-info" value="Filtrar">
							<input type="hidden" name="op"
								value="<%=UsuarioCRUDController.OP_FILTRAR%>">
						</form>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<p>
		LISTADO DE USUARIOS:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			class="btn btn-success" href="zona-segura/usuario?op=3">Crear
			Nuevo Usuario</a>
	</p>

	<table class="display data-table-mio" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Apellido 1</th>
				<th>Apellido 2</th>
				<th>Edad</th>
				<th>Email</th>
				<th>Dni</th>
				<th>Puesto</th>
				<th>Password</th>
				<th>Imagen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${listaUsuario}">
				<tr>
					<td><a href="zona-segura/usuario?op=2&id=${u.id}">${u.id}</a></td>
					<td>${u.nombre}</td>
					<td>${u.apellido1}</td>
					<td>${u.apellido2}</td>
					<td>${u.edad}</td>
					<td>${u.email}</td>
					<td>${u.dni}</td>
					<td>${u.puesto}</td>
					<td>${u.password}</td>
					<td><img height="150px" width="150px" src="${u.imagen}"
						alt="foto del usuario"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br /> <br /> <a href="index.jsp"><i
		class="fa fa-chevron-circle-left fa-5x" title="Atras"
		aria-hidden="true"></i> </a>
</div>



<%@include file="../../includes/footer.jsp"%>
