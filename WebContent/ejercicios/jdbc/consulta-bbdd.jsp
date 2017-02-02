<%@include file="../../includes/header.jsp" %>
<div class="container">
      <div class="row">
<br><br><br><br><br><br><br><br>
<%@include file="../../includes/Mensaje.jsp" %>
Ejercicio para realizar a pelo una consulta en BBDD:
<code>SELECT * FROM `vehiculo`</code> <br>
<h2>Listado de Vehículos</h2>
${vehiculos}
</div>
</div>

<%@include file="../../includes/footer.jsp" %>