<%@include file="includes/header.jsp" %>

<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="video/Cooking.mp4" type="video/webm">
  </video>
  <div class="inner-container">
    
    <div class="box">
      <h1>Login</h1>
      <%@include file="includes/mensaje.jsp" %>
      <form action="login" method="post">
				
			<input type="text" name="userName" required placeholder="Nombre Usuario">
			
			<input type="password" name="userPass" required placeholder="Contrase�a">
			
			<input type="submit" value="Login">
		</form>		
    </div>
  </div>
</div>


<%@include file="includes/footer.jsp" %>