package ejercicioB2_05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// String nombre: nombre de un usuario
		String nombre;
		
		// int edad: edad de un usuario
		int edad;
		
		// Inicia el BufferedWriter
		BufferedWriter bw = null;
		
		// Inicia el Scanner
		Scanner sc = new Scanner(System.in);
		
		// Try-Catch A
		try {
			
			// Declara el BufferedWriter
			bw = new BufferedWriter(new FileWriter("src/ejercicioB2_05/datos.txt", true));
			
			// Pide al usuario un nombre
			System.out.println("Inserta un usuario");
			nombre = sc.nextLine();
			
			// Pide al usuario su edad
			System.out.println("Inserta la edad");
			edad = sc.nextInt();
			
			// Escribe el nombre y la edad del usuario
			bw.write(nombre + ", " + edad);
			
			// Haz un salto de linea
			bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: respuesta invalida");
		} finally {
			// Try-Catch B
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // Fin Try-Catch B
		} // Fin Try-Catch A
		
		// Cierra el Scanner
		sc.close();
		
	}

}