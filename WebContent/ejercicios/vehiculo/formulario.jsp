<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<br><br><br><br><br><br>
<div class="container">
                <div class="row">
                	<%@include file="../../includes/mensaje.jsp" %>
					<h1></h1>
					<form action="vehiculo" method="post">
					<div class="form-group">
   						<label for="inputModelo">Modelo</label>
							<input type="text" id="inputModelo" name="modelo" required="required" value="${vehiculos.modelo}">
						<label for="inputPlazas">Plazas</label>
							<input type="number" id="inputPlazas" name="plazas" required="required" value="${vehiculos.plazas}">
						<label for="inputDimensiones">Dimensiones</label>
							<input type="number" id="inputDimensiones" name="dimensiones" required="required" value="${vehiculos.dimensiones}">
						<label for="inputPotencia">Potencia</label>
							<input type="number" id="inputPotencia" name="potencia" required="required" value="${vehiculos.potencia}">
					
						<input type="hidden" name="id" required="required" value="${vehiculos.id}">
						<input type="hidden" name="op" value="4">
					
						<c:if test="${op==2}">
							<input type="submit" value="Modificar Coche">
						</c:if>
						<c:if test="${op==3}">
							<input type="submit" value="Crear Coche">
						</c:if>
					</div>
					</form>
				</div>
</div>
<%@include file="../../includes/footer.jsp" %>