<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>
   
  <header>
       <div class="container header-content">
           <div class="row">
               <div class="col-lg-12">
               	<h1>Zona Segura</h1>
               </div>
             </div>             
 		</div> 
 	</header> 
  	
    <div class="container">
       <div class="row">
       		<h2><a href="usuario?op=3">Crear Nuevo</a></h2>
       
       
			 <table class="display data-table-mio" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Apellido 1</th>
		                <th>Apellido 2</th>
		                <th>Edad</th>                
		                <th>Email</th>                
		                <th>Dni</th>
		                <th>Puesto</th>
		                <th>Imagen</th>                                  
		            </tr>
		        </thead>        
		        <tbody>
		        	<c:forEach var="u" items="${usuarios}">        
			            <tr>
			                <td><a href="usuario?op=2&id=${u.id}">${u.id}</a></td>
			                <td>${u.nombre}</td>
			                <td>${u.apellido1}</td>
			                <td>${u.apellido2}</td>
			                <td>${u.edad}</td> 
			                <td>${u.email}</td> 
			                <td>${u.dni}</td> 
			                <td>${u.puesto}</td>
			                <td><img style="width:50px;" src="${u.imagen}"></td>         
			            </tr>
		           </c:forEach>        
		       </tbody>
		     </table>
		</div>
	</div>	
	
	
<%@include file="../includes/footer.jsp" %>		