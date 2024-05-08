package ejercicioB1_03;

/**
 * Clase NegativeSalaryException
 * 
 * @author Nestor Sanchez
 */
@SuppressWarnings("serial")
public class NegativeSalaryException extends Exception {
	
	public String toString() {
		return "ERROR: salario invalido";
	}
	
	public String getMessage() {
		return "ERROR: salario invalido";
	}
	
}