/*
 * Nuestro JavaScript personalizado 
 * Siempre se caraga en el footer, despues del resto de librerias.
 * 
 * */

// Esperamos a que todo el DOM(documento html) este cargado
// entonces ejecutamos la funcion
$(document).ready(function() {
	
	// Activar plugin DataTable para todos los elementos
	// de html con class="data-table-mio"
	
	$('.data-table-mio').DataTable();
	
	
});

//Bootstrap slider codigo que nos pide
var slider = new Slider('#ex2', {});