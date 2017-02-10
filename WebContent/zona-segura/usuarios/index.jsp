<%@page import="com.ipartek.formacion.recetas.controller.UsuariosCRUDController"%>
<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/nav.jsp" %>
   
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
       <%@include file="../../includes/mensaje.jsp" %>
       		<h2><a href="usuarios?op=3">Crear Nuevo</a></h2>
       		<form method="post" action="usuarios">
       			<label>Filtro por Email</label>
       			<input type="text" name="emailfiltro">
       			<input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_FILTRAR_EMAIL%>">
       			<input type="submit" value="Filtrar">
       		</form>
       		<form method="post" action="usuarios">
       			<label>Filtro por DNI:</label>
       			<input type="text" name="dnifiltro">
       			<input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_FILTRAR_DNI%>">
       			<input type="submit" value="Filtrar">
       		</form>
       		<form method="post" action="usuarios">
       			<label>Nombre y Apellido</label>
       			<input type="text" name="nombreapellidofiltro">
       			<input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_FILTRAR_NOMBRE_APELLIDO%>">
       			<input type="submit" value="Filtrar">
       		</form>
       		<form method="post" action="usuarios">
       			<label>Rango de edad:</label>
       			<input id="ex2" type="text" class="span2" name="edadfiltro" value="" data-slider-min="1" data-slider-max="100" data-slider-step="1" data-slider-value="[18,35]"/>
       			<input type="hidden" name="op" value="<%=UsuariosCRUDController.OP_FILTRAR_EDAD%>">
       			<input type="submit" value="Filtrar">
       		</form>
       		<form method="post" action="usuarios">
       			<input type="hidden" name="op" value="">
       			<input type="submit" value="Vaciar filtro">
       		</form>
       		<br><br>
       		<c:if test="${emailencontrado != null}">
       		<p> Se filtra por el email </p>
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
			            <tr>
			                <td><a href="usuarios?op=2&id=${emailencontrado.id}">${emailencontrado.id}</a></td>
			                <td>${emailencontrado.nombre}</td>
			                <td>${emailencontrado.apellido1}</td>
			                <td>${emailencontrado.apellido2}</td>
			                <td>${emailencontrado.edad}</td> 
			                <td>${emailencontrado.email}</td> 
			                <td>${emailencontrado.dni}</td> 
			                <td>${emailencontrado.puesto}</td>
			                <td><img style="width:50px;" src="${emailencontrado.imagen}"></td>         
			            </tr>
		       </tbody>
		     </table>
       		</c:if>
       		<c:if test="${dniencontrado != null}">
       		<p> Se filtra por el dni</p>
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
			            <tr>
			                <td><a href="usuarios?op=2&id=${dniencontrado.id}">${dniencontrado.id}</a></td>
			                <td>${dniencontrado.nombre}</td>
			                <td>${dniencontrado.apellido1}</td>
			                <td>${dniencontrado.apellido2}</td>
			                <td>${dniencontrado.edad}</td> 
			                <td>${dniencontrado.email}</td> 
			                <td>${dniencontrado.dni}</td> 
			                <td>${dniencontrado.puesto}</td>
			                <td><img style="width:50px;" src="${dniencontrado.imagen}"></td>         
			            </tr>
		       </tbody>
		     </table>
		    </c:if>
		    <c:if test="${nombreapellidoencontrado != null}">
		    <p> Se filtra buscando en nombre y apellidos </p>
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
		        	<c:forEach var="u" items="${nombreapellidoencontrado}">        
			            <tr>
			                <td><a href="usuarios?op=2&id=${u.id}">${u.id}</a></td>
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
		    </c:if>
		    <c:if test="${edadencontrado != null}">
		    <p> Se Filtra por edad</p>
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
		        	<c:forEach var="u" items="${edadencontrado}">        
			            <tr>
			                <td><a href="usuarios?op=2&id=${u.id}">${u.id}</a></td>
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
		    </c:if>
       		<c:if test="${emailencontrado == null && dniencontrado == null && nombreapellidoencontrado == null && edadencontrado == null}">
			 <p> Se muestran los ultimos 500 usuarios de un total de: ${total} usuarios </p>
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
			                <td><a href="usuarios?op=2&id=${u.id}">${u.id}</a></td>
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
		     </c:if>
		</div>
	</div>	
	
	
<%@include file="../../includes/footer.jsp" %>		