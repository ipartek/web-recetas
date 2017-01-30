<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
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
        
       
       <a href="vehiculo?op=3">Crear Nuevo</a>
       
       <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>                
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="v" items="${vehiculos}">        
	            <tr>
	                <td><a href="vehiculo?op=2&id=${v.id}">${v.modelo}</a></td>
	                <td>${v.plazas}</td>
	                <td>	                	
	                	<fmt:formatNumber pattern="#,##0.00" value="${v.dimensiones}"/>
	                </td>
	                <td>
	                	<fmt:formatNumber pattern="#,###0.000" value="${v.potencia}"/>
	                </td>        
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
       
       
  
       
       
       
       <c:set var="user" scope="session" value="${sessionScope.usuario}"></c:set>       
       <c:choose>
       		<c:when test="${user==null}">
       			<p>Usuario No Conectado</p>			
       		</c:when>
       		<c:when test="${user!=null}">
       			<p>Usuario: ${user.nombre}</p>
       		</c:when>
       </c:choose>
       
       
       
       <p>Total Vehiculos: ${fn:length(vehiculos)}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
