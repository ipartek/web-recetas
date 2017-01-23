
public class Excepciones {

	public static void main(String[] args) throws Exception {

		System.out.println("Empezamos main");
		metodoA();
		System.out.println("Terminamos main");

	}

	public static void metodoA() throws Exception {
		System.out.println("Empezamos metodo A");
		metodoB();
		System.out.println("Terminamos metodo A");
	}

	public static void metodoB() {
		System.out.println("Empezamos metodo B");
		try {
			// lanza excepci�n aritm�tica
			int resul = 20 / 0;
			Object o = null;
			o.toString();
			System.out.println("Esta linea nunca se ejecuta. L�nea roja del cuaderno de apuntes, p�gina 17");
		} catch (ArithmeticException e) {
			System.out.println("OOOPS!! Hemos tenido una excepoci�n: de tipo ArithmeticException " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("OOOPS!! Hemos tenido una excepoci�n: de tipo NullPointerException " + e.getMessage());
			e.printStackTrace(); // pinta la traza del fallo (donde se encuentra
									// el fallo)
		} catch (Exception e) {
			System.out.println("OOOPS!! Hemos tenido una excepoci�n: de tipo Exception e (general) " + e.getMessage());
		} finally { // finally es opcional

			System.out.println("Este bloque se ejecuta siempre, haya o no excepciones.");
		}
		System.out.println("Terminamos metodo B");
	}
}
