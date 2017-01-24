<!DOCTYPE html>
<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<html lang="es">
<head>
	
	<base href="/web-recetas/">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Segundo Ejemplo Controlador</title>

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
	            <h1>Segundo Ejemplo Controlador</h1></br>
	            
	            <%@include file="../includes/mensaje.jsp" %>
	            
			    <p>Realizamos un formulario para poder crear un nuevo <code>Vehiculo</code>.</p>
			    <p>Al crear un <code>Vehiculo</code> con numero de plazas inferior a 0, lanzara una excepcion personalizada, que es controlada en el Servlet.</p>
			    <p>Tambien tenemos que tener en cuenta los parametros que deben ser casteado a <code>int</code> o <code>float</code>, puede fallar.</p>
			    <p>Si creamos coche con exito, mostrar Vehiculo usando Expresion Lenguage.</p>
			    <p>Tambien validamos en el front-end con HTML5 <code>required</code> y <code>pattern</code>.<p>
			    <p><code>${vehiculo}</code></p> 
			     
	            <h2>Creador de Coches</h2></br>
	            <form action="crear-vehiculo" method="post">
	               	<label>Modelo: </label></br>
					<input type="text" name="modelo" placeholder="Modelo" required pattern=".{2,255}"/></br></br>
					<label>Potencia:</label></br>
					<input type="number" name="potencia" placeholder="Potencia" required min="1"; /></br></br>
					<label>Plazas: </label></br>
					<input type="number" name="plazas" placeholder="Nº Plazas" required /></br></br>
					<input type="submit" value="Crear Coche"/>
	            </form>   
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
