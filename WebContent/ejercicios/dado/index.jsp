<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>

<section>
		<header>
        	<div class="container header-content">
            	<div class="row">
               		<div class="col-lg-12">
                		<h1>DADO</h1>
                	</div>
              	</div>  
  			</div> 
  		</header> 
  	

        <div class="container">
            <div class="row"> 
            	<div id="posImagen">
            		<div id="posTitulo"> 
						<c:if test="${alumno != null}">
							<p><span id="tamLetra">${alumno.alumno}</span></p>
						</c:if>
					</div>
	  				<img alt="dado" src="img/dado.png">
	 				<c:choose>
	 					<c:when test="${numMaxAlumnos != null}">
	 						<p><strong><em>Alumnos maximos: </em></strong>${numMaxAlumnos}</p>
	 					</c:when>
	 					<c:otherwise>
	 						<p>No existen alumnos</p>
	 					</c:otherwise>
	 				</c:choose>
	 				<div id="posBoton">
		 				<form action="dado" method="post">
		 					<input type="hidden" name="op" value="2">
							<input type="submit" value="Lanzar">
						</form>
					</div>
				</div>
		  	</div>
            <!-- <div class="row"> -->
    	</div>
    	<!-- <div class="container"> -->
    </section>	
    
    
<%@include file="../../includes/footer.jsp" %>