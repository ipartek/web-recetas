<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	
 	<section id="portfolio">
   		<div class="container">
      		<div class="row">
			<h1>Ejercicio para realizar a pelo una consulta en BBDD</h1>
			<p><code>SELECT * FROM `vehiculo`</code></p>
			<p>Podremos insertar nuevos tambien</p>
			<p><code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potecia`) VALUES (NULL, '?', '2', '900');</code>
			<p>Cuando creemos el PreparedStatement reemplazaremos el <b>?</b> por el campo del formulario.</p>
			<%@include file="../../includes/mensaje.jsp" %>
			</br>
			
			<form action="jdbc" method="post">
				<input type="text" name="modelo" required>
				<input type="submit" value="Crear Vehiculo">
			</form>
			
			<h2>Listado Vehiculos</h2></br>
			
			${vehiculos}
    		</div> 
   	 		<!--  <div class="row"> -->
		</div>    
		<!-- <div class="container"> -->
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