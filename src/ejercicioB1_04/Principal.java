package ejercicioB1_04;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// String nombre: nombre del articulo a editar
		String nombre;

		// double price: precio del articulo a editar
		double price;

		// int stock: stock del articulo a editar
		int stock;

		// Articulo art: articulo a editar
		Articulo art = new Articulo("Vuelanhostias", 27543, 22);

		// Inicia el Scanner
		Scanner sc = new Scanner(System.in);

		// Try-Catch: Pide al usuario editar el nombre del articulo
		try {
			System.out.println("Inserta un nuevo nombre");
			nombre = sc.nextLine();
			art.setNombre(nombre);
		} catch (IllegalNameException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.nextLine();
		} // Fin Try-Catch

		// Try-Catch: Pide al usuario editar el precio del articulo
		try {
			System.out.println("Inserta un nuevo precio");
			price = sc.nextDouble();
			art.setPrecio(price);
		} catch (NegativePriceException e) {
			System.out.println(e.getMessage());
		} // Fin Try-Catch

		// Try-Catch: Pide al usuario editar el stock del articulo
		try {
			System.out.println("Inserta un nuevo stock");
			stock = sc.nextInt();
			art.setStock(stock);
		} catch (NegativeStockException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.nextLine();
		} // Fin Try-Catch
		
		// Muestra el articulo con todo lo que se ha podido modificar
		System.out.println(art.toString());
		
		// Cierra el Scanner
		sc.close();

	}

}