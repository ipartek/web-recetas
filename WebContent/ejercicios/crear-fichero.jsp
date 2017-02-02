<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

<body id="" class="index">
   
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
            	<br>
            	<p> Ejercicio para crear un fichero de texto, usaremos un <code>Stream</code> del tipo <code>FileWriter.</code> </p>
            	<p> Acordaros de usar un <code>Buffer</code> del tipo <code>BufferedWriter</code> para mejorar la escritura. </p>
            	<p> Capitulo 10, pag. 158. </p>
            	<hr>
            	<%@include file="../includes/mensaje.jsp" %>
            	<br>
            	<form action="files" method="post">
            		<label>Nombre fichero:</label>
            		<input type="text" name="nombre" required autofocus placeholder="Nombre fichero sin extension">
            		<br>
            		<textarea name="contenido" rows="10" cols="100"></textarea>  
            		<br>          	
            		<input type="submit" value="Crear">
            	
            	
            	</form>
            	<br>            	
            </div>
    	</div>

                
 <%@include file="../includes/footer.jsp" %>