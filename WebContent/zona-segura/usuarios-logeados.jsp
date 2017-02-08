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
 			<p>Empleamos un Listener de sesssion <code>ListenerContadorUsuarios</code> </p>
 			<p> Ver documentacion de Listener en: <a target="_blank" href="javadoc/index.html">javadoc</a></p>
 			<p>Listado usuarios:</p>
 		
<br>

<table class="display data-table-mio">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Password</th>
                <th>Imagen</th>
                <th>GitUserName</th>
        
            </tr>
        </thead>
        <tbody>
        <c:forEach items="<%=ListenerContadorUsuarios.usuariosLogeados%>" var="u" >
            <tr>
                <td>${u.id}</td>
                <td>${u.nombre}</td>
                <td>${u.email}</td>
                <td>${u.password}</td>
                <td>${u.imagen}</td>
                <td>${u.gitUserName}</td>
               
             
            </tr>
           </c:forEach>
       </tbody>
    </table>

</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
 			
 
 	

 	
<%@include file="../includes/footer.jsp" %>
 	