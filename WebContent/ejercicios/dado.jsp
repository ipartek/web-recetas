<%@include file="../../includes/header.jsp" %>
<div class="container">
                <div class="row">
					<h1></h1>
					<form action="dado" method="post">
					
					<input type="text" name="afortunado"  value="${afortunado}" readonly>
					
			
					<input type="submit" value="Tirar dado">

					</form>
				</div>
</div>
<%@include file="../../includes/footer.jsp" %>