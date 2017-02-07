<%@page import="com.ipartek.formacion.recetas.pojo.Receta"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/nav.jsp" %>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive logo-home" src="img/profile.png" alt="logotipo de Web Recetas">
                    <div class="intro-text">
                        <span class="name">Komilones App</span>
                        <hr class="star-light">
                        <span class="skills">Sencillo, fácil y para toda la familia</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Recetas Destacadas Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Recetas Destacadas</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
            
            <%
            	ArrayList<Receta> recetas = new ArrayList<Receta>();
            	recetas.add( new Receta("Marmitako") );
           		recetas.add( new Receta("Tortilla Patatas") );
           		recetas.add( new Receta("Solomillo") );
           		recetas.add( new Receta("Txipirones en su pinta") );
           		recetas.add( new Receta("Bacalo al pil pil") );
           		recetas.add( new Receta("Mejillones al vapor") );
            		
           		Receta receta = null;
           		for (int i=0; i< recetas.size(); i++ ) {
           			receta = recetas.get(i);
            %>
            	<!-- receta -->
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal<%=i%>" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="<%=receta.getImagen()%>" class="img-responsive" alt="<%=receta.getTitulo()%>">
                    </a>
                </div>
                <!-- end:receta -->
            <%
           		} // end for recetas            
            %>    
                
            </div>
            <!-- <div class="row"> -->
        </div>
        <!-- <div class="container"> -->
    </section>

    <!-- About Section -->
    <section class="success" id="about">
        <div class="container" id="ejercicios">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Ejercicios</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                
                <ul>
                	<li><a href="ejercicios/menu-del-dia.jsp">Menu del Día</a></li>
                	<li><a href="ejercicios/primer-controlador.jsp">Controlador o Servlet [GET y POST]</a></li>
                	<li><a href="ejercicios/error-page.jsp">Gestion Errores en JSP</a></li>
                	<li><a href="ejerciciosXXXX/pagina-no-existente-404.jsp">Gestion Error 404</a></li>
                	<li><a href="controladorExcepcion?p=1">Gestion Error 500</a></li>
                	<li><a href="controladorExcepcion?p=2">Gestion Error VehiculoException</a></li>                   	
                	<li><a href="ejercicios/crear-vehiculo.jsp">Crear Vehiculo y Excepciones Personalizadas</a></li>
                	<li><a href="vehiculo">CRUD de Vehiculos</a></li>  
                	<li><a href="receta">CRUD de Recetas</a></li> 
                	<li><a href="dado?op=1">Dado</a></li>    
                	<li><a href="ejercicios/crear-fichero.jsp">Crear Fichero Texto</a></li>
                	<li><a href="jdbc">JDBC - Consulta Base Datos</a></li>
                	<li><a href="migracion">Proceso Migración</a></li>
                	<li><a href="zona-segura/index.jsp">Filtro seguridad</a></li>
                </ul>
                
            </div>
        </div>
    </section>
    
    <!-- Creadores Section -->
    <section id="creadores">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Creadores</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    
                    <ol>
                    	<li><a href="cv/usuario-x.jsp">Ander</a></li>
                    	<li><a href="cv/cv-eneko.jsp">cv-Eneko</a></li>
                    	<li><a href="cv/usuario-itsaso.jsp">Usuario-Itsaso</a></li>
                    </ol>
                    
                </div>
            </div>
        </div>
    </section>
    

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Contact Me</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Name</label>
                                <input type="text" class="form-control" placeholder="Name" id="name" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Email Address</label>
                                <input type="email" class="form-control" placeholder="Email Address" id="email" required data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Phone Number</label>
                                <input type="tel" class="form-control" placeholder="Phone Number" id="phone" required data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Message</label>
                                <textarea rows="5" class="form-control" placeholder="Message" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
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

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

	<%
		receta = null;
        for (int i=0; i< recetas.size(); i++ ) {
        	receta = recetas.get(i);
    %>

    <!-- ventana Modal -->
    <div class="portfolio-modal modal fade" id="portfolioModal<%=i%>" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2><%=receta.getTitulo()%></h2>
                            <hr class="star-primary">
                            <img src="img/portfolio/cabin.png" class="img-responsive img-centered" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--  End:ventana Modal -->
    <%
        } //end for recetas
    %>
    
<%@include file="includes/footer.jsp" %>