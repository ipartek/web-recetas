<%@include file="/includes/head.jsp" %>
<body id="page-top" class="index">
	
	<%@include file="/includes/nav.jsp" %>
	 <section id="portfolio">
        <div class="container">
            <div class="row"></br></br>
            <h1>Dado para lectores</h1></br></br>
            <div class="usuarioelegido">
            	<p>El afortunado a leer es: ${ usuario.getNombre() }</p>
            	<img src="${usuario.getImagen()}">
            </div>
            <a href="dado" class="dadoboton">Tirar dado</a>
            </div>
        </div>
     </section>
	
	<%@include file="/includes/footer.jsp" %>
	
	<!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/freelancer.min.js"></script>

</body>

</html>