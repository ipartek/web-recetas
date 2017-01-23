<%@page import="com.ipartek.formacion.vehiculo.pojo.Vehiculo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">



<title>Vehiculo</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="../css/freelancer.min.css" rel="stylesheet">

<!-- Custom -->
<link href="../css/custom.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<section> <!-- <article>
	<div id="imagenGetPost">
		<img src="../img/vehiculo.jpg" class="img-responsive img-rounded"
			alt="Cinque Terre">
	</div>
	</article> -->
	<h1>Ejercicio Vehiculo</h1>
	<p>
		Ejercicio en el que se crea un vehiculo con los parametros: <br />
		Modelo,plazas,potencia y dimensiones.<br /> Si el vehiculo tiene la
		potencia, la dimension o las plazas negativas,<br /> No se creara el
		vehiculo y se mostrara un mensaje de error<br /> Si esta todo bien, se
		crea el vehiculo y se muestra por pantalla.<br /> Mapping del Servlet:<b>/vehiculo</b><br />
	</p>

	<article id="impresionDatos"> <%
 	Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo");
 	if (request.getAttribute("error") != null) {
 %>
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Error!</strong>${error}
	</div>
	<%
		} else if (vehiculo != null) {
	%>
	<div class="alert alert-success" role="alert">El vehiculo ha sido
		creado de manera correcta</div>
	<%
		out.println("<p><b>Modelo:</b> " + vehiculo.getModelo() + "</p>");
			out.println("<p><b>Plazas:</b> " + vehiculo.getPlazas() + "</p>");
			out.println("<p><b>Dimensiones:</b> " + vehiculo.getDimensiones() + "</p>");
			out.println("<p><b>Potencia:</b> " + vehiculo.getPotencia() + " CV</p>");
		}
	%> </article> </article> <article class="anchuraDivIndex">
	<form action="vehiculo" method="POST">
		<div class="form-group">
			<label for="modelo">Modelo</label> <input type="text"
				class="form-control" size="15" name="modelo" id="modelo"
				placeholder="Introduzca el modelo" required>
		</div>
		<div class="form-group">
			<label for="plazas">Plazas </label> <input type="number"
				class="form-control" name="plazas" id="plazas"
				placeholder="Introduzca las plazas" required>
		</div>
		<div class="form-group">
			<label for="dimensiones">Dimensiones: </label> <input type="number"
				class="form-control" name="dimensiones" id="dimensiones"
				placeholder="Introduzca las dimensiones" required>
		</div>
		<div class="form-group">
			<label for="potencia">Potencia:</label> <input type="number"
				class="form-control" name="potencia" id="potencia"
				placeholder="Introduzca la potencia" required>
		</div>

		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>
	</article> </section>


</body>
</html>