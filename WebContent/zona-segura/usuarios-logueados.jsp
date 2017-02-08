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
      	   <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Imagen</th>
                <th>Nombre</th>
                           
            </tr>
        </thead>        
        <tbody>
        
        	<c:forEach var="r" items="${recetas}">        
	            <tr>
	            	<td>${r.id}</td>
	                <td><a href="receta?op=2&id=${r.id}">${r.titulo}</a></td>
	                      
	            </tr>
           </c:forEach> 
                       
       </tbody>
       </table>
      	<img href=>
      	<%=ListenerContadorUsuarios.usuariosLogueados %>
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
       
  
<%@include file="../../includes/footer.jsp" %>