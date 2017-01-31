<%@page import="com.ipartek.formacion.recetas.controller.FicheroController"%>
<%@page import="java.io.File"%>
<%@include file="../../includes/head.jsp" %>

<body id="page-top" class="index">

 	<%@include file="../../../includes/nav.jsp" %>
 	<section id="portfolio">
        <div class="container">
            <div class="row">
            <%@include file="../../includes/mensaje.jsp" %>
            <ul>
      		 <%
      		 	//Buscar ficheros en PATH
 				File ficheros = new File(FicheroController.PATH); 				
      			File [] files = ficheros.listFiles();  
      		 	if ( files.length > 0 ){
      		 		File f = null;
			        for (int i = 0; i < files.length; i++) {
			           f = files[i];	
			           if(!f.isDirectory()){
			        %>
			        <li>
			          <a href="files?nombre=<%=f.getName()%>"><%=f.getName()%></a> (<%=f.length()%> bytes) 
			        </li>  
			        <%
			                }//end if
			            }//end for
      		 	}else{
      		 		out.print("<li>No existen ficheros creados todavia!!!</li>");
      		 	}   
			     %>
		     </ul>
            
             <hr>
           
            <textarea name="contenido" rows="10" cols="100">${texto}</textarea>
            
            
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
	