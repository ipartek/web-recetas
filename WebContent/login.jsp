<%@include file="../includes/header.jsp" %>

	<div class="container">
		<div class="row">    
			<%@include file="../includes/nav.jsp" %>
			<%@include file="../includes/mensaje.jsp" %>
			
			<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" preload="auto" loop>
      <source src="https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/3625/6/168129563/537766766.mp4?token=5888c542_0xd9245c5b881c0d0f629c26f37b341a9d1954d43e" type="video/webm">
  </video>
  <div class="inner-container">
    <video class="bgvid inner" autoplay="autoplay" preload="auto" loop>
      <source src="https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/3625/6/168129563/537766766.mp4?token=5888c542_0xd9245c5b881c0d0f629c26f37b341a9d1954d43e" type="video/webm">
    </video>
    <div class="box">
      <h1>Login</h1>
      <form action="login" method= "post">
      <input type="text" name	="userName" required placeholder="Nombre de Usuario"/>
      <input type="password" name="userPass" required placeholder="Contraseña"/>
      <input type="submit" value="Login">
      </form>
    </div>
  </div>
</div>
</div>
</div>
    
    
    <%@include file="../includes/footer.jsp" %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <%@include file="../includes/footer.jsp" %>
    