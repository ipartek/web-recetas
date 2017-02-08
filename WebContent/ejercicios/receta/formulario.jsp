<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<br><br><br><br><br><br>
<div class="container">
                <div class="row">
                	<%@include file="../../includes/mensaje.jsp" %>
					<h1></h1>
					<form class="form-horizontal" action="receta" method="post">
					
					<div class="form-group">
   						<label for="inputId" class="col-sm-2 control-label">id</label>
   							<div class="col-sm-10">
								<input type="text" id="inputId"name="id" readonly="readonly" value="${recetas.id}">						
							</div>
					</div>
					<div class="form-group">
   						<label for="inputTitulo" class="col-sm-2 control-label">titulo</label>
   							<div class="col-sm-10">
								<input type="text" id="inputTitulo" name="titulo" required="required" value="${recetas.titulo}">
							</div>
					</div>
					<div class="form-group">
						<label for="inputImagen" class="col-sm-2 control-label">imagen</label>
							<div class="col-sm-10">
								<input type="text" id="inputImagen" name="imagen" required="required" value="${recetas.imagen}">
							</div>
					</div>					
					<div class="form-group">
						<label for="inputTiempo" class="col-sm-2 control-label">tiempo</label>
							<div class="col-sm-10">
								<input type="text" id="inputTiempo" name="tiempo" required="required" value="${recetas.tiempo}">
							</div>
					</div>					
					<div class="form-group">
						<label for="inputComensales" class="col-sm-2 control-label">comensales</label>
							<div class="col-sm-10">
								<input type="text" id="inputComensales" name="comensales" required="required" value="${recetas.comensales}">
							</div>
					</div>					
					<div class="form-group">
						<label for="inputDificultad" class="col-sm-2 control-label">dificultad</label>
							<div class="col-sm-10">
								<input type="text" id="inputDificultad" name="dificultad" required="required" value="${recetas.dificultad}">
							</div>
					</div>					
					<div class="form-group">
						<label for="inputDescripcion" class="col-sm-2 control-label">descripcion</label>
							<div class="col-sm-10">
								<input type="text" id="inputDescripcion" name="descripcion" required="required" value="${recetas.descripcion}">					
							</div>
					</div>						
					
					<div class="form-group">
						<div class = "col-sm-offset-2 col-sm-10">
						<input type="hidden" name="op" value="4">
						<c:if test="${op==2}">
							<input type="submit" value="Modificar Receta">
						</c:if>
						<c:if test="${op==3}">
							<input type="submit" value="Crear Receta">
						</c:if>
						</div>
					</div>
					</form>
				</div>
</div>
<%@include file="../../includes/footer.jsp" %>