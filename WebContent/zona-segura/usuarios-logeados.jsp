<%@page import="com.ipartek.formacion.recetas.listener.ListenerContadorUsuarios"%>
<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	<section id="portfolio">
        <div class="container">
            <div class="row">
            <h1>Usuarios logeados en sesion</h1>
            <p>Listado usuarios</p>
            <p>Utilizamos un <code>Listener</code> para mostrar y contar los usuarios logeados, estos los guardamos en un <code>ArrayList</code> y los mostramos en esta tabla.
            <table class="display data-table-mio" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			            	<th>Id</th>
			                <th>Nombre</th>
			                <th>Email</th>
			                <th>Imagen</th>
			            </tr>
			        </thead>
			        <tbody>
            			<c:forEach var="u" items="<%=ListenerContadorUsuarios.usuarioslogeados%>">
			           	<tr>
			                <td>${u.id}</td>
			                <td>${u.nombre}</td>
			                <td>${u.email}</td>
			                <td><a href="${u.imagen}"><img style="width:50px;" src="${u.imagen}"></a></td>
			                
			            </tr>
			            </c:forEach>
			            
					</tbody>
				</table>	
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
	