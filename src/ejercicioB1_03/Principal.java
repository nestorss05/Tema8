package ejercicioB1_03;

public class Principal {

	public static void main(String[] args) {

		// CuentaCorriente cc: cuenta corriente a la que intentar aplicar los cambios
		CuentaCorriente cc = new CuentaCorriente("000A", "Eusebio", 0);

		// Try-Catch 1: DNI a null
		try {
			System.out.println("Estableciendo DNI...");
			cc.setDni("");
		} catch (IllegalDNIException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 1

		// Try-Catch 2: nombre a null
		try {
			System.out.println("Estableciendo nombre...");
			cc.setNombre("");
		} catch (IllegalNameException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 2

		// Try-Catch 3: salario negativo
		try {
			System.out.println("Estableciendo salario...");
			cc.setSaldo(-555);
		} catch (NegativeSalaryException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch 3

	}

}