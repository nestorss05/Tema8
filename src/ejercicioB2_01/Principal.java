package ejercicioB2_01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		// int suma: suma de los numeros del fichero
		int suma = 0;
		
		// int numero: numero de cada string
		int numero;
		
		// String numerosUnidos: frase recogida del fichero
		String numerosUnidos = "";
		
		// String numerosString: array de numeros en String
		String[] numerosString;
		
		// Try-catch: añade el FileReader
		try {
			
			// Abre el FileReader
			FileReader in = new FileReader("src/ejercicioB2_01/NumerosReales.txt");
			
			// Abre el BufferedReader
			BufferedReader bf = new BufferedReader(in);
			
			// Guarda la linea en numerosUnidos
			numerosUnidos = bf.readLine();
			
			// Cierra el BufferedReader
			bf.close();
			
			// Cierra el FileReader
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Fin Try-Catch
		
		// Divide numerosUnidos y quitale su espacio
		numerosString = numerosUnidos.split(" ");
		
		// For-Each: Muestra la suma de los numeros
		for (String numString : numerosString) {
			
			// Haz un parseInt a numString para guardarlo en numero
			numero = Integer.parseInt(numString);
			
			// Suma el numero a la suma
			suma += numero;
			
		} // Fin For-Each
		
		// Muestra la suma por pantalla
		System.out.println(suma);
		
	}

}