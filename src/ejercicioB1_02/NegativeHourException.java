package ejercicioB1_02;

/**
 * Clase NegativeHourException
 * 
 * @author Nestor Sanchez
 */

@SuppressWarnings("serial")
public class NegativeHourException extends Exception {
	
	public String toString() {
		return "ERROR: hora incorrecta";
	}
	
	public String getMessage() {
		return "ERROR: hora incorrecta";
	}
	
}