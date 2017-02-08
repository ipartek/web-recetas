<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ipartek.formacion.recetas.listener.ListenerContadorUsuarios"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Usuario logueados en sesion</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<p>Listado usuarios</p>
      	<p>Vamos a usar un listener para mostrar los usuarios conectados<p>
      	<p>Ver documentacion en: <a target="blank"href="\javadoc\index.html"></a></p>	
			
      	   <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Imagen</th>
                <th>Nombre</th>
                           
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="user" items="<%=ListenerContadorUsuarios.usuariosLogueados%>">        
	            <tr>
	            	<td>${user.id()}</td>
	                <td><img src="${user.imagen}alt="foto del usuario"></td>
	                <td>${user.nombre}</td>
	                   
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
      
     <%=ListenerContadorUsuarios.usuariosLogueados%>
      	
  
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
       
  
<%@include file="../../includes/footer.jsp" %>