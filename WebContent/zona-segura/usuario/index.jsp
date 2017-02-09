<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>CRUD Usuarios</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
      
       <a href="zona-segura/usuario?op=3">Crear Nuevo</a>
       
       
       <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th></th>
                <th>id</th>
                <th>nombre</th>
                <th>apellido1</th>
                <th>apellido2</th>  
                <th>edad</th>
                <th>email</th>
                <th>dni</th>
                <th>puesto</th>
                <th>password</th>
                <th>imagen</th>
                
                  
                            
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="u" items="${usuarios}">        
	            <tr>
	            	<td><a href="zona-segura/usuario?op=5&id=${u.id}">Eliminar</a></td>
	                <td><a href="zona-segura/usuario?op=2&id=${u.id}">${u.id}</a></td>
	                <td>${u.nombre}</td>
	                <td>${u.apellido1}</td>
	                <td>${u.apellido2}</td>
	                <td>${u.edad}</td>
	                <td><a href="zona-segura/usuario?op=6">${u.email}</a></td>
	                <td>${u.dni}</td>
	                <td>${u.puesto}</td>
	                <td>${u.password}</td>
	                <td>${u.imagen}</td>
	                
     
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
       <p>Usuarios Registrados : ${count} </p>
       
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
