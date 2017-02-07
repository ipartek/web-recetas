<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Listar Recetas</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      	<a href="receta?op=3">Crear Receta</a>
		<table class="display data-table-mio" >
        <thead>
            <tr>
                <th>id</th>
                <th>titulo</th>
                <th>imagen</th>
                <th>tiempo</th>
                <th>comensales</th>
                <th>dificultad</th>
                <th>descripcion</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${recetas}" var="r" >
            <tr>
                <td><a href="receta?op=2&id=${r.id}">${r.id}</a></td>
                <td>${r.titulo}</td>
                <td>${r.imagen}</td>
                <td>${r.tiempo}</td>
                <td>${r.comensales}</td>
                <td>${r.dificultad}</td>
                <td>${r.descripcion}</td>
                <td><a href="receta?op=5&id=${r.id}">Eliminar</a></td>
            </tr>
        </c:forEach>
        </tbody>
      </table>

    </div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>