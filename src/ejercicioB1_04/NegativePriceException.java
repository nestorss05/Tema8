package ejercicioB1_04;

/**
 * Clase NegativePriceException
 * 
 * @author Nestor Sanchez
 */
@SuppressWarnings("serial")
public class NegativePriceException extends Exception {
	
	public String toString() {
		return "ERROR: precio invalido";
	}
	
	public String getMessage() {
		return "ERROR: precio invalido";
	}
	
}