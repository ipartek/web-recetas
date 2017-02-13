<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<%@page import="com.ipartek.formacion.recetas.controller.UsuarioController"%>
<%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>

   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Listado Usuarios</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
       
       	<%@include file="../../includes/mensaje.jsp" %>
        
       
       <a href="zona-segura/usuario?op=3">Crear Nuevo Usuario</a>
       		<p>Mostrando 500 de <b>${total}</b>
       		
	       		<!-- Button trigger modal -->
				<button type="button" 
				        class="btn btn-default btn-lg" 
				        data-toggle="modal" 
				        data-target="#modalFiltro">
	  				Filtrar
				</button>
			</p>
			
			<div id="modalFiltro" class="modal fade" tabindex="-1" role="dialog">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">Filtro</h4>
			      </div>
			      <div class="modal-body">
			        
			        <form action="zona-segura/usuario" method="post">
			        	<label for="dni">DNI:</label>
			        	<input type="text" name="dni">
			        	
			        	<input type="hidden" name="op" value="<%=UsuarioController.OP_FILTRAR%>">
			        	<button type="submit">Buscar</button>
			        </form>
			        
			        
			      </div>			     
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			
       		
			
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
				<c:forEach var="u" items="${listaUsuario}">
					<tr>
						<td><a href="zona-segura/usuario?op=2&id=${u.id}">${u.id}</a></td>
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