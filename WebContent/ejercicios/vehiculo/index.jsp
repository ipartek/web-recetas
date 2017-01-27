<%@include file="../../includes/head.jsp" %>
<body id="page-top" class="index">

    <%@include file="../../../includes/nav.jsp" %>
   
    <section id="portfolio">
        <div class="container">
            <div class="row"></br></br>
            	<h1>CRUD Vehiculo</h1>
            	<p>(Create, Read, Update, Delete)</p>
            	<%@include file="../../includes/mensaje.jsp" %>
          		</br></br>
          		<h2><a href="vehiculo?op=3">Crear Nuevo</a></h2>
            	</br></br>
            	<table class="display data-table-mio" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Modelo</th>
			                <th>Potencia</th>
			                <th>Plazas</th>
			                <th>Dimensiones</th>
			            </tr>
			        </thead>
			        <tbody>
            			<c:forEach var="v" items="${vehiculos}">
			           	<tr>
			                <td><a href="vehiculo?op=<%=VehiculoCRUDController.OP_VER_DETALLE%>&id=${v.id}">${v.modelo}</a></td>
			                <td>${v.potencia}</td>
			                <td>${v.plazas}</td>
			                <td>${v.dimensiones}</td>
			            </tr>
			            </c:forEach>
			            
					</tbody>
				</table>	
				
            	
            	<!-- <ul class="listacoches">
            		
            	</ul>-->
            	
            	<c:set var="comparacion" value="${sessionScope.usuario}"></c:set>
            	<c:if test="${comparacion != null}">
            		<p>Usuario: ${sessionScope.usuario.nombre}</p>
            	</c:if>
            	
            	<p>Total Vehiculos: ${fn:length(vehiculos)}</p>
            	<c:set var="now" value="<%=new java.util.Date()%>"/>
            	<p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p>
            	
            	
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
