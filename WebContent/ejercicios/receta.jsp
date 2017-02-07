<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Listar Recetas</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      
			<%@include file="../includes/mensaje.jsp" %>
			
		<table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
               
            </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${recetas}">
            <tr>
                <td>${r.id}</td>
                <td>${r.titulo}</td>
                
            </tr>
           </c:forEach>
       </tbody>
    </table>


    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>
