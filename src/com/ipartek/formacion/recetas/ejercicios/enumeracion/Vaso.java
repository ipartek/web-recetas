package com.ipartek.formacion.recetas.ejercicios.enumeracion;


public enum Vaso {
    // Tipos de vaso disponibles. Pasan al constructor su capacidad en cc.
    JARRA(500), CHUPITO(25), QUINTO(220), CA�A(200);
    private int cc; // Variable interna donde almacenaremos la capacidad
    // Nuestro constructor nos fuerza a pasar par�metros al definir un nuevo tipo
    Vaso(int cc) {
        this.cc = cc;
    }
    // Devuelve la capacidad del vaso
    public int getCentimetrosCubicos() {
        return cc;
    }
    
    String getDescripcion() {
		String resul = "Sin descripcion";
		switch(this){
		
		case JARRA:
			resul = "Jarra cerveza de " + this.getCentimetrosCubicos();
			break;
		case CHUPITO:
			resul = "Chupito de " + this.getCentimetrosCubicos();
			break;
		case QUINTO:
			resul = "Quinto de " + this.getCentimetrosCubicos();
			break;
		case CA�A:
			resul = "Ca�a de " + this.getCentimetrosCubicos();
			break;
		default:
			break;
		}
		return resul;
	}
}
