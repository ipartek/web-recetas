<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<%@page import="com.ipartek.formacion.recetas.controller.UsuarioCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>

   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Usuarios </h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
       
       	<%@include file="../../includes/mensaje.jsp" %>
        
       
       <a href="zona-segura/usuario?op=3">Crear Nuevo Usuario</a>
       		<p>LISTADO DE USUARIOS:</p>
			
			<table class="display data-table-mio" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>id</th>
	                <th>Nombre</th>
	                <th>Apellido 1</th>
	                <th>Apellido 2</th>
	                <th>Edad</th>
	                <th>Email</th>
	                <th>Dni</th>
	                <th>Puesto</th>
	                <th>Password</th>	 
	                <th>Imagen</th>                               
	            </tr>
	        </thead>        
	        <tbody>
				<c:forEach var="u" items="${listaUsuario }">
					<tr>
						<td><a href="zona">${u.id}</a></td>
						<td>${u.nombre}</td>
						<td>${u.apellido1}</td>
						<td>${u.apellido2}</td>
						<td>${u.edad}</td>
						<td>${u.email}</td>
						<td>${u.dni}</td>
						<td>${u.puesto}</td>
						<td>${u.password}</td>
						<td><img height="150px" width="150px" src="${u.imagen}" alt="foto del usuario"></td>
					</tr>
				</c:forEach>
			  </tbody>
     	  </table>
			
		</div>
	</div>	
	
	
<%@include file="../../includes/footer.jsp" %>		