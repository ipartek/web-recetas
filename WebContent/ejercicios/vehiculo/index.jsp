
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
				
				<div class="table-responsive">
					<table class="table table-striped" id="listarTabla">
						<tr>
							<th>ID</th>
							<th>Modelo</th>
							<th>Plazas</th>
							<th>Dimensiones</th>
							<th>Potencia</th>
							<th></th>
						</tr>
					<%
						ArrayList<Vehiculo> vehic = (ArrayList<Vehiculo>) request.getAttribute("vehiculos");
						for (Vehiculo v : vehic){
					%>	
							
						<tr>
							<td><%=v.getId() %></td>
							<td><%=v.getModelo() %></td>
							<td><%=v.getPlazas() %></td>
							<td><%=v.getDimensiones() %></td>
							<td><%=v.getPotencia() %></td>
							<td>
								<img alt="" src="img/lapiz_mini.png">
								<img alt="" src="img/cubo_basura_mini.png">
							</td>
						</tr>
					
					<%
						}
					%>
					
					</table>
				</div>
				
				<!--  end: <div class="table-responsive"> -->				           
				           	
            </div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>