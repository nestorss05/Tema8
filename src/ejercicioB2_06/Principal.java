package ejercicioB2_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// ArrayList numeros: lista de numeros
		ArrayList<Integer> numeros = new ArrayList<>();
		
		// Inicia el BufferedWriter
		BufferedWriter bw = null;
		
		// Inicia el Scanner
		Scanner sc = null;
		
		// Try-Catch 1
		try {
			
			// Establece el Scanner
			sc = new Scanner(new BufferedReader(new FileReader("src/ejercicioB2_06/recepcion.txt")));
		
			// While: mientras que haya mas lineas, ve insertandolas en el ArrayList
			while (sc.hasNextLine()) {
				numeros.add(Integer.parseInt(sc.nextLine()));
			} // Fin While
			
			// Muestra por pantalla que se ha podido leer el archivo
			System.out.println("El archivo se ha leido exitosamente");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Cierra el Scanner
			sc.close();
		} // Fin Try-Catch 1
		
		// Ordena el ArrayList
		Collections.sort(numeros);
		System.out.println("El archivo se ha ordenado exitosamente");
		
		// Try-Catch 2A
		try {
			
			// Establece el BufferedWriter
			bw = new BufferedWriter(new FileWriter("src/ejercicioB2_06/resultado.txt"));
			
			// Escribe los numeros en el archivo resultante
			bw.write(numeros.toString());
			
			// Muestra por pantalla que se ha podido escribir el archivo
			System.out.println("El archivo se ha escrito exitosamente");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			// Try-Catch 2B
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // Fin Try-Catch 2B
			
		} // Fin Try-Catch 2A
		
	}

}