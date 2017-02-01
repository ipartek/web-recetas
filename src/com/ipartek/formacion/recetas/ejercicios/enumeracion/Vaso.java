package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public enum Vaso {

	 // Tipos de vaso disponibles. Pasan al constructor su capacidad en cc.
    JARRA(500), QUINTO(220), CRIANZA(40), CAÑA(200);
    private int cc; // Variable interna donde almacenaremos la capacidad
    // Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo tipo
    Vaso(int cc) {
        this.cc = cc;
    }
    // Devuelve la capacidad del vaso
    public int getCentimetrosCubicos() {
    	return cc;
    }
    
    String getDescripcion(){
    	String resul = "";
    	switch(this){
		case JARRA:
			resul = "Jarra de " + this.getCentimetrosCubicos();
			break;
		case CAÑA:
			resul = "Caña de " + this.getCentimetrosCubicos();
			break;
		case CRIANZA:
			resul = "Crianza de " + this.getCentimetrosCubicos();
			break;
		case QUINTO:
			resul = "Quinto de " + this.getCentimetrosCubicos();
			break;
		default:
			break;
		}
        return resul;
    }
	
}
