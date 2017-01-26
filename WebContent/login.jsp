<%@include file="../includes/header.jsp" %>

<br><br><br><br><br>

   		<h1>Estoy en login</h1>

<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="https://player.vimeo.com/external/147827948.sd.mp4?s=c8739aa76e715267d626c264ddce6e4406a0ef53" type="video/webm">
  </video>
  <div class="inner-container">
    
     <%@include file="../includes/Mensaje.jsp" %>
    <div class="box">
      <h1>Login</h1>
     
      <form action="login" method="post">
				
			<input type="text" name="userName" required placeholder="Nombre Usuario">
			
			<input type="password" name="userPW" required placeholder="Contraseña">
			
			<input type="submit" value="Login">
		</form>		
    </div>
  </div>
</div>

<%@include file="../includes/footer.jsp" %>