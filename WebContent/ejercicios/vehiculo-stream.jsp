<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>OutputStream</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
     <table class="display data-table-mio" >
        <thead>
            <tr>
                <th>Modelo</th>
                <th>Plazas</th>
                <th>Dimensiones</th>
                <th>Potencia</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehiculos}" var="v" >
            <tr>
                <td>${v.modelo}</td>
                <td>${v.plazas}</td>
                <td>${v.dimensiones}</td>
                <td>${v.potencia}</td>
            </tr>
        </c:forEach>
        </tbody>
      </table>

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>