package ejercicioB1_03;

/**
 * Clase IllegalNameException
 * 
 * @author Nestor Sanchez
 */
@SuppressWarnings("serial")
public class IllegalNameException extends Exception {
	
	public String toString() {
		return "ERROR: nombre invalido";
	}
	
	public String getMessage() {
		return "ERROR: nombre invalido";
	}
	
}