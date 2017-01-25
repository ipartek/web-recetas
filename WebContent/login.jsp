<%@include file="includes/header.jsp" %>

<div class="container">
   <div class="row">
		<h1>LOGIN</h1>
		
		<%@include file="includes/mensaje.jsp" %>
		
		<form action="login" method="post">
				
			<input type="text" name="userName" required placeholder="Nombre Usuario">
			<br>		
			<br>
			<input type="password" name="userPass" required placeholder="Contraseña">
			<br>
			<br>
			<input type="submit" value="Login">
		</form>		
		
	</div>
</div>		

<%@include file="includes/footer.jsp" %>