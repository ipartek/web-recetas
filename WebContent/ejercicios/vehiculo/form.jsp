<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="operacion" scope="request" value="op"/>
<c:if test="${operacion == '3'}">
	<form action="vehiculo" method="post">
		<label>Modelo: </label></br>
		<input type="text" name="modelo" placeholder="Modelo" required pattern=".{2,255}"/></br></br>
		<label>Potencia:</label></br>
		<input type="number" name="potencia" placeholder="Potencia" required min="1"; /></br></br>
		<label>Plazas: </label></br>
		<input type="number" name="plazas" placeholder="Nº Plazas" required /></br></br>
		<input type="submit" value="Crear Coche"/>
	</form>
</c:if>