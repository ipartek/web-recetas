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
       		<p>Empleamos un Listener de Session <code>ListenerContadorUsuarios</code> para gestionar los usuarios logeados.</p>
       		<p>Ver documentación de Listener en: <a target="_blank" href="javadoc/index.html">javadoc</a></p> 
			<p>Listado usuarios:</p>
			
			<table class="display data-table-mio" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>id</th>
	                <th>Foto</th>
	                <th>Nombre</th>
	                <th>Email</th>	                                
	            </tr>
	        </thead>        
	        <tbody>
				<c:forEach var="u" items="<%=ListenerContadorUsuarios.usuariosLogeados%>">
					<tr>
						<td>${u.id}</td>
						<td><img src="${u.imagen}" alt="foto del usuario"></td>
						<td>${u.nombre}</td>
						<td>${u.email}</td>
					</tr>
				</c:forEach>
			  </tbody>
     	  </table>
			
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		