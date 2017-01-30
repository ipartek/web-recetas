<!DOCTYPE html>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>
<!-- Header -->
<!-- Recetas Destacadas Grid Section -->
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Crear fichero de texto</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<p>Ejercico para crear un fichero de texto</p>
		<p>
			Ejericio para crear un fichero de texto, usaremos un
			<code>Stream</code>
			del tipo
			<code>FileWriter</code>
			.
		</p>
		<p>
			Acordaros de usar un
			<code>Buffer</code>
			del tipo
			<code>BufferedWriter</code>
			para mejorar la escritura.
		</p>
		<p>Capitulo 10, pag. 158.</p>
		<hr>
		<%@include file="../includes/mensaje.jsp"%>
		<hr>
		
		<form action="files" method="post">
			<input type="text" class="form-control" name="nombre" required placeholder="Nombre" autofocus>
			<br>
			<textarea class="form-control" rows="20" cols="10" name="contenido" required placeholder="Su texto"></textarea>
			<br>
			<input type="submit" class="btn btn-default" value="crear">
		</form>
	</div>
	<!--  <div class="row"> -->
</div>
<!--  <div class="container"> -->
<%@include file="../includes/footer.jsp"%>