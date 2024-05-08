package ejercicioB1_02;

/**
 * Clase NegativeMinuteException
 * 
 * @author Nestor Sanchez
 */

@SuppressWarnings("serial")
public class NegativeMinuteException extends Exception {
	
	public String toString() {
		return "ERROR: minuto incorrecto";
	}
	
	public String getMessage() {
		return "ERROR: minuto incorrecto";
	}
	
}