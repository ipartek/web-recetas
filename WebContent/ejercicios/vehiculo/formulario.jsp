<%@include file="../../includes/header.jsp" %>
Todo para voosotros, 
pero que CREE, MODIFIQUE y ELIMINE
<form action="crear-vehiculo" method="post"> <!-- El action es la llamada al Mapping (controlador) que hemos creado antes. Especificamos que el método por el que lo enviaremos es post. -->
             <label>Modelo:</label> <input type="text" name="modelo" id="modelo" placeholder="Escriba el modelo del coche" PATTERN=".{2,255}" required> <!-- Para mapear es importante el name -->
            <br><label>Plazas:</label> <input type="number" min="1" step="1" name="plazas" id="plazas" placeholder="Escriba las plazas del coche" required>
             <br><label>Potencia:</label> <input type="number" name="potencia" id="potencia" placeholder="Escriba la potencia del coche" required>
           <br> <input type="submit" value="CREAR COCHE">
            </form>

ES NUEVO?


<%@include file="../../includes/footer.jsp" %>