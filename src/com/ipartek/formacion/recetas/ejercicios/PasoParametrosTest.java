package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.VehiculoException;

/**
 * Al pasar parametros a un metodo existen dos posibilidades:<br>
 * 1.Paso por valor ( primitivos: int, boolean, etc ).<br>
 * 2.Paso por Referencia ( cualquier Object o descendiente )<br>
 * <br>
 * 
 * En el paso por valor, se pasa una copia del valor primitivo. Sin embargo en
 * el paso por referencia, se pasa la posicion de memnoria donde estan los datos
 * del Objeto.
 * 
 * 
 * @author ur00
 *
 */
public class PasoParametrosTest {

	@Test
	public void testParametroValor() {
		int x = 0;
		int y = suma(x);

		assertEquals(0, x);
		assertEquals(1, y);
	}

	@Test
	public void testParametroReferencia() throws VehiculoException {

		Vehiculo x = new Vehiculo();
		x.setPlazas(0);

		sumaPlazas(x);

		assertEquals(1, x.getPlazas());

	}

	private int suma(int pValor) {
		return ++pValor;
	}

	private void sumaPlazas(Vehiculo v) throws VehiculoException {
		v.setPlazas((v.getPlazas() + 1));
	}

}
