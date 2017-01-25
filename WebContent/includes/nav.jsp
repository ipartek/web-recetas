<!-- Navigation -->
    <%@page import="com.ipartek.formacion.recetas.pojo.Usuario"%>
    <%@page errorPage="../error.jsp" %>
    
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
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#portfolio">Recetas</a>
                    </li>                    
                    <li class="page-scroll">
                        <a href="#ejercicios">Ejercicios</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li>
                    <% 
                    Usuario user = (Usuario)session.getAttribute("usuario");
            		if (user == null){
                    
                    %>
                    	<li class="page-scroll">
                        	<a href="login.jsp">Login</a>
                    	</li>
                    <%
            		}else{
            		%>
            			
                    	<li class="page-scroll">
                    		<a><%=user.getNombre() %></a>
            				
                    	</li>
                    	<!-- sessionScope.usuario.nombre (llama al getNombre())
                    		sessionScope.usuario (llama al toString())-->
                    	<li class="page-scroll">
                    		<a>${sessionScope.usuario.nombre}</a>
            				
                    	</li>
                    	<li class="page-scroll">
            				<img id="imgUser"alt="imagen usuario" src="<%=user.getImagen() %>">
                    	</li>
                    	<li class="page-scroll">
                        	<a href="logout">X</a>
                    	</li>
                    	
            		
            		<%
            		}
                    
                    %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>