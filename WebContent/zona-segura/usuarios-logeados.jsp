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
			<p>Listado usuarios:</p>
			
			<%=ListenerContadorUsuarios.usuariosLogeados%>
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		