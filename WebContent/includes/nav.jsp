<!-- Navigation -->
<%@page errorPage="../error.jsp"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">Web Recetas</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#portfolio">Recetas</a></li>
					<li class="page-scroll"><a href="#about">Ejercicios</a></li>
					<li class="page-scroll"><a href="#contact">Contact</a></li>

					<li class="page-scroll">
						<%
					Usuario user= (Usuario)session.getAttribute("user");
					if (user==null){
						
					%> <a href="login.jsp">Login</a> <%
					}else{
						
					%> <a href="logout"><img class="img-circle"
							style="width: 10%; float: right"
							src="<%=user.getImagen()%>" > (${sessionScope.user.nombre})Cerrar[X] </a>
   
					<%
					}
					%>
					</li>
					
				</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>