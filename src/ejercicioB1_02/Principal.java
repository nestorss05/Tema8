package ejercicioB1_02;

public class Principal {

	public static void main(String[] args) {

		// Hora hora1: una hora normal
		Hora hora1 = new Hora(22, 15, 33);

		// Try-Catch 1: segundos malos
		try {
			System.out.println("Modificando segundos...");
			hora1.setSegundos(-5);
		} catch (NegativeSecondException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 1

		// Try-Catch 2: minutos malos
		try {
			System.out.println("Modificando minutos...");
			hora1.setMinutos(-5);
		} catch (NegativeMinuteException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 2

		// Try-Catch 3: horas malas
		try {
			System.out.println("Modificando horas...");
			hora1.setHoras(-5);
		} catch (NegativeHourException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 3
		
		// Imprime la hora que no ha llegado a modificarse
		System.out.println(hora1.toString());

	}

}