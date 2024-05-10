package ejercicioB2_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Inicia el Scanner
		Scanner sc = new Scanner(new BufferedReader(new FileReader("src/ejercicioB2_03/Alumnos.txt")));
		
		// While: mientras que haya mas lineas, ve imprimiendolas
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		} // Fin While
		
		// Cierra el Scanner
		sc.close();
		
	}

}