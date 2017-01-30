<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@include file="../../includes/header.jsp" %>

<br><br><br><br><br><br><h1>Formulario que crea, edita y elimina un coche</h1>
Todo para voosotros, 
pero que CREE, MODIFIQUE y ELIMINE
<!--  
           <br><a href="vehiculo?op=4"><button value="CREAR_COCHE">CREAR COCHE</button></a>
           <br><a href="vehiculo?op=6"><button value="MODIFICAR_COCHE">MODIFICAR COCHE</button></a>
           <br><a href="vehiculo?op=5"><button value="ELIMINAR_COCHE">ELIMINAR COCHE</button></a>

-->





<c:choose>
    <c:when test="${vehiculo.id == -1}">
      <h1>ES NUEVO? SI</h1>
      <br><br> <!-- label for para relacionar el label con el input -->
      <form action="vehiculo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el método por el que lo enviaremos es post. -->
      		<label>Modelo:</label>
        	<input type="text" name="modelo" id="modelo" value="${vehiculo.modelo}" placeholder="Escriba el modelo del coche" PATTERN=".{2,255}" required> <!-- Para mapear es importante el name -->
        <br>
        	<label>Plazas:</label>
			<input type="number" min="1" step="1" name="plazas" id="plazas" value="${vehiculo.plazas}" placeholder="Escriba las plazas del coche" required>
        <br>
        	<label>Dimensiones:</label>
			<input type="number" name="potencia" id="potencia" value="${vehiculo.dimensiones}" placeholder="Escriba la potencia del coche" required>
		<br>
			<label>Potencia:</label>
			<input type="number" name="potencia" id="potencia" value="${vehiculo.potencia}" placeholder="Escriba la potencia del coche" required>
		<br>
			<label for="id">ID</label>
			<input name="id" value="${vehiculo.id}" readonly>
        <br>
        <!-- Para poder enviar la información al controlador, requerimos de "algo" que
        nos lleve la información. Para hacerlo, creamos un input oculto (tipo hidden) con
        el name OP, que es el name que le hemos dado al switch (y por lo tanto, el que
        usará el input). En el value, le indicamos a donde debe dirigirse para realizar
        la operación, mediante el uso de la constante que hemos creado. En este caso, al
        crearse un coche, lo metemos todo en la op "crear coche" ya que es el case del
        switch que sirve para esta función. -->
    <!--     <input type="hidden" name="op" value="<%=VehiculoCRUDController.OP_CREAR_COCHE%>"> --> 
        <a href="vehiculo?op=4"><input type="submit" value="CREAR COCHE"></a>
     </form>
     
    </c:when>
    <c:otherwise>
        <h1>ES NUEVO? NO</h1>
        <br><br>
        <form action="vehiculo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el método por el que lo enviaremos es post. -->
			<label>Modelo:</label> 
             <!-- Como el parámetro se recoge del CONTROLADOR Y NO DEL OBJETO DEL INDEX, debemos ver como hemos llamado al atributo
             en el controlador. Sin embargo, el nombre se define en el index.jsp y no en el controlador.
             Emn el index.jsp se define como atributo (y el controlador lo recoge como atributo) y cuando el controlador lo envia,
             se convierte en un parámetro en donde se recibe. -->
             <input type="text" name="modelo" id="modelo" value="${vehiculo.modelo}" placeholder="Escriba el modelo del coche" PATTERN=".{2,255}" required> <!-- Para mapear es importante el name -->
		<br>
            <label>Plazas:</label>
			<input type="number" min="1" step="1" name="plazas" id="plazas" value="${vehiculo.plazas}" placeholder="Escriba las plazas del coche" required>
		<br>
       		<label>Dimensiones:</label>
			<input type="number" name="potencia" id="potencia" value="${vehiculo.dimensiones}" placeholder="Escriba la potencia del coche" required>
		<br>
			<label>Potencia:</label>
			<input type="number" name="potencia" id="potencia" value="${vehiculo.potencia}" placeholder="Escriba la potencia del coche" required>
		<br>
		<a href="vehiculo?op=6&id=${v.id}"><input type="submit" value="MODIFICAR COCHE"></a>
		<br>
		<a href="vehiculo?op=5&id=${v.id}"><input type="submit" value="ELIMINAR COCHE"></a>
            </form>
        
        
    </c:otherwise>
</c:choose>

<br><br><a href="vehiculo">Volver a la tabla de coches</a></br>


<%@include file="../../includes/footer.jsp" %>