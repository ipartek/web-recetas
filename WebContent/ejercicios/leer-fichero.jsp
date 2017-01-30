<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

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
      		
      		<%@include file="../includes/mensaje.jsp" %>
      		
      		<ul>
      		 <%
      			File [] files = (File [])request.getAttribute("files");  
      		 	if ( files != null ){
			        for (int i = 0; i < files.length; i++) {		           
			           if(!files[i].isDirectory()){
			        %>
			        <li>
			          <a href="#"><%=files[i].getName()%></a> <%=files[i].length()%> bytes 
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