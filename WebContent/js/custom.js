/* Nuestro JS personalizado.
 * Siempre se carga en el footer, despues del resto de librerias
 * 
 */

//Esperamos a que todo el DOM (documentohtml) este cargado
//Entonces ejecutamos la funcion
$(document).ready(function() {
	//Activar plugin DataTable para todos los elementos de html con class="data-table-mio"
 	$('.data-table-mio').DataTable();
} );