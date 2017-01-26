
/*
 * Nuestro js personalizado
 * Se carga lo ultimo despues del resto de librerias
 */

//esperamos a que todo el DOM(html doc) este cargado
//Entoces ejecutamos la funcion
$(document).ready(function() {
    $('.data-table-mio').DataTable();
} );