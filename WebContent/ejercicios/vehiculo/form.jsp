<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	 <section id="portfolio">
        <div class="container">
            <div class="row">
			 	<h1>Formulario vehiculos</h1>
			 	<%@include file="../../../includes/mensaje.jsp" %>
				<c:set var="identificador" scope="request" value="${vehiculo.id}"/>
				<c:if test="${identificador < 0}">
					<form action="vehiculo" method="post">
						<label>Modelo: </label></br>
						<input type="text" name="modelocrear" placeholder="Modelo" required pattern=".{2,255}"/></br></br>
						<label>Potencia:</label></br>
						<input type="text" name="potenciacrear" placeholder="Potencia" required/></br></br>
						<label>Plazas: </label></br>
						<input type="number" name="plazascrear" placeholder="Nº Plazas" required /></br></br>
						<label>Dimensiones: </label>
						<input type="number" name="dimensionescrear" placeholder="Dimensiones" required /></br></br>
						<input type="hidden" name="op" value="4"/>
						<input type="hidden" name="id" value="${vehiculo.id}"/>
						<input type="submit" value="Crear Coche"/>
					</form></br></br>
					<a href="javascript:history.back()">Volver</a>
				</c:if>
				<c:if test="${identificador > 0}">
					<form action="vehiculo" method="post">
						<label>Modelo: </label></br>
						<input type="text" name="modelocrear" value="${vehiculo.modelo}" required pattern=".{2,255}"/></br></br>
						<label>Potencia:</label></br>
						<input type="text" name="potenciacrear" value="${vehiculo.potencia}"/></br></br>
						<label>Plazas: </label></br>
						<input type="number" name="plazascrear" value="${vehiculo.plazas}"  required /></br></br>
						<label>Dimensiones: </label>
						<input type="number" name="dimensionescrear" value="${vehiculo.dimensiones}" required /></br></br>
						<input type="hidden" name="op" value="4"/>
						<input type="hidden" name="id" value="${vehiculo.id}"/>
						<input type="submit" value="Modificar"/>
					</form>
					<form action="vehiculo" method="post">
						<input type="hidden" name="op" value="5"/>
						<input type="hidden" name="id" value="${vehiculo.id}"/>
						<input type="submit" value="Eliminar"/>
					</form></br></br>
					<a href="javascript:history.back()">Volver</a>
				</c:if>
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
	