<!DOCTYPE html>
<html lang="es">
<head>

	<base href="/web-recetas/">

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
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
    
    <section>
    	<h1>Mi Primer Controlador</h1>
        <div class="container">
            <div class="row">
               	<p>Los <b>Controladores</b> en Java son <b>Servlets</b>.</p>
               	<p>Un controlador se encarga de recibir <b>Request</b> del cliente y darle una<b>Response</b>.</p>
               	<p>Puede recibir y retornar parametros.</p>
               	<p>Puede aceptar peticiones de tipo <b>GET</b> o <b>POST</b>.</p>
               	
               	<p>Mapping del Servlet:<b>/saludo</b></p>
               	<h2>Petici�n GET</h2>
               	<p>Vamos a enviar tres parametros para que el Servlet nos retorne un saludo con nuestro nombre y apellidos.</p>
               	<p>Las peticiones GET se hacen mediante enlaces,links o anclas.</p>
               	<p>pulsa enlace para realizar petici�n GET <a href="saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola">/saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola</a></p>
               	<h2>Petici�n POST</h2>    
               	<form action="saludo" method="post">
               		<!-- Recordar que para mapear este campo input es importante el atributo name -->
               		<input type="text" name="nombre" placeholder="Escribe tu nombre">
               		<input type="text" name="ape1" placeholder="Escribe tu 1� Apellido">
  					<input type="text" name="ape2" placeholder="Escribe tu 2� Apellido">
               		<input type="submit" value="Enviar">
               	</form>            	
            </div>
    	</div>
    </section>	       
                
                
	<h2>Respuesta</h2>
	<%
		if (request.getAttribute("nombre") != null){
			String nombre = (String) request.getAttribute("nombre");
			out.print("Nombre: " + nombre);
			String ape1 = (String) request.getAttribute("ape1");
			out.print("1� Apellido: " + ape1);
			String ape2 = (String) request.getAttribute("ape2");
			out.print("2� Apellido: " + ape2);
		}
	%>
    
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/freelancer.min.js"></script>

</body>

</html>
