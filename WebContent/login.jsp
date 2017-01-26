<%@include file="includes/header.jsp"%>

<!-- 	<div class="container">
		<div class="row">
 -->			
			<div class="vid-container">
				 <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
			      	<source src="https://player.vimeo.com/external/147827948.sd.mp4?s=c8739aa76e715267d626c264ddce6e4406a0ef53" type="video/webm">
			  	</video> 
			  	<div class="inner-container">
			   		
			   		<%@include file="includes/mensaje.jsp"%>
			   
			    	<div class="box">
    	
						<h1>Login</h1>
						
						<form action="login" method="post">
							<input type="text" name="userName" placeholder="Nombre Usuario" required>
							<input type="password" name="userPass" placeholder="Contraseña" required>
							
							<input class="button" type="submit" value="Login">
							
						</form>
					</div>
				</div>
				<!-- end: <div class="inner-container"> -->
			</div>
			<!-- end: <div class="vid-container"> -->
			
<!-- 		</div>  -->
		<!-- <div class="container"> -->
<!--	</div>  -->
	<!-- <div class="row"> -->


<%@include file="includes/footer.jsp"%>

