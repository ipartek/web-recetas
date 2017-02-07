<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<br><br><br><br><br><br>
<div class="container">
                <div class="row">
                	<%@include file="../../includes/mensaje.jsp" %>
					<h1></h1>
					<form action="receta" method="post">
					<div class="form-group">
   						<label for="inputId">id</label>
							<input type="text" id="inputId"name="id" readonly="readonly" value="${recetas.id}">
						
							
   						<label for="inputTitulo">titulo</label>
							<input type="text" id="inputTitulo" name="titulo" required="required" value="${recetas.titulo}">
						
						<label for="inputImagen">imagen</label>
							<input type="text" id="inputImagen" name="imagen" required="required" value="${recetas.imagen}">
						
						<label for="inputTiempo">tiempo</label>
							<input type="text" id="inputTiempo" name="tiempo" required="required" value="${recetas.tiempo}">
						
						<label for="inputComensales">comensales</label>
							<input type="text" id="inputComensales" name="comensales" required="required" value="${recetas.comensales}">
						
						<label for="inputDificultad">dificultad</label>
							<input type="text" id="inputDificultad" name="dificultad" required="required" value="${recetas.dificultad}">
						
						<label for="inputDescripcion">descripcion</label>
							<input type="text" id="inputDescripcion" name="descripcion" required="required" value="${recetas.descripcion}">
						
						
						<input type="hidden" name="op" value="4">
						<c:if test="${op==2}">
							<input type="submit" value="Modificar Receta">
						</c:if>
						<c:if test="${op==3}">
							<input type="submit" value="Crear Receta">
						</c:if>
					</div>
					</form>
				</div>
</div>
<%@include file="../../includes/footer.jsp" %>