<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Insertar personas!</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  
   <div class="container">
      <div class="row">
			<%@include file="../../includes/mensaje.jsp" %>
			
			Ejercicio para leer un fichero de 10000 personas(algunas con datos incorrectos)<br>
			que se debera de leer e insertar en la base de datos los que contienen datos correctos<br>
			mostrando cuantas personas han sido insertadas correctas y cuantas no.
			
			
			
			<form action="personas" method="post">
				<input type="submit" value="BOTON NUCLEAR(De insercion)">		
			</form>
			
			 <hr>
		     <c:if test="${correctos > 0 }">
		     <h3>Resultado:</h3>
		     Implementaciones correctas: ${correctos} <br>
		     Implementaciones incorrectas: ${incorrectos} <br>
		     Lineas leidas en total: ${total} <br>
		     Tiempo tardado: ${tiempo} ms
  			 </c:if>
			
			
			



    </div> 
     
    <br>
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../../includes/footer.jsp" %>