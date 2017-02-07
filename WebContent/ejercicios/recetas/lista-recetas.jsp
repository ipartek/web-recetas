<%@page import="com.ipartek.formacion.recetas.controller.RecetasController"%>
<%@include file="../../includes/head.jsp" %>
<body id="page-top" class="index">

    <%@include file="../../../includes/nav.jsp" %>
   
    <section id="portfolio">
        <div class="container">
            <div class="row"></br></br>
            	<h1>CRUD Recetas</h1>
            	<p>(Create, Read, Update, Delete)</p>
            	<%@include file="../../includes/mensaje.jsp" %>
          		</br></br>
          		<h2><a href="recetas?op=3">Crear Nueva</a></h2>
            	</br></br>
            	<table class="display data-table-mio" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			            	<th>Id</th>
			                <th>Titulo</th>
			                <th>Dificultad</th>
			                <th>Comensales</th>
			                <th>Descripcion</th>
			                <th>Tiempo</th>
			                <th>Imagen</th>
			            </tr>
			        </thead>
			        <tbody>
            			<c:forEach var="r" items="${recetas}">
			           	<tr>
			                <td>${r.id}</td>
			                <td><a href="recetas?op=<%=RecetasController.OP_VER_DETALLE%>&id=${r.id}">${r.titulo}</a></td>
			                <td>${r.dificultad}</td>
			                <td>${r.comensales}</td>
			                <td>${r.descripcion}</td>
			                <td>${r.tiempo}</td>
			                <td><a href="${r.imagen}"><img style="width:50px;" src="${r.imagen}"></a></td>
			                
			            </tr>
			            </c:forEach>
			            
					</tbody>
				</table>	
				
            	
            	<!-- <ul class="listacoches">
            		
            	</ul>-->
            	
            	
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
