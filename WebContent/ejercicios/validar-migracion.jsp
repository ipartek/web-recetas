<%@include file="../includes/header.jsp" %>
 <%@include file="../includes/nav.jsp" %>
 
 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Migrar 10000 personas </h1>
               </div>
             </div>             
 		</div> 
 	</header>
 	
<div class="container">
 	<div class="row">
 	
 	<%@include file="../includes/mensaje.jsp"%>
 	
 	<hr>
 	<form action="migracion" method="POST">
 	
 	<input type="submit" value="Migracion">
 	</form>
 	
    
 	</div>
 
 </div>
 	
 	
<%@include file="../includes/footer.jsp"%> 