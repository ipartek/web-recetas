/*
 * Nuestro JavaScript personalizado
 * Siempre se carga en el footer, depues del resto de librerias.
 * 
 */

//Esperamos a que todo el DOM (documento html) este cargado
//entonces ejecutamos la funcion
$(document).ready(function() {
	//Activar plugin DataTable para todos los elementos de html con class="data-table.mio"
    $('.data-table-mio').DataTable();
} );
