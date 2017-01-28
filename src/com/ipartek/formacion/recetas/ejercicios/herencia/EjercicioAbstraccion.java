package com.ipartek.formacion.recetas.ejercicios.herencia;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.ACirculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Linea;

public class EjercicioAbstraccion {

	public static void main(String[] args) {

		//No podemos instanciar una Clase Abstracta
		//AObjetoGrafico og = new AObjetoGrafico(0, 0);
		
		//Si podemos instanciar un Objeto de una Clase hija
		//AObjetoGrafico(abstracta) es padre de Line(no abstracta)
		Linea l = new Linea(1, 2);
		l.dibujar();
		

		//Una Clase Abstracta se puede instanciar siempre y cuando 
		//se implemente el codigo durante la instanciacion
		ACirculo c = new ACirculo(10,20,5) {

			@Override
			public void dibujar() {
				System.out.println(this.getRadio() + this.x + this.y);
			}
		};//Clase Anonima
		
		c.dibujar();
		c.mover(0,0);
	}
}
