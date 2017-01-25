

<body id="" class="index">

	<section>
		<h1>Mi Primer Controlador</h1>
		<div class="container">
			<div class="row">
				<p>
					Los <b>Controladores</b> en Java son <b>Servlets</b>.
				</p>
				<p>
					Un controlador se encarga de recibir <b>Request</b> del cliente y
					darle una<b>Response</b>.
				</p>
				<p>Puede recibir y retornar parametros.</p>
				<p>
					Puede aceptar peticiones de tipo <b>GET</b> o <b>POST</b>.
				</p>

				<p>
					Mapping del Servlet:<b>/saludo</b>
				</p>
				<h2>Petición GET</h2>
				<p>Vamos a enviar tres parametros para que el Servlet nos
					retorne un saludo con nuestro nombre y apellidos.</p>
				<p>Las peticiones GET se hacen mediante enlaces,links o anclas.</p>
				<p>
					pulsa enlace para realizar petición GET <a
						href="saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola">/saludo?nombre=Pepe&ape1=Gorriti&ape2=BarrenagotiaSola</a>
				</p>

				<h2>Petición Post</h2>
				<form action="saludo" method="post">

					<input type="text" name="nombre"
						placeholder="Recordar que para mapear este campo es importante atributo name">

					<input type="text" name="ape1" placeholder="Apellido 1"> 
					<input type="text" name="ape2" placeholder="Apellido 2"> 
					<input type="submit" value="Enviar">

				</form>
			</div>

		</div>
	</section>
	<h2>Respuesta</h2>
	<%
    if (request.getAttribute("nombre") != null){
    	String nombre =(String)request.getAttribute("nombre");
    	out.print("nombre: "+nombre+" ");  
    }
	 if (request.getAttribute("ape1") != null){
    	String ape1 =(String)request.getAttribute("ape1");
    	out.print("Apellidos: "+ape1+" ");
    	}
	if (request.getAttribute("ape2") != null){
    	String ape2  =(String)request.getAttribute("ape2");
    	out.print(ape2);
    	} 
    %>

	<%@include file="../includes/footer.jsp"%>