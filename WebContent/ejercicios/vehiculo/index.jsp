<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1> CRUD Vehiculo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
	<%@include file="../../includes/mensaje.jsp" %>
        
        
        <ol>
        <c:forEach var="v" items="${vehiculos}">
        	<li>${v.modelo}</li>
		</c:forEach>
		</ol>
	
		<c:set var="conectado" scope="session" value="${sessionScope.usuario.nombre}"/>
		<c:out value="Usuario: ${conectado}"></c:out>
		<c:if test="${sessionScope.usuario==null}">
		<c:out value="No conectado"></c:out>
		</c:if>
		
		
		
		
		<p>Total Vehiculos:${fn:length(vehiculos)}</p>
		
		<c:set var="now" value="<%=new java.util.Date()%>"/>
		<p>Fecha:<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p>
</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->






































<%@include file="../../includes/footer.jsp" %>