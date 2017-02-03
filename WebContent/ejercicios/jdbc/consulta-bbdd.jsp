<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Listado Vehiculos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<%@include file="../../includes/mensaje.jsp" %>

		<p>Ejercicio para realizar a pelo una consulta en bbdd</p>
		<code>SELECT * FROM `vehiculo`</code>
		<br><br>
		
		
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
		<br>
		
		<p>Ademas de poder insersar nuevos mediante este formulario</p>
		<code>INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, '?', '1', '1500');</code>
		<br><br>
		
		<p>Cuando Creemos <code>PreparedStatement</code> reemplazaremos el <b>?</b> por el campo del formulario</p>
		<br>
		
		<form action="jdbc" method="post">

   			<label for="inputModelo">Modelo</label>
				<input type="text" id="inputModelo" name="modelo" required="required">
		
			<input type="submit" value="Crear Coche">

		</form>
		
    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>