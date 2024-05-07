package ejercicioB1_01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// int numInt: numero entero
		int numInt;
		
		// double numDouble: numero double
		double numDouble;
		
		// Inicia el Scanner
		Scanner sc = new Scanner(System.in);
		
		// Ejecuta readInt
		numInt = Utils.readInt(sc);
		
		// Ejecuta readDouble
		numDouble = Utils.readDouble(sc);
		
		// Muestra los dos numeros por pantalla
		System.out.println("Numero entero: " + numInt);
		System.out.println("Numero double: " + numDouble);
		
		// Cierra el Scanner
		sc.close();
		
	}

}
