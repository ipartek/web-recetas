<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<body id="" class="index">
    
    <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Formulario vehiculo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
 	
 <%
 int i = Integer.parseInt(request.getParameter("op"));
 
 %>
<c:set var="oper" value="${i}"/>
        <c:if test="${ oper == 3}">
<form action="vehiculo" method="post">
      <label for ="modelo">Modelo:</label>
      <input type="text" name="modelo" id="modelo" placeholder="oper" required pattern=".{2,255}">
      <br>
               		
      <label for ="plazas">Plazas:</label>
      <input type="number" min="1" step="1" name="plazas" id="plazas" value="1" required>
      <br>
              		
      <label for ="potencia">Potencia:</label>
      <input type="number" min= "0" name="potencia" id="potencia" placeholder="0 cvv" required>
      <br>
               		
      <input type="submit" value="Crear">
</form>
</c:if>
${vehiculo}
</body>
<%@include file="../../includes/footer.jsp" %>