<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
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
        
       <ol> 
       <c:forEach var="v" items="${vehiculos}">
       		<li>${v.modelo}</li>
       </c:forEach>
       </ol> 
       
       
       <table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009/01/12</td>
                <td>$86,000</td>
            </tr>
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
       
       
       
       <p>Total Vehiculos: ${fn:length(vehiculos)}</p>
       
       <c:set var="now" value="<%=new java.util.Date()%>" />       
       <p>Fecha: <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" /></p> 
        
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>
