<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.vehiculo.pojo.Vehiculo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>

<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Vehiculoa</h1>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div class="row">
		<div id="imagenVehiculo">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded" alt="">
		</div>
		<%@include file="../../includes/mensaje.jsp"%>
		<div class="row">
			<ul class="list-group">
				<%
				ArrayList<Vehiculo> f = (ArrayList<Vehiculo>)request.getAttribute("vehiculos");
					for (Vehiculo v : f) {
				%>
				<li class="list-group-item">
					
						${v.getModelo()}
					
				</li>

				<%
					} //end for
				%>
			</ul>
		</div>

	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp"%>