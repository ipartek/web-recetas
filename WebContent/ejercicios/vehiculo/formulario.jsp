
<%@page import="com.ipartek.formacion.recetas.controller.VehiculoCRUDController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<!-- Todo para voosotros, 
pero que CREE, MODIFIQUE y ELIMINE


ES NUEVO? -->



${vehiculo}

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Crear Vehiculo nuevo</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
 	
 	<div class="container">
 		<div class="row">
 			<form action="vehiculo" class="anchuraDivFormulario"  method="POST">
 						
				<div class="form-group">
					<label for="modelo">Modelo</label> <input type="text"
						class="form-control" size="15" name="modelo" id="modelo" value="${vehiculo.modelo}"
						placeholder="Introduzca el modelo" required pattern=".{2-255}">
				</div>
				
				<div class="form-group">
					<label for="plazas">Plazas</label> <input type="text"
						class="form-control" size="15" name="plazas" id="plazas" value="${vehiculo.plazas}"
						placeholder="Introduzca el modelo" required pattern=".{2-255}">
				</div>
				
				<div class="form-group">
					<label for="potencia">Potencia</label> <input type="text"
						class="form-control" size="15" name="potencia" id="potencia" value="${vehiculo.potencia}"
						placeholder="Introduzca el modelo" required pattern=".{2-255}">
				</div>
								
				<input type="hidden" name="id"  value="${vehiculo.id}"/>
				<input type="hidden" name="op"  value="4"/>
				
				<c:if test="${vehiculo.id==-1}">
					<input type="submit" class="btn btn-primary" value="Crear"/>
				</c:if>			
				
				<c:if test="${vehiculo.id!=-1}">
					<input type="submit" class="btn btn-primary" value="Modificar"/>
				</c:if>			
				
			</form>
 		
 		
 			<!-- Formulario para Eliminar -->
 			
 				<c:if test="${vehiculo.id!=-1}">
 					<form action="vehiculo" class="anchuraDivFormulario"  method="POST">
 						<input type="hidden" name="id"  value="${vehiculo.id}"/>
						<input type="hidden" name="op"  value="<%=VehiculoCRUDController.OP_ELIMINAR%>"/>
						<input type="submit" class="btn btn-primary" value="Eliminar"/>
					</form>	
				</c:if>	
 		
 		</div>
 	</div>



<%@include file="../../includes/footer.jsp" %>