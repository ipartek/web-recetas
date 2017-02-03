<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	
 	<section id="portfolio">
   		<div class="container">
      		<div class="row">
      		
			<h1>Ejercicio que vuelca los datos de un txt en una BBDD</h1></br></br>
			
			<form action="personas" method="post">
				<input type="submit" value="Panic Button">
			</form>
			
			<p>Se han insertado ${correctos} correctamente</p>
			<p>Se han insertado ${erroneos} erroneos</p>
			<p>Se han detectado ${menores} menores de edad. <c:if test="${menores > 10 }"><code>¡Explotadores!</code></c:if></p>
			<p>Ha tardado ${tiempo} milisegundos</p>
			
			<%@include file="../../includes/mensaje.jsp" %>
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