package ejercicioB2_04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		String cadena = "";
		
		BufferedWriter bf = new BufferedWriter(new FileWriter("src/ejercicioB2_04/Escribir.txt"));
		
		// Inicia el Scanner
		Scanner sc = new Scanner(System.in);
		
		// Do-While: manten el programa ejecutandose mientras que el texto insertado no sea fin
		do {
			
			// Pide al usuario una cadena
			System.out.println("Inserta un texto");
			cadena = sc.nextLine();
			
			// If: si cadena no es fin, escribela en el fichero
			if (!cadena.equals("fin")) {
				bf.write(cadena);
				bf.newLine();
			} // Fin If
			
		} while (!cadena.equals("fin")); // Fin Do-While
		
		// Limpia y cierra todo
		bf.flush();
		bf.close();
		sc.close();
		
	}

}