<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<body id="" class="index">
    
    <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>CRUD Vehiculo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
       <div class="listadocoches">
       <ul style="list-style-type:square">
       <%
       ArrayList<Vehiculo> lista = (ArrayList<Vehiculo>) request.getAttribute("vehiculos");
       		for(Vehiculo v:lista ){
       			%>
       			
       			<li> <%=v.getModelo() %> <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></li>
       			
       			<% 
       		}
       
       
       %>
       </ul>
       </div>
        
        ${vehiculos}
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
                
 <%@include file="../../includes/footer.jsp" %>