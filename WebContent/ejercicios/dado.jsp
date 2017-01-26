<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
 <body>
 <header>
	        <div class="container header-content">
	            <div class="row">
	                <div class="col-lg-12">
	                	<h1>Dado magico!</h1>
	                </div>
	              </div>  
	  		</div> 
</header> 
				<%@include file="../includes/mensaje.jsp" %>
				<a href="dado">Tirar dado</a>
				<form action="dado" method="get">
					<input type="submit" value="Lanzar dado">
               	</form>
</body>
<%@include file="../includes/footer.jsp" %>