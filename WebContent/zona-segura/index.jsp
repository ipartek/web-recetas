<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>
<header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Zona segura</h1>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<img class="img-responsive logo-home" src="img/profile.png" alt="logotipo de Web Recetas">
			<p>* No deberias poder acceder a esta url a menos que estes logeado.</p>
			<p>Usamos un filtro<code>FilterZonaSegura</code>
				para comprobar la seguridad en las urls<code>/zona-segura/*</code></p>
			<p>${usuario}</p>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>