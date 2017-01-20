<!DOCTYPE html>
<html lang="es">
<head>
<base href="/web-recetas/"> <!-- Con esta URL lo que hacemos es obligar a empezar a �escribir? la url a partir de nuestra indicaci�n. Se puede mirar en w3school etc. CUIDADO CON LAS / (barras) !!!!!!! -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Primer Ejemplo Controlador</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/freelancer.min.css" rel="stylesheet">
    
    <!-- Custom -->
    <link href="css/custom.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="" class="index">
    
    <section id="controllers">
    <h1>Primer ejercicio</h1>
    	<h1>Mi Primer Controlador</h1>
        <div class="container">
            <div class="row">
                	<p>Los <b>Controladores</b> en Java se llaman <b>Servlets</b></p>
                	<p>Un controlador se encarga de recibir <b>peticiones o Requests</b> del cliente y darle una <b>Response.</b></p>
            		<p>Puede recibir y retornar par&aacute;metros.</p>
            		<p> Puede aceptar peticiones del tipo <b>GET o POST</b>.</p>
            		</div>
            		<div class="row">
            		<h2>PETICI�N GET</h2>
            		<p>Vamos a enviar tres par&aacute;metros <u>nombre y apellidos</u> para que el <b>Servlet</b> nos retorne un saludo con nuestro nombre y nuestros apellidos.</p>
            		<p>Mapping del <b>Servlet: </b><u>Saludo</u></p>
            		<p>Las peticiones <b>GET</b> se hacen mediante enlaces, links o anclas.</p>
            		<p>Pulsa en el enlace para realizar la petici�n de tipo <b>GET</b>.</p>
            		<a href="saludo?nombre=Pepe&Ape1=Gorriti&Ape2=Barrenagotiasola">/saludo?nombre=Pepe&ape1=Gorriti&ape2=Barrenagotiasola</a>
            		<p class="anotaciones"><b>ANOTACIONES:</b><br>
            		La <b>?</b> es para a�adir una key en la URL. Los par�metros que se le pasan van seguidos de ello. Por ejemplo, en el enlace anterior, un par�metro es nombre y a continuaci�n, se muestra el valor del mismo. Para concatenar par�metros hay que usar los & y seguir exactamente la misma estructura.</b><br><br>
            		Hay que tener cuidado con las rutas y vigilarla antes. Mirar como el <code> a href="../saludo"</code> se transforma en <code>url/saludo</code><br><br>
            		Mirar los comentarios del controller <b>SaludoController.java</b>, ubicado en <b>web-recetas</b> dentro del <b>package </b><code>com.ipartek.formacion.recetas.controller</code><br><br>
            		Si ponemos en la URL en el <code>a href="../saludo?nombre=Pepe"</code> y hemos puesto en el controlador par�metros (mirar en <b>SaludoController.java</b> el c�digo <code>PrintWriter out = response.getWriter();</code> para comprender que est� pasando). <br><br>
            		El ejercicio se ha actualizado tambi�n para incluir los apellidos, pero sigue la misma estructura de lo explicado en las anteriores <b>Anotaciones</b> de este bloque.<br><br>
            		Importante mirar siempre la URL de abajo a la izda (en el navegador) para ver si la URL es correcta o no etc.<br>
            		Se quitan los <code>../</code> para que lo de abajo funcione.
            		</p>
            		
            		<h2>Respuesta GET</h2>
            		<%
            		if (request.getAttribute("nombre")!=null){
            			String nombre = (String) request.getAttribute("nombre");
            			out.print("Nombre: "+nombre);
            		}
            		%>
            		
            		<p class="anotaciones"><b>ANOTACIONES</b><br>
            		El c�digo java oculto en la respuesta es este: 
            		<code>if (request.getAttribute("nombre")!=null){
            			String nombre = (String) request.getAttribute("nombre");
            			out.print("Nombre: "+nombre);
            		}</code><br><br> 
            		Para entenderlo hay que mirar el c�digo en <b>SaludoController.java</b>. <b><u>SIEMPRE HAY QUE CASTEAR LOS </u></b>request.GetAttribute("atributo");
            		</p>
            		
            </div>
            <h2>ENVIO POST</h2>
            
            <form action="saludo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el m�todo por el que lo enviaremos es post. -->
            <input type="text" name="nombre2" placeholder="Escribe tu nombre"> <!-- Para mapear es importante el name -->
            <input type="submit" value="Enviar">
            </form>
             <h2 id="respuesta">RESPUESTA POST</h2>
            <%
            		if (request.getAttribute("nombre2")!=null){
            			String nombre = (String) request.getAttribute("nombre2");
            			out.print("Nombre: "+nombre);
            		}
            		%>
            <br><br>
<a href="../index.jsp#ejercicios">Volver</a>
    	</div>
    </section>	       




<!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="../js/jqBootstrapValidation.js"></script>
    <script src="../js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="../js/freelancer.min.js"></script>

</body>

</html>