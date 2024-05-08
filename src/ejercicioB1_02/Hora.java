package ejercicioB1_02;

/**
 * Clase Hora
 * 
 * @author Nestor Sanchez
 */
public class Hora {

	/**
	 * hora: hora de la fecha
	 */
	private int hora;

	/**
	 * minuto: minuto de la fecha
	 */
	private int minuto;

	/**
	 * int segundos: segundos de la fecha
	 */
	private int segundos;

	/**
	 * Constructor con parametros
	 * 
	 * @param hora     hora de la fecha
	 * @param minutos  minutos de la fecha
	 * @param segundos segundos de la fecha
	 */
	public Hora(int hora, int minuto, int segundos) {

		// If 1: Se guaradaran las horas si es menor que 24
		if (hora < 23) {
			this.hora = hora;
		} // Fin If 1

		// If 2: Se guardaran los minutos si es menor que 60
		if (minuto < 60) {
			this.minuto = minuto;
		} // Fin If 2

		// If 3: Se guardaran los segundos si es menor que 60
		if (segundos < 60) {
			this.segundos = segundos;
		} // Fin If 3

	}

	/**
	 * void setSegundos: establece los segundos mediante un valor dado
	 * 
	 * @param valor valor a establecer
	 */
	public void setSegundos(int valor) throws NegativeSecondException {

		// If-Else: para establecer el valor, debe estar entre 0 y 59
		if (valor >= 0 && valor < 60) {
			segundos = valor;
		} else {
			throw new NegativeSecondException();
		} // Fin If-Else

	}
	
	/**
	 * void setMinutos: establece los minutos mediante un valor dado
	 * 
	 * @param valor valor a establecer
	 */
	public void setMinutos(int valor) throws NegativeMinuteException {

		// If-Else: para establecer el valor, debe estar entre 0 y 59
		if (valor >= 0 && valor < 60) {
			minuto = valor;
		} else {
			throw new NegativeMinuteException();
		} // Fin If-Else

	}

	/**
	 * void setHoras: establece la hora mediante un valor dado
	 * 
	 * @param valor valor a establecer
	 */
	public void setHoras(int valor) throws NegativeHourException {

		// If-Else: para establecer el valor, debe estar entre 0 y 23
		if (valor >= 0 && valor < 24) {
			hora = valor;
		} else {
			throw new NegativeHourException();
		} // Fin If-Else

	}

	/**
	 * toString: override de toString
	 * 
	 * @return hora completa
	 */
	public String toString() {

		// String texto: texto a mostrar por pantalla
		String texto = "";

		// If-Else 1: si hora es menor que 10, se mostrara un 0 atras de la hora.
		if (hora < 10) {
			texto += "0" + hora;
		} else {
			texto += "" + hora;
		} // Fin If-Else 1

		// If-Else 2: si minuto es menor que 10, se mostrara un 0 atras de la hora
		if (minuto < 10) {
			texto += ":0" + minuto;
		} else {
			texto += ":" + minuto;
		} // FIn If-Else 2

		// If-Else 3: revisa si segundos es menor que 10 y une todo hacia texto
		if (segundos < 10) {
			texto += ":0" + segundos;
		} else {
			texto += ":" + segundos;
		} // Fin If-Else 3

		// Devuelve texto al main
		return texto;
	}

}