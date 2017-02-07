<%@page import="com.ipartek.formacion.recetas.controller.RecetasCRUDController"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<body id="" class="index">
    
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

        
      
      <a href="recetas?op=3">Crear Nueva</a>
      
      <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Titulo</th>
                <th>Dificultad</th>
                <th>Comensales</th>
                <th>Descripcion</th>
                <th>Tiempo</th>
                <th>Imagen</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="r" items="${recetas}">
            <tr>
            	<td>${r.id}</td>
                <td><a href="recetas?op=<%=RecetasCRUDController.OP_VER_DETALLE %>&id=${r.id}">${r.titulo}</td>            
            	<td>${r.dificultad}</td>
            	<td>${r.comensales}</td>
            	<td>${r.descripcion}</td>
            	<td>${r.tiempo}</td>
            	<td><a href="${r.imagen}"><img style="width:50px;" src="${r.imagen}"></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        
    <c:set var="user" value="${sessionScope.usuario}"/>
        <c:if test="${ user != null}">
        <p>Usuario: ${sessionScope.usuario.nombre}</p>
        
        </c:if>
        <p>Total Recetas: ${fn:length(recetas)}</p>
        <c:set var="now" value="<%=new java.util.Date() %>" />
        <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p> 
    
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
                
 <%@include file="../../includes/footer.jsp" %>