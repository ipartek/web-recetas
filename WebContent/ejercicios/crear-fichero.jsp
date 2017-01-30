<%@include file="../includes/header.jsp" %>

<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Crear fichero de texto</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
      <p>Ejercicio para crear un fichero de texto. Usaremos <code>Stream</code> del tipo
      <code>FileWriter</code></p>
      <p>Acordaros de usar un <code>Buffer</code> del tipo <code>BufferedWriter</code> para mejorar la escritura</p>
      	<p>Todo esto lo podemos encontrar en el capítulo 10, página 158.</p>
      	<hr>
      	<%@include file="../includes/Mensaje.jsp" %>
      	<hr>
      	<form action="files" method="post">
      	<label for="nombre">Nombre fichero:</label>
      	<input type="text" name="nombre" required autofocus placeholder="Nombre fichero sin extensión">
      	<br>
      	<label for="contenido">Texto a guardar: </label>
      	<br>
      	<textarea rows="10" cols="100" name="contenido"></textarea>
      	<br>
      	<input type="submit" value="crear">
      	
      	</form>
      
      
      
      
      
      
      
      
      
      
      
      </div>
     </div>











<%@include file="../includes/footer.jsp" %>