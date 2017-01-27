<%@include file="../../includes/header.jsp" %>
<div class="container">
                <div class="row">
					<h1></h1>
					<form action="vehiculo" method="post">
					
					<input type="text" name="modelo" required="required" value="${vehiculos.modelo}">
					<input type="text" name="plazas" required="required" value="${vehiculos.plazas}">
					<input type="text" name="dimensiones" required="required" value="${vehiculos.dimensiones}">
					<input type="text" name="potencia" required="required" value="${vehiculos.potencia}">
					
					
					<c:if test="${op==2}">
						<input type="hidden" name="id" required="required" value="${vehiculos.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Modificar Coche">
						
					</c:if>
					<c:if test="${op==3}">
						<input type="hidden" name="id" required="required" value="${vehiculos.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Crear Coche">
						
					</c:if>
					</form>
				</div>
</div>
<%@include file="../../includes/footer.jsp" %>