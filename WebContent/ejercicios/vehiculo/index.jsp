<%@page import="com.ipartek.formacion.recetas.controller.VehiculosCRUDController"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<body id="" class="index">
    
    <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>CRUD Vehiculo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>

        
      
      <a href="vehiculo?op=3">Crear Nuevo</a>
      
      <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
                
            </tr>
        </thead>
        <tbody>
         <c:forEach var="v" items="${vehiculos}">
            <tr>
                <td><a href="vehiculo?op=<%=VehiculosCRUDController.OP_VER_DETALLE %>&id=${v.id}">${v.modelo}</td>
                <td>${v.plazas}</td>
                <td>${v.dimensiones}</td>
                <td>${v.potencia}</td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
        
    <c:set var="user" value="${sessionScope.usuario}"/>
        <c:if test="${ user != null}">
        <p>Usuario: ${sessionScope.usuario.nombre}</p>`
        
        </c:if>
        <p>Total Vehiculos: ${fn:length(vehiculos)}</p>
        <c:set var="now" value="<%=new java.util.Date() %>" />
        <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}"/></p> 
    
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->
                
 <%@include file="../../includes/footer.jsp" %>