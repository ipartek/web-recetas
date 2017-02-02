<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
 <body>
 <header>
	        <div class="container header-content">
	            <div class="row">
	                <div class="col-lg-12">
	                	<h1>Dado magico!</h1>
	                </div>
	              </div>  
	  		</div> 
</header> 
				<%@include file="../includes/mensaje.jsp" %>
				<div class="usuarioelegido">
				<p> El afortunado a leer es: ${usuario.getNombre()}
				<img src="${usuario.getImagen() } ">
				</div>
				
				<a href="dado">Tirar dado</a>
</body>
<%@include file="../includes/footer.jsp" %>