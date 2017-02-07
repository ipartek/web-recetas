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
									<input type="text" name="titulo" required="required" value="${recetas.titulo}">
									<input type="text" name="imagen" required="required" value="${recetas.imagen}">
									<input type="text" name="tiempo" required="required" value="${recetas.tiempo}">
									<input type="text" name="comensales" required="required" value="${recetas.comensales}">
									<input type="text" name="dificultad" required="required" value="${recetas.dificultad}">
									<input type="text" name="descripcion" required="required" value="${recetas.descripcion}">
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