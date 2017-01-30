<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	<section id="portfolio">
        <div class="container">
            <div class="row">
            <h1>Ejercicio para crear ficheros de texto</h1>
            <p>Ejercicio para crear ficheros de texto, usaremos un <code>Stream</code> del tipo <code>FileWritter</code></p>
            <p>Acordaros de usar un <code>Buffer</code> para mejorar la escritura</p>
            <p>Cap 10, pag.158.</p>
            
            <%@include file="../../includes/mensaje.jsp" %>
            <hr>
            	<form action="files" method="post">
            		<label for="nombre">Nombre del fichero</label>
            		<input type="text" name="nombre" required autofocus placeholder="Nombre fichero sin extension"></br></br>
            		<textarea name="contenido" rows="10" cols="100"></textarea></br></br>
            		<input type="submit" value="Crear">
            	</form>
            
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
	