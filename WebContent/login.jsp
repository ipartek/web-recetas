<%@include file="includes/header.jsp"%>

<%-- <header>
	<div class="container header-content">
		<div class="row">
			<div class="col-lg-12">
				<h1>Login Page</h1>
			</div>
		</div>
	</div>
</header>


		<p>Realizamos un formulario para hacer un login</p>


		<%@include file="includes/mensaje.jsp"%>

		<div class="vid-container">
			<video class="bgvid" autoplay="autoplay" muted="muted" preload="auto"
				loop>
				<source
					src="http://mazwai.com/system/posts/videos/000/000/109/webm/leif_eliasson--glaciartopp.webm?1410742112"
					type="video/webm">
			</video>
			<div class="inner-container">
				<div class="box">
					<h1>Login</h1>
					<form action="login" method="post">
						<input type="text" class="form-control" id="user" name="user"
							placeholder="Nombre de usuario" required="required"> <input
							type="password" min="4" max="15" class="form-control"
							id="password" name="password" placeholder="Password"
							required="required">
						<button>Login</button>
					</form>
					
				</div>
			</div>
		</div> --%>
		<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="video/Cooking.mp4" type="video/webm">
  </video>
  <div class="inner-container">
    
    <div class="box">
      <h1>Login</h1>
      <%@include file="includes/mensaje.jsp" %>
      <form action="login" method="post">
				
			<input type="text" name="user" required placeholder="Nombre Usuario">
			
			<input type="password" name="password" required placeholder="Contraseña">
			
			<input type="submit" value="Login">
		</form>		
    </div>
  </div>
</div>
		

<%@include file="includes/footer.jsp"%>