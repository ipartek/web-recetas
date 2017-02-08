<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	 <section id="portfolio">
        <div class="container">
            <div class="row">
            <h1>Formulario Recetas</h1>
            <%@include file="../../../includes/mensaje.jsp" %>
            	<div class="formularios" style="float:left;width:500px;margin-left:120px;">
				<c:set var="identificador" scope="request" value="${receta.id}"/>
				<c:if test="${identificador < 0}">
					<form action="recetas" method="post">
						<label>Nombre: </label></br>
						<input type="text" name="titulocrear" placeholder="Nombre" required/></br></br>
						<label>Imagen: </label></br>
						<input type="text" name="imagencrear" placeholder="Link de la imagen" required/></br></br>
						<label>Tiempo: </label></br>
						<input type="text" name="tiempocrear" placeholder="Tiempo" required/></br></br>
						<label>Dificultad: </label></br>
						<input type="text" name="dificultadcrear" placeholder="Dificultad" required/></br></br>
						<label>Comensales: </label></br>
						<input type="text" name="comensalescrear" placeholder="Comensales" required/></br></br>
						<label>Descripcion: </label></br>
						<input type="text" name="descripcioncrear" placeholder="Descripcion" required/></br></br>
						<input type="hidden" name="op" value="4"/>
						<input type="hidden" name="id" value="${receta.id}"/>
						<input type="submit" value="Crear Receta"/>
					</form></br></br>
					<a href="javascript:history.back()">Volver</a>
				</c:if>
				<c:if test="${identificador > 0}">
					<form action="recetas" method="post">
						<label>Nombre: </label></br>
						<input type="text" name="titulocrear" value="${receta.titulo}" required/></br></br>
						<label>Imagen: </label></br>
						<input type="text" name="imagencrear" value="${receta.imagen}" required/></br></br>
						<label>Tiempo: </label></br>
						<input type="text" name="tiempocrear" value="${receta.tiempo}" required/></br></br>
						<label>Dificultad: </label></br>
						<input type="text" name="dificultadcrear" value="${receta.dificultad}" required/></br></br>
						<label>Comensales: </label></br>
						<input type="text" name="comensalescrear" value="${receta.comensales}" required/></br></br>
						<label>Descripcion: </label></br>
						<input type="text" name="descripcioncrear" value="${receta.descripcion}" required/></br></br>
						<input type="hidden" name="op" value="4"/>
						<input type="hidden" name="id" value="${receta.id}"/>
						<input type="submit" value="Modificar"/>
					</form>
					<form action="recetas" method="post">
						<input type="hidden" name="op" value="5"/>
						<input type="hidden" name="id" value="${receta.id}"/>
						<input type="submit" value="Eliminar"/>
					</form></br></br>
					<a href="javascript:history.back()">Volver</a>
				</c:if>
				</div>
				<div style="float:left;"><img style="width:400px;" src="${receta.imagen}"></div>
				
			</div>
		</div>
		
	</section>
			
	<%@include file="../../includes/footer.jsp" %>
				
	 <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Datatable -->
	<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	
    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/freelancer.min.js"></script>
    
    
    <!-- Custom Javascript -->
    <script src="js/custom.js"></script>
    

</body>
</html>
