package ejercicioB1_01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Utils
 * 
 * @author Nestor Sanchez
 */
public class Utils {

	/**
	 * Funcion readInt: lee un numero entero y analizalo
	 * 
	 * @param sc objeto Scanner
	 * @return numero entero
	 */
	public static int readInt(Scanner sc) {
		
		// int numeroInt: numero entero
		int numeroInt;
		
		// Try-Catch: pide al usuario un numero entero
		System.out.println("Inserta un numero entero");
		try {
			numeroInt = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("El valor introducido no es de tipo int");
			numeroInt = 0;
		} finally {
			sc.nextLine();
		} // Fin Try-Catch
		
		// Devuelve numeroInt
		return numeroInt;
	}

	/**
	 * Funcion readDouble: lee un numero double y analizalo
	 * 
	 * @param sc objeto Scanner
	 * @return numero double
	 */
	public static double readDouble(Scanner sc) {
		
		// double numeroDouble: numero double
		double numeroDouble;
		
		// Try-Catch: pide al usuario un numero double
		System.out.println("Inserta un numero double");
		try {
			numeroDouble = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("El valor introducido no es de tipo double");
			numeroDouble = 0;
		} finally {
			sc.nextLine();
		} // Fin Try-Catch
		
		// Devuelve numeroDouble
		return numeroDouble;
	}

}