<%@page import="com.ipartek.formacion.recetas.listener.ListenerContadorUsuarios"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Usuarios Logeados en Sesion</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">     
     	<p>Empleamos un Listener de Session para gestionar los usuarios logeados.</p>

		<p><a target="_blank" href="javadoc/index.html">Ver Documentacion</a></p>
		<table class="display data-table-mio" >
        <thead>
            <tr>
                <th>id</th>
                <th>titulo</th>
                <th>password</th>
                <th>email</th>
                <th>imagen</th>
                <th>git user name</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="<%=ListenerContadorUsuarios.usuariosLogeados%>" var="ul" >
            <tr>
                <td>${ul.id}</td>
                <td>${ul.nombre}</td>
                <td>${ul.password}</td>
                <td>${ul.email}</td>
                <td><img src="${ul.imagen}" alt="foto del usuario"></img></td>
                <td>${ul.gitUserName}</td>

            </tr>
        </c:forEach>
        </tbody>
      </table>

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>