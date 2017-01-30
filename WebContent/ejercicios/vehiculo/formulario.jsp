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
 
<%@include file="../../includes/mensaje.jsp" %>

<c:set var="identificador" scope="request" value="${vehiculo.id}"/>
<c:if test="${ identificador > 0}">
	 <form action="vehiculo" method="post">
      <label for ="modelo">Modelo:</label>
      <input type="text" name="modeloCrear" id="modeloCrear" value="${vehiculo.modelo}" pattern=".{2,255}">
      <br>
               		
      <label for ="plazas">Plazas:</label>
      <input type="number" min="1" step="1" name="plazasCrear" id="plazas" value="${vehiculo.plazas}">
      <br>
              		
      <label for ="potencia">Potencia:</label>
      <input type="text" name="potenciaCrear" id="potencia" value="${vehiculo.potencia}">
      <br>
      
      <label for ="dimensiones">Dimensiones:</label>
      <input type="text" name="dimensionesCrear" id="dimensiones" value="${vehiculo.dimensiones}">
      <br>
      
      <input type="hidden" name= "op" value="4">  
      <input type="hidden" name= "id" value="${vehiculo.id}">        		
      <input type="submit" value="Modificar">

	</form>
<form action="vehiculo" method="post">
<input type="hidden" name= "op" value="5">
<input type="hidden" name= "id" value="${vehiculo.id}">
      <input type="submit" value="Eliminar">
</form>
</c:if>

<c:if test="${ identificador < 0}">
	  <form action="vehiculo" method="post">
      <label for ="modelo">Modelo:</label>
      <input type="text" name="modeloCrear" id="modelo" placeholder="Modelo" pattern=".{2,255}">
      <br>
               		
      <label for ="plazas">Plazas:</label>
      <input type="number" min="1" step="1" name="plazasCrear" id="plazas" value="1" required>
      <br>
              		
      <label for ="potencia">Potencia:</label>
      <input type="text" name="potenciaCrear" id="potencia" placeholder="0.0" required>
      <br>
      
      <label for ="dimensiones">Dimensiones:</label>
      <input type="text" name="dimensionesCrear" id="dimensiones" placeholder="0.0" required>
      <br>
      
      <input type="hidden" name= "op" value="4">    
      <input type="hidden" name= "id" value="${vehiculo.id}">     		
      <input type="submit" value="Crear">
</form>
</c:if>

<a href="vehiculo">VOLVER</a>
<%@include file="../../includes/footer.jsp" %>