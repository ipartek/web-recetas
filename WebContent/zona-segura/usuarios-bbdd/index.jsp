<%@page import="com.ipartek.formacion.recetas.services.ServiceUsuarioMysql"%>
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
                <th>Nombre</th>
                <th>1er Apellido</th>
                <th>2o Apellido</th>
                <th>Edad</th>
                <th>Email</th>
                <th>DNI</th>
                <th>Puesto</th>
                <th>Password</th>
                <th>Imagen</th>               
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="u" items="${usuarios}">        
	            <tr>
	             	<td>${u.id}</td> 
	                <td><a href="usuario?op=2&id=${u.id}">${u.nombre}</a></td>
	                <td>${u.apellido1}</td>
	                <td>${u.apellido2}</td>
	                <td>${u.edad}</td>
	                <td>${u.email}</td>   
	                <td>${u.dni}</td>   
	                <td>${u.puesto}</td>   
	                <td>${u.password}</td>   
	                <td><img src="${u.imagen}"></td>         
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
       
       
       <p>Total Usuarios: ${totalUsuarios}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
