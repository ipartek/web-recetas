<%@include file="../../includes/header.jsp" %>
<header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Migración de base de datos</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
<div class="container">
      <div class="row">
<%@include file="../../includes/Mensaje.jsp" %>
<p>Probando si funciona</p>

<form action="migration" method="post"> 
				
				<input type="submit" value="Migración">
			</form>
<h2>Mensajes de sucesos</h2>
			<p class="anotaciones"></p>
</div>
</div>



<%@include file="../../includes/footer.jsp" %>
<!-- separar con split.crear tabla persona, con un id automático. -->