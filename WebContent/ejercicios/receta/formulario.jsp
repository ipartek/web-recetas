<%@page import="com.ipartek.formacion.recetas.controller.RecetaCRUDController"%>

<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
    <section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>Formulario Receta</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 

        <div class="container">
            <div class="row">  

             	<c:choose>
               		<c:when test="${receta.id == -1}">
	               		<c:set var="isNew" value="true"></c:set>
	               	</c:when>
	               	<c:otherwise>
	               		<c:set var="isNew" value="false"></c:set>
	               	</c:otherwise>
	            </c:choose>  
	        
	        
<!-- 	        	<h2>¿ES nuevo?: ${isNew}</h2>  -->
 				
				<%@include file="../../includes/mensaje.jsp"%>
 				    
 				<div class="vinculos">
					<a href="receta">Volver</a>
				</div>
						
               	<form class="anchuraDivFormulario" action="receta" method="post">
               	
               		<input type="hidden" name="op" value="<%=RecetaCRUDController.OP_GUARDAR%>">
               		
               		<input type="hidden" name="id" value="${receta.id}" readonly="readonly">
               	
					<div class="form-group">
	               		<label for="titulo">Titulo: </label>
    	           		<input class="form-control" id="titulo" size="15" type="text" name="titulo" placeholder="Escribre el nombre de la receta" value="${receta.titulo}" required pattern=".{2,255}" autofocus>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="imagen">Imagen: </label>
    	           		<input class="form-control" id="imagen" size="15" type="text" name="imagen" placeholder="Escribre la url de la imagen" value="${receta.imagen}" required>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="tiempo">Tiempo: </label>
    	           		<input class="form-control" id="tiempo" size="15" type="number" name="tiempo" placeholder="Escribre el tiempo de la receta" value="${receta.tiempo}" required>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="comensales">Comensales: </label>
    	           		<input class="form-control" id="comensales" size="15" type="number" name="comensales" placeholder="Escribre el n1 de comensales" value="${receta.comensales}" required>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="dificultad">Dificultad: </label>
    	           		<input class="form-control" id="dificultad" size="15" type="text" name="dificultad" placeholder="Escribre la dificultad de la receta" value="${receta.dificultad}" required>
               		</div>
               		
               		<br>
               		
               		<div class="form-group">
	               		<label for="descripcion">Descripcion: </label>
    	           		<textarea rows="15" cols="100" class="form-control" id="descripcion" name="descripcion" placeholder="Escribre la descripcion de la receta" required>${receta.descripcion}</textarea>
               		</div>
               		
               		<br>
               		
              		<c:choose>
	               		<c:when test="${isNew}">
		               			<input class="btn btn-default" type="submit" value="CREAR RECETA" >
		               	</c:when>
		               	<c:otherwise>
		               			<input class="btn btn-default" type="submit" value="MODIFICAR" >
		               	</c:otherwise>
	           		 </c:choose>  
               	</form>           
               	
               	<c:if test="${!isNew}">
               	
               		 	<form class="anchuraDivFormulario" action="receta" method="post">               	
			               		<input type="hidden" name="op" value="4">	<!-- OP=4 -> eliminar -->		               		
			               		<input type="hidden" name="id" value="${receta.id}" readonly="readonly">
			               		<br>
			               		<input id="btnEliminar" class="btn btn-default" type="submit" value="ELIMINAR">
               			</form>    
               	
               	
               	</c:if>
               	
               	
               	            	
            </div>
    	</div>
    </section>	       
                

<%@include file="../../includes/footer.jsp" %>