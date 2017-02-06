
<%@page import="com.ipartek.formacion.controller.JspMigracionController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<%@ page import="java.io.*"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Ejercicio para migrag de un fichero a la BBDD</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<br>
			<%@include file="../../includes/mensaje.jsp" %>
			
			<p></p>
			<form action="migracion" method="get">
				<button type="submit" class="btn btn-default">Iniciar migracion</button>
				${tiempo}
				<br>
				<br>
			</form>
		</div>
	</div>
</div>
<%@include file="../../includes/footer.jsp"%>