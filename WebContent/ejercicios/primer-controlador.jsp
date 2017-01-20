<!DOCTYPE html>
<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@page import="java.util.ArrayList"%>
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

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">Web Recetas</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="menu-del-dia.jsp">Menu del Dia</a>
                    </li>
                    <li class="page-scroll">
                        <a href="index.jsp">Inicio</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

   
    <section id="portfolio">
        <div class="container">
            <div class="row"></br></br>
            <h1>Primer Ejemplo Controlador</h1></br>
               <p>Los <b>Controladores</b> en Java son <b>Servlets.</b></p>
               <p>Un controlador se encarga de recibir <b>Request</b> del cliente y <b>Reponse</b>.</p>
               <p>Puede recibir y retornar parametros</p>
               <p>Puede aceptar peticiones de tipo <b>GET o POST</b>.</p>
               
               <p>Mapping del servlet:<b>/saludo</b></p></br></br>
               
               <h2>Petici�n Get</h2></br>
               <p>Vamos a enviar tres parametros para que el servlet nos retorne un saludo con nuestro nombre y apellidos</p>
               <p>Las peticiones Get se hacen mediante enlaces, links o anclas.</p>
               <p>Pulsa enlace para realizar petici�n GET <a href="saludo?nombre=Pepe&ape1=Gorriti&ape2=Barrenagoitiasola">/saludo?nombre=Pepe&ape1=Gorriti&ape2=Barrenagoitiasola</a>.</p></br>
               <p>El servidor responde:</p>
               <% 
               		if( request.getAttribute("nombre")!= null){
               			String nombre = (String)request.getAttribute("nombre");
               			String apellido1 = (String)request.getAttribute("ape1");
               			String apellido2 = (String)request.getAttribute("ape2");
               			out.print("<p><b>" + nombre + " " + apellido1 + " " + apellido2 + "</b></p>");
               		}
               
               %>
               </br></br>
               <h2>Petici�n Post</h2></br>
               <p>Vamos a enviar tres parametros para que el servlet nos retorne un saludo con nuestro nombre y apellidos.</p>
               <p>Las peticiones Get se hacen mediante formularios.</p>
               <form action="saludo" method="post">
               		<label>Nombre: </label></br>
					<input type="text" name="nombre" placeholder="Nombre" /></br></br>
					<label>Primer Apellido:</label></br>
					<input type="text" name="ape1" placeholder="Primer Apellido" /></br></br>
					<label>Segundo Apellido</label></br>
					<input type="text" name="ape2" placeholder="Segundo Apellido" /></br></br>
					<input type="submit" value="Enviar"/>
               </form>
               </br>
               <p>El servidor responde:</p>
               <% 
               		if( request.getAttribute("nombre")!= null){
               			String nombrepost = (String)request.getAttribute("nombre");
               			String apellido1post = (String)request.getAttribute("ape1");
               			String apellido2post = (String)request.getAttribute("ape2");
               			out.print("<p><b>" + nombrepost + " " + apellido1post + " " + apellido2post + "</b></p>");
               		}
               
               %>
            </div>
        </div>
    </section>
    
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
