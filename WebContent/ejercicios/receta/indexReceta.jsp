<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>CRUD Receta</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>
        
       
       <a href="receta?op=3">Crear Nueva</a>
       
       <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                           
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
            <c:set var="user" scope="session" value="${sessionScope.usuario}"></c:set>       
       <c:choose>
       		<c:when test="${user==null}">
       			<p>Usuario No Conectado</p>			
       		</c:when>
       		<c:when test="${user!=null}">
       			<p>Usuario: ${user.nombre}</p>
       		</c:when>
       </c:choose>
       
       
       
       <p>Total Recetas: ${fn:length(recetas)}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
       
  
<%@include file="../../includes/footer.jsp" %>
