<%@page import="com.ipartek.formacion.recetas.controller.FicheroController"%>
<%@include file="../includes/header.jsp" %>

<%@ page import="java.io.*" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Leer Ficheros</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
      		<p>Ejericio para leer ficheros creados desde <a href="ejercicios/crear-fichero.jsp">ejercicios\crear-fichero.jsp</a></p>      		
      		
      		<%@include file="../includes/Mensaje.jsp" %>
      		
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
			          <a href="#"><%=f.getName()%></a> (<%=f.length()%> bytes) 
			        </li>  
			        <%
			                }//end if
			            }//end for
      		 	}else{
      		 		out.print("<li>No existen ficheros creados todavia!!!</li>");
      		 	}   
			     %>
		     </ul>
  
	    </div> 
	    <!--  <div class="row"> -->
	</div>    
	<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>
