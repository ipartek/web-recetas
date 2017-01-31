<%@include file="../includes/header.jsp" %>
 <%@include file="../includes/nav.jsp" %>
 
 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1> Crear Fichero de Texto</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
 
 <div class="container">
 	<div class="row">
 	
 	<p>Ejercicio para crear un fichero de texto, usaremos un <code>Stream</code> del tipo <code>FileWriter</code>  </p>
 	<p>Acordaros de usar un <code>Buffer</code>del tipo<code>BufferedWriter</code> para mejorar la escritura.</p>
 	<p>Capitulo 10, pag. 185.</p><a href="ejercicios/leer-fichero.jsp">Leer ficheros</a>
 	
 	<%@include file="../includes/mensaje.jsp" %>
 	
 	<hr>
 	
 	<form action="files" method="post">
 	
 	<label for="nombre">Nombre del fichero:</label>
 	<input type="text" name="nombre" required autofocus placeholder="Nombre ficher sin extension"> 	
 	<br>
 	<label for="contenido"> Texto a guardar:</label>
 	<br>
 	<textarea name="contenido" rows="10" cols="100"> </textarea>
 	<br>
 	<input type="submit" value="Crear">
 	</form>
 	
    
 	</div>
 
 </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <%@include file="../includes/footer.jsp" %>