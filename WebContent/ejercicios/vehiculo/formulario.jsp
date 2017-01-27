<%@include file="../../includes/header.jsp" %>
 <%@include file="../../includes/nav.jsp" %>
  
 
 <br><br><br><br><br><br><br>
<div class="container">
                <div class="row">
                <%@include file="../../includes/mensaje.jsp" %>
					<form class="form-horizontal" action="vehiculo" method="post">
						<div class="form-group">
							<label for="inputModelo" class="col-sm-2 control-label">Modelo</label>
						 		<div class="col-sm-10">
									<input type="text" name="modelo" required="required" value="${vehiculos.modelo}">
								 </div>
						</div>
						<div class="form-group">
							<label for="inputPlazas" class="col-sm-2 control-label">Plazas</label>
								 <div class="col-sm-10">
									<input type="number" name="plazas" required="required" value="${vehiculos.plazas}">
		                         </div>
						</div>
						<div class="form-group">
							<label for="inputDimensiones" class="col-sm-2 control-label">Dimensiones</label>
						 		<div class="col-sm-10">
									<input type="number" name="dimensiones" required="required" value="${vehiculos.dimensiones}">
								</div>
						</div>
						<div class="form-group">
							<label for="inputPotencia" class="col-sm-2 control-label">Potencia</label>
						 		<div class="col-sm-10">
									<input type="number" name="potencia" required="required" value="${vehiculos.potencia}">
								</div>
						</div>
						<div class="form-group">
   						 	<div class="col-sm-offset-2 col-sm-10">
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
							</div>
					</div>
				</form>
			 </div>
</div>
<%@include file="../../includes/footer.jsp" %>