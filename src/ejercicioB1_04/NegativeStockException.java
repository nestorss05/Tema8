package ejercicioB1_04;

/**
 * Clase NegativeStockException
 * 
 * @author Nestor Sanchez
 */
@SuppressWarnings("serial")
public class NegativeStockException extends Exception {

	public String toString() {
		return "ERROR: stock invalido";
	}
	
	public String getMessage() {
		return "ERROR: stock invalido";
	}
	
}