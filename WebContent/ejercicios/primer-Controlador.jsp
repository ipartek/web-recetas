<!DOCTYPE html>
<html lang="es">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Primer Ejemplo Controlador</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="../css/freelancer.min.css" rel="stylesheet">
    
    <!-- Custom -->
    <link href="../css/custom.css" rel="stylesheet">

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
            		<h2>PETICIÓN GET</h2>
            		<p>Vamos a enviar tres par&aacute;metros <u>nombre y apellidos</u> para que el <b>Servlet</b> nos retorne un saludo con nuestro nombre y nuestros apellidos.</p>
            		<p>Mapping del <b>Servlet: </b><u>Saludo</u></p>
            		<p>Las peticiones <b>GET</b> se hacen mediante enlaces, links o anclas.</p>
            		<p>Pulsa en el enlace para realizar la petición de tipo <b>GET</b>.</p>
            		<a href="#">/saludo?nombre=Pepe&ape1=Gorriti&ape2=Barrenagotiasola</a>
            		<p class="anotaciones"><b>ANOTACIONES:</b><br>La <b>?</b> es para añadir una key en la URL. Los parámetros que se le pasan van seguidos de ello. Por ejemplo, en el enlace anterior, un parámetro es nombre y a continuación, se muestra el valor del mismo. Para concatenar parámetros hay que usar los & y seguir exactamente la misma estructura.</p>
            		
            </div>
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