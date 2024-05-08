package ejercicioB1_04;

/**
 * Clase Articulo
 * 
 * @author Nestor Sanchez
 */
public class Articulo {

	/**
	 * String nombre: nombre del articulo
	 */
	private String nombre;

	/**
	 * double precio: precio del articulo
	 */
	private double precio;

	/**
	 * int stock: cantidad de articulos que faltan en el stock
	 */
	private int stock;

	/**
	 * Constructor con parametros
	 * 
	 * @param nombre: nombre del articulo
	 * @param precio: precio del articulo
	 * @param stock:  cantidad de articulos que faltan en el stock
	 */
	public Articulo(String nombre, double precio, int cuantosQuedan) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = cuantosQuedan;
	}

	/**
	 * Funcion toString: imprime informacion del articulo
	 */
	public String toString() {
		String frase = "";
		frase += "Nombre del articulo: " + nombre;
		frase += "\nPrecio sin IVA: " + precio;
		frase += "\nStock: " + stock;
		return frase;
	}

	/**
	 * Setter setNombre
	 * @param nombre nombre del articulo
	 */
	public void setNombre(String nombre) throws IllegalNameException {
		if (nombre != null && !nombre.equals("")) {
			this.nombre = nombre;
		} else {
			throw new IllegalNameException();
		}
	}

	/**
	 * Setter setPrecio
	 * @param precio precio del articulo
	 */
	public void setPrecio(double precio) throws NegativePriceException {
		if (precio >= 0) {
			this.precio = precio;
		} else {
			throw new NegativePriceException();
		}
	}

	/**
	 * Setter setStock
	 * @param stock stock del articulo
	 */
	public void setStock(int stock) throws NegativeStockException {
		if (stock >= 0) {
			this.stock = stock;
		} else {
			throw new NegativeStockException();
		}
	}

}