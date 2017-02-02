
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>
<%@ page import="java.io.*"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>jercicio para realizar a pelo una consulta en BBDD</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<code> SELECT * FROM `vehiculo`</code>
		<br>
		<h2>Listado vehiculos</h2>
		${vehiculos}
	</div>
</div>
<%@include file="../../includes/footer.jsp"%>