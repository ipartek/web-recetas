
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>


<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Sorteo con dado</h1>
			</div>
		</div>
	</div>
</header>

<div class="container">
	<div class="row">
			<div class="col-lg-12" id="posImagen">
		<c:if test="${usuario!=null}"></c:if>
		<div id="posTitulo">
			<h2><span id="tamLetra">${usuario.nombre}</span></h2>
		</div>	
			<img src="img/profile.png" class="img-circle tamImgDado"
				alt="Cinque Terre"><br/><br/>
							<p><strong><em>Número usuarios: </em></strong>${num_personas}<br/>
			<div id="posBoton">
				<a href="dado?op=2" class="btn btn-info btn-lg" role="button">Lanzar</a>
			</div>
		</div>

	</div>
	<!--  <div class="row"> -->
</div>
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp"%>