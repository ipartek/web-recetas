package com.ipartek.formacion.recetas.ejercicios;

public class Excepciones {

	public static void main(String[] args) {
		System.out.println("Empezamos main");
		metodoA();
		System.out.println("Terminamos main");

	}
	
	public static void metodoA(){
		System.out.println("Empezamos metodoA");
		metodoB();
		System.out.println("Terminamos metodoA");
	}
	
	public static void metodoB(){
		System.out.println("Empezamos metodoB");
		
		try{
			
			int resul = 20/0;
			
			Object o = null;
			o.toString();
			System.out.println("Esta linea nunca se ejecuta");
			
		}catch(ArithmeticException e){
			System.out.println("Ups ArithmeticException " + e.getMessage());
			e.printStackTrace();
			
		}catch(NullPointerException e){
			System.out.println("Ups NullPointerException " + e.getMessage());
			e.printStackTrace();
			
		}catch(Exception e){
			System.out.println("Ups hemos tenido una exception " + e.getMessage());
			e.printStackTrace();
			
		}finally{
			System.out.println("Esto se ejecuta siempre, haya o no excepcion");
		}
		System.out.println("Terminamos metodoB");
	}

}
