<%@include file="../includes/header.jsp" %>

<br><br><br><br><br>

   		<h1>Estoy en login</h1>
   		<%@include file="../includes/Mensaje.jsp" %>
   		<form action="login" method="post"> <!-- post para que no se vean los parametros -->
   			
   	 		<label>Nombre: </label><input type="text" name="userName" required placeholder="Introduzca nombre de usuario">
   			<br><label>Pasword: </label><input type="password" name="userPW" required placeholder="Contraseña">
   			<br>
   			<input type="submit" value="login">
   		
   		
   		</form>





<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="https://player.vimeo.com/external/147827948.sd.mp4?s=c8739aa76e715267d626c264ddce6e4406a0ef53" type="video/webm">
  </video>
  <div class="inner-container">
    <video class="bgvid inner" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="https://player.vimeo.com/external/147827948.sd.mp4?s=c8739aa76e715267d626c264ddce6e4406a0ef53" type="video/webm">
    </video>
    <div class="box">
      <h1>Login</h1>
      <input type="text" placeholder="Username"/>
      <input type="text" placeholder="Password"/>
      <button>Login</button>
      <p>Not a member? <span>Sign Up</span></p>
    </div>
  </div>
</div>
</div>



<%@include file="../includes/footer.jsp" %>