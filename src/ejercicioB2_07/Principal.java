package ejercicioB2_07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	// Define los colores ANSI a definir, como codigo de colores:
	public static final String ANSI_RED = "\u001B[31m"; // Errores
	public static final String ANSI_GREEN = "\u001B[32m"; // Informacion
	public static final String ANSI_BLUE = "\u001B[34m"; // Preguntas
	public static final String ANSI_RESET = "\u001B[0m"; // Reseteo

	// Define el Scanner
	public static Scanner sc = new Scanner(System.in);
	
	// GestorContactos gc: crea un nuevo objeto GestorContactos
	public static GestorContactos gc = new GestorContactos();

	public static void main(String[] args) {

		// int opcion: opcion elegida por el usuario
		int opcion = 0;

		// Do-While: el programa se ejecutara mientras que la opcion no sea 4
		do {

			// Muestra el menu y pide al usuario una opcion
			mostrarMenu();
			try {
				opcion = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_RED + "║     ERROR: respuesta invalida      ║" + ANSI_RESET);
				System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			} finally {
				sc.nextLine();
			} // Fin Try-Catch

			// Switch: por cada opcion, se hara cierta accion
			switch (opcion) {

			// Case 1: nuevo contacto
			case 1 -> {
				pideNuevo();
			} // Fin Case 1

			// Case 2: buscar contacto por nombre
			case 2 -> {
				pideNombre();
			} // Fin Case 2

			// Case 3: lista los contactos
			case 3 -> {
				gc.listarContactos();
			} // Fin Case 3

			// Case 4: Muestra un mensaje cerrando el programa
			case 4 -> {
				System.out.println(ANSI_GREEN + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "║        Cerrando programa...        ║" + ANSI_RESET);
				System.out.println(ANSI_GREEN + "╚════════════════════════════════════╝" + ANSI_RESET);
			} // Fin Case 4

			// Default: opcion invalida
			default -> {
				System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
				System.out.println(ANSI_RED + "║       ERROR: opcion invalida       ║" + ANSI_RESET);
				System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
			} // Fin Default

			} // Fin Switch

		} while (opcion != 4); // Fin Do-While

		// Guarda los archivos
		gc.guardar();

		// Cierra el Scanner
		sc.close();

	}

	/**
	 * Funcion que muestra el menu
	 */
	private static void mostrarMenu() {
		System.out.println("╔════════════════════════════════════╗");
		System.out.println("║               Agenda               ║");
		System.out.println("╠════════════════════════════════════╣");
		System.out.println("║         1. Nuevo contacto          ║");
		System.out.println("║        2. Buscar por nombre        ║");
		System.out.println("║          3. Mostrar todos          ║");
		System.out.println("║              4. Salir              ║");
		System.out.println("╠════════════════════════════════════╣");
		System.out.println("║          Elige una opcion          ║");
		System.out.println("╚════════════════════════════════════╝");
	}

	/**
	 * Funcion pideNuevo(): pide un contacto nuevo
	 */
	private static void pideNuevo() {

		// int numero: numero de telefono del contacto
		int numero = 0;

		// String nombre: nombre del contacto
		String nombre = "";

		// boolean exitoso: indicador de como salen las operaciones
		boolean exitoso;

		// Pide al usuario un nombre para el contacto
		System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "║ Inserta un nombre para el contacto ║" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
		nombre = sc.nextLine();

		// Pide al usuario un numero de telefono
		try {
			System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "║    Inserta un numero de telefono   ║" + ANSI_RESET);
			System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
			numero = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║     ERROR: respuesta invalida      ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
		} finally {
			sc.nextLine();
		}

		// Añade el contacto
		exitoso = gc.añadirContacto(nombre, numero);

		// If-Else: informa al usuario si la insercion ha salido bien o no
		if (exitoso) {
			System.out.println(ANSI_GREEN + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "║      Se ha podido insertar al      ║" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "║       contacto exitosamente        ║" + ANSI_RESET);
			System.out.println(ANSI_GREEN + "╚════════════════════════════════════╝" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║       ERROR: no se ha podido       ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "║        insertar el contacto        ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
		} // Fin If-Else
		
	}
	
	/**
	 * Funcion pideNuevo(): pide un contacto nuevo
	 */
	private static void pideNombre() {

		// String nombre: nombre del contacto
		String nombre = "";
		
		// int telefono: telefono recuperado del contacot
		int telefono;

		// Pide al usuario un nombre para el contacto
		System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "║   Inserta el nombre del contacto   ║" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
		nombre = sc.nextLine();

		// Busca el contacto
		telefono = gc.buscarContacto(nombre);

		// If-Else: informa al usuario si la insercion ha salido bien o no
		if (telefono >= 0) {
			System.out.println(telefono);
		} else {
			System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
			System.out.println(ANSI_RED + "║       ERROR: no se ha podido       ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "║       encontrar el contacto        ║" + ANSI_RESET);
			System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
		} // Fin If-Else
		
	}

}