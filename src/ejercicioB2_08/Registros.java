package ejercicioB2_08;

import java.util.Objects;

/**
 * Clase Registros
 * 
 * @author Nestor Sanchez
 */
public class Registros {

	/**
	 * String fecha: fecha de un registro
	 */
	private String fecha;

	/**
	 * int tMax: temperatura maxima de un registro
	 */
	private int tMax;

	/**
	 * int tMin: temperatura minima de un registro
	 */
	private int tMin;

	/**
	 * Constructor Registros
	 * 
	 * @param fecha fecha de un registro
	 * @param tMax  temperatura maxima de un registro
	 * @param tMin  temperatura minima de un registro
	 */
	public Registros(String fecha, int tMax, int tMin) {

		if (validarFecha(fecha)) {
			this.fecha = fecha;
		}
		if (tMax >= tMin) {
			this.tMax = tMax;
		}
		if (tMin <= tMax) {
			this.tMin = tMin;
		}

	}

	/**
	 * Metodo validarFecha: metodo que comprueba la validez de una fecha
	 * 
	 * @param fecha fecha a analizar
	 * @return si la fecha es valida o no
	 */
	private boolean validarFecha(String fecha) {

		// boolean isTrue: comprobante de si la fecha es valida o no
		boolean isTrue = false;

		// int dias: dias de la fecha
		int dias = 0;

		// int mes: mes de la fecha
		int mes = 0;

		// int anio: anio de la fecha
		int anio = 0;

		// If: Valida los dias
		if (validarNumero(fecha, 1)) {
			dias = Integer.parseInt(fecha.substring(8, 10));
		} // Fin If

		// If: Valida el mes
		if (validarNumero(fecha, 2)) {
			mes = Integer.parseInt(fecha.substring(5, 7));
		} // Fin If

		// If: Valida el anio
		if (validarNumero(fecha, 3)) {
			anio = Integer.parseInt(fecha.substring(0, 4));
		} // Fin If

		// If: si la fecha no es vacia, o esta en el formato 0000-00-00 o sus fechas
		// sean validas, isTrue sera valido
		if (fecha != null && !fecha.equals("") && fecha.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") && dias >= 1 && dias <= 31
				&& mes >= 1 && mes <= 12 && anio >= 1901) {
			isTrue = true;
		} // Fin If

		// Devuelve isTrue
		return isTrue;

	}

	/**
	 * Metodo validarNumero: valida un numero de la fecha
	 * 
	 * @param fecha  fecha del que se sacara el dia, el mes o el anio
	 * @param opcion opcion elegida
	 * @return si el numero es valido o no
	 */
	private boolean validarNumero(String fecha, int opcion) {

		// boolean numValido: comprobante de si un numero es valido o no
		boolean numValido = false;

		// int dias: dias de la fecha
		try {

			// Switch: por cada opcion, se analizara cierta zona de la puerta
			switch (opcion) {

			// Case 1: analiza el dia
			case 1 -> {
				Integer.parseInt(fecha.substring(8, 10));
			} // Fin Case 1

			// Case 2: analiza el mes
			case 2 -> {
				Integer.parseInt(fecha.substring(5, 7));
			} // Fin Case 2

			// Case 3: analiza el anio
			case 3 -> {
				Integer.parseInt(fecha.substring(0, 4));
			} // Fin Case 3

			} // Fin Switch

			// numValido pasa a ser true
			numValido = true;

		} catch (NumberFormatException e) {

			// Muestra un mensaje de error
			System.out.println(Principal.ANSI_RED + "╔════════════════════════════════════╗" + Principal.ANSI_RESET);
			System.out.println(Principal.ANSI_RED + "║       ERROR: numero invalido       ║" + Principal.ANSI_RESET);
			System.out.println(Principal.ANSI_RED + "╚════════════════════════════════════╝" + Principal.ANSI_RESET);

		} // Fin Try-Catch

		// Devuelve numValido
		return numValido;

	}

	/**
	 * Getter getFecha
	 * 
	 * @return fecha de un registro
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Getter gettMax
	 * 
	 * @return temperatura maxima de un registro
	 */
	public int gettMax() {
		return tMax;
	}

	/**
	 * Getter gettMin
	 * 
	 * @return temperatura minima de un registro
	 */
	public int gettMin() {
		return tMin;
	}

	/**
	 * Metodo toString: muestra por pantalla la informacion de cada dato registrado
	 */
	@Override
	public String toString() {
		String frase = "";
		frase += "══════════════════════════════════════\n";
		frase += "Fecha: " + fecha + "\n";
		frase += "T. max: " + tMax + "\n";
		frase += "T. min: " + tMin + "\n";
		frase += "══════════════════════════════════════\n";
		return frase;
	}

	/**
	 * Metodo equals: compara dos registros a base de su nombre
	 */
	@Override
	public boolean equals(Object obj) {
		Registros registro2 = (Registros) obj;
		boolean sonIguales = Objects.equals(fecha, registro2.fecha);
		return sonIguales;
	}

}