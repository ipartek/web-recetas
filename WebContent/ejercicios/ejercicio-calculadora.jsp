<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
    <section>
    	<h1>CALCULADORA</h1>
        <div class="container">
            <div class="row">  
               	<form action="calculadora" method="post">
               		<!-- Recordar que para mapear este campo input es importante el atributo name -->
               		<p>Precio: </p>
               		<input type="number" name="precio" placeholder="Escribe el precio"><br><br>
               		<p>IVA: </p>
               		<input type="number" name="iva" placeholder="Indica el iva a calcular"><br><br>
               		
               		<p>Precio con IVA: </p>
               		
               		<%
               			if (request.getAttribute("precioConIva") != null){
               		%>
               		
               		<input type="number" name="precioConIva" placeholder="" value="${precioConIva }" disabled="disabled" readonly="readonly"><br><br>
               		
               		
               		<%		
               			}else{
               		%>
               		
					<input type="number" name="precioConIva" placeholder="" value="" disabled="disabled" readonly="readonly"><br><br>
               		
               		<%		
               			}
               		%>
               	 	
               		
               		
               		<input type="submit" value="Calcular">
               	</form>                       	
            </div>
    	</div>
    </section>	       
                

    
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
