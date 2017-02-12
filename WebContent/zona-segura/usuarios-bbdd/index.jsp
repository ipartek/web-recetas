<%@page import="com.ipartek.formacion.recetas.services.ServiceUsuarioMysql"%>
<%@page import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
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
        
        <form action="usuario" method="post">
        	<label for="email">Filtrar por Email:   </label>	
        	<input type="text" name="email" value="">	         
	        <input type="hidden" name="op" value="<%=UsuarioCRUDController.OP_FILTRAR_EMAIL%>">       	
        	<input type="submit" value="filtrar">
        </form>
        
        <form action="usuario" method="post">
        	<label for="dni">Filtrar por Número de DNI:   </label>	
        	<input type="text" name="dni" value="">	         
	        <input type="hidden" name="op" value="<%=UsuarioCRUDController.OP_FILTRAR_DNI%>">       	
        	<input type="submit" value="filtrar">
        </form>
        
       <br>
       <hr>
       <br>
       <a href="usuario?op=3">Crear Nuevo</a>
       <br>
       <br>
       <c:if test="${usuarioFiltrado != null}">
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
	         <tr>
	           	<td>${usuarioFiltrado.id}</td> 
	            <td><a href="usuario?op=2&id=${u.id}">${usuarioFiltrado.nombre}</a></td>
	            <td>${usuarioFiltrado.apellido1}</td>
	            <td>${usuarioFiltrado.apellido2}</td>
	            <td>${usuarioFiltrado.edad}</td>
	            <td>${usuarioFiltrado.email}</td>   
	            <td>${usuarioFiltrado.dni}</td>   
	            <td>${usuarioFiltrado.puesto}</td>   
	            <td>${usuarioFiltrado.password}</td>   
	            <td><img src="${usuarioFiltrado.imagen}"></td>         
	         </tr>    
       </tbody>
       </table>
       </c:if>
       
       <c:if test="${usuarioFiltrado == null}">
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
        </c:if>
       
       
       <p>Total Usuarios: ${totalUsuarios}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
