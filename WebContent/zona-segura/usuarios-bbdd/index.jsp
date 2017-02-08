<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>CRUD Usuario</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
       
       <a href="usuario?op=3">Crear Nuevo</a>
       
       <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Identificador</th>
                <th>Nombres</th>
                <th>Email</th>               
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="u" items="${usuarios}">        
	            <tr>
	             	<td>${u.id}</td> 
	                <td><a href="usuario?op=2&id=${u.id}">${u.nombre}</a></td>
	                <td>${u.email}</td>      
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
       
       
       <p>Total Usuarios: ${u.usuariosTotales()}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
