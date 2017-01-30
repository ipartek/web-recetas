<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>

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
      <a name="#coches"></a>
      	<%@include file="../../includes/Mensaje.jsp" %>
      
      
       
       <a href="vehiculo?op=3">CREAR VEHICULO NUEVO</a>
       
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
        <!-- ForEach recorre un array. Para poder hacerlo, inicializamos una variable (llamada v) que
        solo podremos utilizar en esta página. Para usar estas variables en el formulario, debemos
        de enviarlas al controlador y que este las recoja como atributos. Esto se define en items="${vehiculo}"
        ya que el nombre que le indicamos (vehiculo) es un Array.
        
        Para sacar los valores concretos del Array, utilizamos la nueva variable definida en el foreach (v)
        y llamamos a los atributos del array list. Estos atributos estarán definidiso en Vehiculo.java
        
        
         -->
        	<c:forEach var="v" items="${vehiculo}">        
	            <tr>
	                <td><a href="vehiculo?op=2&id=${v.id}">${v.modelo}</a></td>
	                <td>${v.plazas}</td> 
	                <td>${v.dimensiones}</td>
	                <td>${v.potencia}</td>        
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
       
       
       
       <p>Total Vehiculos: ${fn:length(vehiculo)}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>