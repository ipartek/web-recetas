<%@include file="../includes/header.jsp" %>

	<div class="container">
		<div class="row">    
			<%@include file="../includes/nav.jsp" %>
			<%@include file="../includes/mensaje.jsp" %>
			
			<div class="vid-container">
  <video class="bgvid" autoplay="autoplay" preload="auto" loop>
      <source src="https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/4934/5/149670837/456505879.mp4?token=5889df14_0x87ea8e118c7ff61209160b7a0216d54f990d0c77" type="video/webm">
  </video>
  <div class="inner-container">
    <video class="bgvid inner" autoplay="autoplay" preload="auto" loop>
      <source src="https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/4934/5/149670837/456505879.mp4?token=5889df14_0x87ea8e118c7ff61209160b7a0216d54f990d0c77" type="video/webm">
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        <h3>Location</h3>
                        <p>3481 Melrose Place
                            <br>Beverly Hills, CA 90210</p>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>Around the Web</h3>
                        <ul class="list-inline">
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-dribbble"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>About Freelancer</h3>
                        <p>Freelance is a free to use, open source Bootstrap theme created by <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; Your Website 2016
                    </div>
                </div>
            </div>
        </div>
    </footer>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <%@include file="../includes/footer.jsp" %>
    