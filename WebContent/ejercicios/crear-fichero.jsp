<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
    
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Crear Fichero Texto</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
      		<p>Ejericio para crear un fichero de texto, usaremos un <code>Stream</code> del tipo <code>FileWriter</code>.</p>
      		<p>Acordaros de usar un <code>Buffer</code> del tipo<code>BufferedWriter</code> para mejorar la escritura.</p>
      		<p>Capitulo 10, pag. 158.</p>
      		<hr>
      		<%@include file="../includes/mensaje.jsp" %>
      		
      		<form action="files" method="post">
      			
      			<label for="nombre">Nombre fichero:</label>
      			<input type="text" name="nombre" required autofocus placeholder="Nombre fichero Sin extension">
      			<br>      			
      			<textarea name="contenido" rows="10" cols="100"></textarea>
      			<br>
      			<input type="submit" value="crear">
      		</form>
  
	    </div> 
	    <!--  <div class="row"> -->
	</div>    
	<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>