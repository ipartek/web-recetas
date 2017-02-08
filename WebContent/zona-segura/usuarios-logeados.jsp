<%@page import="com.ipartek.formacion.recetas.listener.ListenerContadorUsuarios"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Usuarios Logeados en Session</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
       		<p>Empleamos un Listener de Session <code>ListenerContadorUsuario</code> para gestionar los usuarios conectados.</p>
       		<p>Ver documentacion de Listener en: <a target="_blank" href="javadoc/index.html">JavaDoc</a></p>
       		
       		<br>
       		
			<p>Listado usuarios:</p>
			
			<br>
			
			<table class="display data-table-mio miTabla">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Email</th>
						<th>Password</th>
						<th>Imagen</th>
						<th>GitUserName</th>
					</tr>
				</thead>
				
				<tbody>
					
					<c:forEach var="u" items="<%=ListenerContadorUsuarios.usuariosLogeados%>">
								
						<tr>
							<td>${u.nombre}</td>
							<td>${u.email}</td>
							<td>${u.password}</td>
							<td><img class="imgTabla" alt="Foto Usuario" src="${u.imagen}"></td>
							<td>${u.gitUserName}</td>
						</tr>
					</c:forEach>
						
				</tbody>
				
			</table>
			
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		