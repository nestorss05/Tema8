package ejercicioB1_03;

/**
 * Clase CuentaCorriente
 * 
 * @author Nestor Sanchez
 */
public class CuentaCorriente {

	/**
	 * String dni: DNI de la cuenta corriente
	 */
	private String dni;

	/**
	 * String nombre: nombre de la cuenta corriente
	 */
	private String nombre;

	/**
	 * String saldo: saldo de la cuenta corriente
	 */
	private double saldo;

	/**
	 * Constructor con parametros
	 * 
	 * @param dni       DNI de la cuenta corriente
	 * @param nombre    nombre de la cuenta corriente
	 * @param saldo     saldo de la cuenta corriente
	 */
	public CuentaCorriente(String dni, String nombre, double saldo) {
		if (dni != null && !dni.equals("")) {
			this.dni = dni;
		}
		if (nombre != null && !nombre.equals("")) {
			this.nombre = nombre;
		}
		if (saldo >= 0) {
			this.saldo = saldo;
		}
	}

	/**
	 * Setter setDni
	 * @param dni dni de la cuenta corriente
	 */
	public void setDni(String dni) throws IllegalDNIException {
		if (dni != "" && !dni.equals("")) {
			this.dni = dni;
		} else {
			throw new IllegalDNIException();
		}
	}

	/**
	 * Setter setNombre
	 * @param nombre nombre de la cuenta corriente
	 */
	public void setNombre(String nombre) throws IllegalNameException {
		if (nombre != "" && !nombre.equals("")) {
			this.nombre = nombre;
		} else {
			throw new IllegalNameException();
		}
	}

	/**
	 * Setter setSaldo
	 * @param saldo saldo de la cuenta corriente
	 */
	public void setSaldo(double saldo) throws NegativeSalaryException {
		if (saldo >= 0) {
			this.saldo = saldo;
		} else {
			throw new NegativeSalaryException();
		}
	}

}