<%@include file="includes/header.jsp" %>
<%@include file="includes/nav.jsp" %>
<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="videos/Kebab.mp4" type="video/webm">
  </video>
  <div class="inner-container">
    <video class="bgvid inner" autoplay="autoplay" muted="muted" preload="auto" loop>
      <source src="videos/Kebab.mp4" type="video/webm">
    </video>
    <div class="box">


		<h1>LOGIN</h1>
		
		<%@include file="../includes/mensaje.jsp" %>
		
		<form action="login" method="post">
		
			<input type="text" name="userName" required placeholder="Nombre Usuario">
			
			<input type="password" name="userPass" required placeholder="Contraseña">
			
			<input class="button" type="submit" value="login">	
		</form>
	</div>

</div>
</div>
<%@include file="includes/footer.jsp" %>