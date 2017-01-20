<!DOCTYPE html>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@page import="java.util.ArrayList"%>
<html lang="es">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Primer objeto Controlador</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="../css/freelancer.min.css" rel="stylesheet">

<!-- Custom -->
<link href="../css/custom.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="mi-primer-controlador" class="index">

	<section>
		<div class="Container">
			<div class="row">
				<h1>Mi primer Controlador</h1>
				<p>
					Los controladores en java son <b>Servlets</b>
				</p>
				<p>
					Un <b>controlador</b> se encarga de recibir peticiones o <b>request</b>
					del cliente y darle una <b>response</b>
				</p>
				<p>Puede recibir y retornar parametros</p>
				<p>
					Puede aceptar peticiones de tipo <b>GET</b> o <b>POST</b>
				</p>
				<p>
					Mapping del servlet:<b>/saludo</b>
				</p>
				<h2>Peticion GET</h2>
				<p>
					Vamos a enviar tres  parametros  para que el servlet nos retorne un
					parametro con nuestro nombre y apellidos
				</p>
				<p>
					Las peticiones <b>GET</b> se hacen mediante <b>Enlaces</b>
				</p>
				<p>
					Pulsa <b>Enlaces</b> parta realizar peticion GET <a href="../saludo">/saludo?nombre=pepe&ape1=gorriti&ap2=Barrenagoitiasola</a>
				</p>
				<p>
					Las peticiones <b>POST</b> se hacen mediante <b>Formularios</b>
				</p>
			</div>

		</div>
	</section>



	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="../js/jqBootstrapValidation.js"></script>
	<script src="../js/contact_me.js"></script>

	<!-- Theme JavaScript -->
	<script src="../js/freelancer.min.js"></script>

</body>

</html>
