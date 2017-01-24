
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
    <section>
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
				
				<%
					ArrayList<Vehiculos> v = request.getAttribute("vehiculos");
				%>
				
				
				${vehiculos}           
				           	
            </div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>