
<%@page import="com.ipartek.formacion.recetas.controller.RecetasController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>CRUD</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		`
		
		<%@include file="../../includes/mensaje.jsp"%>
		<p>
			Realizamos un formulario para poder crear una nuevo
			<code>Receta</code>
		</p>
		
		<a href="receta">volver</a>
		<form action="receta" method="post">
			<div class="form-group">
				<label for="titulo">Titulo</label>
				<input type="text" autofocus value="${receta.titulo}" class="form-control" id="titulo" name="titulo" placeholder="Titulo" required="required">
				<label for="tiempo">Tiempo</label>
				<input type="text"  value="${receta.tiempo}" class="form-control" id="tiempo" name="tiempo" placeholder="Tiempo" required="required">
				<label for="comensales">Tiempo</label>
				<input type="number"  value="${receta.comensales}" class="form-control" id="comensales" name="comensales" placeholder="comensales" required="required">
				<label for="descripcion">descripcion</label>
				<input type="text"  value="${receta.descripcion}" class="form-control" id="descripcion" name="descripcion" placeholder="descripcion" required="required">
				<label for="imagen">imagen</label>
				<input type="text"  value="${receta.imagen}" class="form-control" id="imagen" name="imagen" placeholder="imagen" required="required">
				<input type="hidden" name="op" value="<%=RecetasController.OP_GUARDAR%>">
				<label for="id">Identificador:</label>
				<input type="text" name="id" value="${receta.id}" readonly>
				<br>
				<!-- puede estar disable y visible read only -->
			</div>
			<c:if test="${receta.id == -1}">
				<button type="submit" class="btn btn-default" value="Crear">Crear</button>
			</c:if>
			<c:if test="${receta.id != -1}">
				<button type="submit" class="btn btn-default" value="Modificar" style="display:inline-block">Modificar</button>
			</c:if>
			<!-- formulario eliminar -->
		</form>
	</div>
	<c:if test="${receta.id != -1}">
		<form action="receta" method="post" style="display:inline-block">
			<input type="hidden" name="op" value="<%=RecetasController.OP_ELIMINAR%>">
			
			<br>
			<input type="hidden" name="id" value="${receta.id}">
			<button type="submit" class="btn btn-default" value="Eliminar">Eliminar</button>
		</form>
	</c:if>
	<div class="row"></div>
</div>
<%@include file="../../includes/footer.jsp"%>