<%@include file="../../includes/header.jsp" %>
 <%@include file="../../includes/nav.jsp" %>
  
<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Operaciones</h1>
               </div>
             </div>             
 		</div> 
 	</header>
 	
 	
<div class="container">
	<div class="row">
   	<%@include file="../../includes/mensaje.jsp" %>
		<form class="form-horizontal" action="receta" method="post">
		
		
			<div class="form-group">
				<label for="inputTitulo" class="col-sm-2 control-label">Titulo</label>
					<div class="col-sm-10">
						<input type="text" id="inputTitulo" name="titulo" required="required" value="${recetas.titulo}">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputImagen" class="col-sm-2 control-label">Imagen</label>
					<div class="col-sm-10">
						<input type="text" id="inputImagen" name="imagen" required="required" value="${recetas.imagen}">
					</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputTiempo" class="col-sm-2 control-label">Tiempo</label>
					<div class="col-sm-10">
						<input type="text" id="inputTiempo" name="tiempo" required="required" value="${recetas.tiempo}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputComensales" class="col-sm-2 control-label">Comensales</label>
					<div class="col-sm-10">
						<input type="text" id="inputComensales" name="comensales" required="required" value="${recetas.comensales}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputDificultad" class="col-sm-2 control-label">Dificultad</label>
					<div class="col-sm-10">
						<input type="text" id="inputDificultad" name="dificultad" required="required" value="${recetas.dificultad}">
					</div>
			</div>
			
			<div class="form-group">
				<label for="inputDescripcion" class="col-sm-2 control-label">Descripcion</label>
					<div class="col-sm-10">
						<input type="text" id="inputDescripcion" name="descripcion" required="required" value="${recetas.descripcion}">
					</div>			 
			</div>
						
			<div class="form-group">
   				<div class="col-sm-offset-2 col-sm-10">
					<c:if test="${op==2}">
						<input type="hidden" name="id" required="required" value="${recetas.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Modificar Receta">
					</c:if>
					<c:if test="${op==3}">
						<input type="hidden" name="id" required="required" value="${recetas.id}">
						<input type="hidden" name="op" value="4">
						<input type="submit" value="Crear Receta">
					</c:if>
				</div>
			</div>
		</form>
	</div>
</div>
<%@include file="../../includes/footer.jsp" %>