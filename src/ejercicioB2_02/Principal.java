package ejercicioB2_02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		// int suma: suma de los numeros del fichero
		int suma = 0;
		
		// int cont: contador para la media
		int cont = 0;
		
		// int media: media de los numeros
		int media = 0;
		
		// Inicia el Scanner
		Scanner sc = new Scanner(new FileReader("src/ejercicioB2_02/Enteros.txt"));
		
		// While: mientras que hayan numeros enteros:
		while (sc.hasNextInt()) {
			
			// Suma los numeros enteros
			suma += sc.nextInt();
			
			// Aumenta el contador en 1
			cont++;
			
		} // Fin While
		
		// media: divide la suma entre el contador
		media = suma / cont;
		
		// Muestra los datos por pantalla
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);
		
		// Cierra el Scanner
		sc.close();
		
	}

}