
<%@page isErrorPage="true"%>


<%@page import="com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo"%>
<%@include file="../includes/header.jsp" %>


 <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Capturada Exception</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
   <div class="container">
      <div class="row">
			<p>La JSP <code>error-lanza-exception</code> ha fallado y esta pagina captura la excepcion.</p>
			<p>Podemos mostrar la Excepcion si queremos con el objeto implicito <code>exception</code></p>
			<%=exception%>

	</div> 
    <!--  <div class="row"> -->
</div>    
<!-- <div class="container"> -->

<%@include file="../includes/footer.jsp" %>