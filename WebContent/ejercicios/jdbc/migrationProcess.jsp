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
<p>Ejercicio para realizar una migración de datos desde un fichero de texto a una Base Datos.</p>
			<p>Aprenderemos ha realizar transacciones atomicas, con <code>commit</code> y <code>rollback</code></p>

<form action="migration" method="post"> 
				
				<input type="submit" value="Migración">
			</form>
<h2>Mensajes de sucesos</h2>
			<table class="display data-table-mio" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Edad</th>
                <th>E-mail</th>
                <th>DNI</th>
                <th>Puesto</th>               
            </tr>
        </thead>        
        <tbody>
        <c:forEach var="p" items="${personas}">        
	            <tr>
	                <td>${p.id}</td>
	                <td>${p.nombre}</td> 
	                <td>${p.apellido1}</td>
	                <td>${p.apellido2}</td>   
	                <td>${p.edad}</td>
	                <td>${p.email}</td>
	                <td>${p.dni}</td>
	                <td>${p.puesto}</td>     
	            </tr>
           </c:forEach> 
        
        </tbody>
        </table>
			<p class="anotaciones">${tiempo}</p>
</div>
</div>



<%@include file="../../includes/footer.jsp" %>
<!-- separar con split.crear tabla persona, con un id automático. -->