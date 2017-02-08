<%@include file="includes/header.jsp" %>
<div class="container">
                <div class="row">
					<h1>LOGIN</h1>
					<%@include file="../includes/mensaje.jsp" %>
					<form action="login" method="post">
					<input type="text" name="userName" required="required" placeholder="Nombre de Usuario"><br>
					<input type="password" name="userPass" required="required" placeholder="Contraseña"><br>
					<input type="submit" value="login">
					
					</form>
				</div>
</div>
<%@include file="includes/footer.jsp" %>