<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
<body id="" class="index">
    
    <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Formulario recetas</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
 
<%@include file="../../includes/mensaje.jsp" %>

<c:set var="identificador" scope="request" value="${receta.id}"/>
<c:if test="${ identificador > 0}">
	 <form action="recetas" method="post">
      <label for ="titulo">Titulo:</label>
      <input type="text" name="nombre" id="nombre" value="${receta.titulo}" pattern=".{2,255}">
      <br>
      
      <label for ="Dificultad">Dificultad:</label>
      <input type="text" name="dificultad" id="dificultad" value="${receta.dificultad}" pattern=".{2,255}">
      <br>
      
      <label for ="Comensal">Comensales:</label>
      <input type="number" name="comensales" id="comensales" value="${receta.comensales}">
      <br>
      
      <label for ="Descrip">Descripcion:</label>
      <input type="text" name="descripcion" id="descripcion" value="${receta.descripcion}" pattern=".{2,255}">
      <br>
      
      
      <label for ="tiempo">Tiempo:</label>
      <input type="number" name="tiempo" id="tiempo" value="${receta.tiempo}">
      <br>
      
      <label for ="img">Imagen:</label>
      <input type="text" name="imagen" id="imagen" value="${receta.imagen}" pattern=".{2,255}">
      <br>

      <input type="hidden" name= "op" value="4">  
      <input type="hidden" name= "id" value="${receta.id}">        		
      <input type="submit" value="Modificar">

	</form>
<form action="recetas" method="post">
<input type="hidden" name= "op" value="5">
<input type="hidden" name= "id" value="${receta.id}">
      <input type="submit" value="Eliminar">
</form>
</c:if>

<c:if test="${ identificador < 0}">
	  <form action="recetas" method="post">
      <label for ="titulo">Titulo:</label>
      <input type="text" name="nombre" id="nombre" placeholder="Titulo aqui" pattern=".{2,255}">
      <br>
      
      <label for ="Dificultad">Dificultad:</label>
      <input type="text" name="dificultad" id="dificultad"  pattern=".{2,255}">
      <br>
      
      <label for ="Comensal">Comensales:</label>
      <input type="number" name="comensales" id="comensales" >
      <br>
      
      <label for ="Descrip">Descripcion:</label>
      <input type="text" name="descripcion" id="descripcion"  pattern=".{2,255}">
      <br>
      
      
      <label for ="tiempo">Tiempo:</label>
      <input type="number" name="tiempo" id="tiempo" >
      <br>
      
      <label for ="img">Imagen:</label>
      <input type="text" name="imagen" id="imagen"  pattern=".{2,255}">
      <br>         		
      
      <input type="hidden" name= "op" value="4">    
      <input type="hidden" name= "id" value="${receta.id}">     		
      <input type="submit" value="Crear">
</form>
</c:if>

<a href="recetas">VOLVER</a>
<%@include file="../../includes/footer.jsp" %>