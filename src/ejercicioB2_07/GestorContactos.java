package ejercicioB2_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Clase GestorContactos
 * 
 * @author Nestor Sanchez
 */
public class GestorContactos {

	/**
	 * ArrayList contactos: lista de contactos
	 */
	public TreeMap<String, Integer> contactos = new TreeMap<>();

	/**
	 * BufferedReader br: encargado de leer datos del fichero datosContactos.txt
	 */
	private static BufferedReader br;

	/**
	 * BufferedWriter wr: encargado de escribir datos en el fichero
	 * datosContactos.txt
	 */
	private static BufferedWriter wr;

	/**
	 * Constructor vacio
	 */
	public GestorContactos() {
		preparar();
	}

	/**
	 * Metodo preparar: si hay datos guardados, se cargaran en memoria
	 */
	public void preparar() {

		// String linea: linea analizada por BufferedReader
		String linea;

		// String[] contactosTemp: array temporal de la linea analizada
		String[] contactosTemp;

		// Try-Catch: ve insertando los contactos al ArrayList
		try {
			br = new BufferedReader(new FileReader("src/ejercicioB2_07/datosContactos.txt"));
			while ((linea = br.readLine()) != null) {
				contactosTemp = linea.split("::");
				String nombre = contactosTemp[0];
				int numero = Integer.parseInt(contactosTemp[1]);
				contactos.put(nombre, numero);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Fin Try-Catch

	}

	/**
	 * Metodo listarContactos: recorre el TreeMap y lista todos los contactos
	 */
	public void listarContactos() {
		String mensaje;
		for (Map.Entry<String, Integer> contacto : contactos.entrySet()) {
			mensaje = "";
			mensaje += "══════════════════════════════════════\n";
			mensaje += "Contacto: " + contacto.getKey() + "\n";
			mensaje += "Telefono: " + contacto.getValue() + "\n";
			mensaje += "══════════════════════════════════════\n";
			System.out.println(mensaje);
		}
	}

	/**
	 * Metodo añadirContacto: añade un contacto
	 * 
	 * @param nombre nombre del contacto a añadir
	 * @param numero numero del contacto a añadir
	 * @return si se ha podido añadir el contacto o no
	 */
	public boolean añadirContacto(String nombre, int numero) {

		// boolean exitoso: comprobante de como sale la insercion
		boolean exitoso = false;

		// If: si el nombre no es nulo ni campo vacio, el telefono es valido y no hay
		// mas de 20 contactos registrados, se insertara el contacto
		if (nombre != null && !nombre.equals("") && numero >= 0 && contactos.size() < 20 && !contactos.containsKey(nombre)) {
			contactos.put(nombre, numero);
			exitoso = true;
		} // Fin If

		// Devuelve exitoso
		return exitoso;

	}

	/**
	 * Metodo buscarContacto: busca un contacto a base de su nombre
	 * 
	 * @param nombre nombre del contacto a buscar
	 * @return telefono recuperado
	 */
	public int buscarContacto(String nombre) {

		// int telefono: telefono a recuperar
		int telefono = -1;

		// Set keySets: lista de claves de contactos
		Set<String> keySets = contactos.keySet();

		// int i: indice del ArrayList
		int i = 0;

		// While: recorre el array alContactos
		while (i < contactos.size()) {

			// If: si el nombre del contacto es igual al nombre insertado, se recuperara el
			// telefono en cuestion y se saldra del bucle
			if (keySets.contains(nombre)) {
				telefono = contactos.get(nombre);
				break;
			} // Fin If

			// Aumenta i en 1
			i++;

		} // Fin While

		// Devuelve telefono
		return telefono;

	}

	/**
	 * Metodo guardar: guarda los contactos en datosContactos.txt
	 */
	public void guardar() {

		// Try-Catch: guarda los contactos en el fichero
		try {

			// Inicia el BufferedWriter
			wr = new BufferedWriter(new FileWriter("src/ejercicioB2_07/datosContactos.txt"));

			// For-Each: recorre la lista de contactos y guardalo en datosContactos.txt
			for (Map.Entry<String, Integer> contacto : contactos.entrySet()) {
				wr.write(contacto.getKey() + "::" + contacto.getValue());
				wr.newLine();
			} // Fin For-Each
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			// Try-Catch 2: cierra el Writer
			try {
				wr.flush();
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // Fin Try-Catcher 2

		} // Fin Try-Catch

	}

}