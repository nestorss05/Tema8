package ejercicioB2_08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	// Define los colores ANSI a definir, como codigo de colores:
	public static final String ANSI_RED = "\u001B[31m"; // Operacion fallida
	public static final String ANSI_GREEN = "\u001B[32m"; // Operacion exitosa
	public static final String ANSI_BLUE = "\u001B[34m"; // Pregunta
	public static final String ANSI_CYAN = "\u001B[36m"; // Informacion
	public static final String ANSI_RESET = "\u001B[0m"; // Reseteo
	
	// Añade un objeto GestorRegistros
	public static GestorRegistros gr = new GestorRegistros();

	// Define el Scanner
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// int opcion: opcion elegida por el usuario
		int opcion = 0;

		// Do-While: el programa se ejecutara mientras que la opcion no sea 3
		do {

			// Muestra el menu
			mostrarMenu();

			// Try-catch: pide al usuario la opcion a elegir
			try {
				opcion = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_RED + "║     ERROR: respuesta invalida      ║" + ANSI_RESET);
				System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			} finally {
				sc.nextLine();
			} // Fin Try-Catch

			// Switch: segun la opcion seleccionada, se ejecutara cierta accion
			switch (opcion) {

			// Case 1: registra una nueva temperatura
			case 1 -> {
				pideFull();
			} // Fin Case 1

			// Case 2: muestra el historial de registro
			case 2 -> {
				gr.listarTabla();
				System.out.println("══════════════════════════════════════");
				System.out.println("Temperatura maxima absoluta: " + gr.tempMax());
				System.out.println("Temperatura minima absoluta: " + gr.tempMin());
				System.out.println("══════════════════════════════════════");
			} // Fin Case 2

			// Case 3: sal del programa
			case 3 -> {
				System.out.println(ANSI_CYAN + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_CYAN + "║        Cerrando programa...        ║" + ANSI_RESET);
				System.out.println(ANSI_CYAN + "╚════════════════════════════════════╝" + ANSI_RESET);
			} // Fin Case 3

			// Default: opcion invalida
			default -> {
				System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_RED + "║       ERROR: opcion invalida       ║" + ANSI_RESET);
				System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			} // Fin Default

			} // Fin Switch

		} while (opcion != 3); // Fin Do-While

		// Guarda los datos
		gr.guardar();

		// Cierra el Scanner
		sc.close();

	}

	/**
	 * Metodo mostrarMenu: muestra el menu
	 */
	private static void mostrarMenu() {
		System.out.println("╔════════════════════════════════════╗");
		System.out.println("║      Registro de temperaturas      ║");
		System.out.println("╠════════════════════════════════════╣");
		System.out.println("║   1. Registrar nueva temperatura   ║");
		System.out.println("║  2. Mostrar historial de registro  ║");
		System.out.println("║              3. Salir              ║");
		System.out.println("╠════════════════════════════════════╣");
		System.out.println("║          Elige una opcion          ║");
		System.out.println("╚════════════════════════════════════╝");
	}

	/**
	 * Metodo pideFull: pide al usuario los datos del registro a añadir
	 */
	private static void pideFull() {

		// String fecha: fecha del registro
		String fecha = "";

		// int tMax: temperatura maxima del registro
		int tMax;

		// int tMin: temperatura minima del registro
		int tMin;

		// boolean exitoso: indicador de como sale la insercion
		boolean exitoso;

		// Pide al usuario la fecha
		System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "║ Inserta una fecha para el registro ║" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
		fecha = sc.nextLine();

		// Try-Catch 1: Pide al usuario la temperatura maxima
		try {
			System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "║   Inserta una temperatura maxima   ║" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
			tMax = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║     ERROR: respuesta invalida      ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			tMax = 9000001;
		} finally {
			sc.nextLine();
		} // Fin Try-Catch 1

		// Try-Catch 2: Pide al usuario la temperatura minima
		try {
			System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "║   Inserta una temperatura minima   ║" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
			tMin = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║     ERROR: respuesta invalida      ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			tMin = -9000001;
		} finally {
			sc.nextLine();
		} // Fin Try-Catch 2
		
		// Añade el registro
		exitoso = gr.añadirRegistro(new Registros(fecha, tMax, tMin));
		
		// If-Else: segun si se ha podido añadir el registro o no, se mostrara cierto mensaje u otro
		if (exitoso) {
			System.out.println(ANSI_GREEN + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "║      Se ha podido insertar el      ║" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "║       registro exitosamente        ║" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "╚════════════════════════════════════╝" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║       ERROR: no se ha podido       ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "║        insertar el registro        ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
		} // Fin If-Else

	}

}