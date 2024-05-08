package ejercicioB1_03;

/**
 * Clase IllegalDNIException
 * 
 * @author Nestor Sanchez
 */
@SuppressWarnings("serial")
public class IllegalDNIException extends Exception {
	
	public String toString() {
		return "ERROR: DNI invalido";
	}
	
	public String getMessage() {
		return "ERROR: DNI invalido";
	}
	
}