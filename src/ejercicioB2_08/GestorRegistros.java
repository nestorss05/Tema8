package ejercicioB2_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase GestorRegistros
 * 
 * @author Nestor Sanchez
 */
public class GestorRegistros {

	/**
	 * ArrayList listaRegistros: ArrayList que contiene todos los registros
	 */
	private ArrayList<Registros> listaRegistros = new ArrayList<>();

	/**
	 * BufferedReader br: encargado de leer datos del fichero datosTemperaturas.txt
	 */
	private static BufferedReader br;

	/**
	 * BufferedWriter bw: encargado de escribir datos en el fichero
	 * datosTemperaturas.txt
	 */
	private static BufferedWriter bw;

	/**
	 * Constructor vacio
	 */
	public GestorRegistros() {
		preparar();
	}

	/**
	 * Metodo preparar(): pasa los archivos de datosTemperaturas.txt al ArrayList
	 */
	private void preparar() {

		// String linea: linea leida por BufferedReader
		String linea;

		// String[] palabras: array temporal de palabras separadas por coma
		String[] palabras;

		// String fecha: fecha sacada de la linea del documento
		String fecha;

		// int tMax: temperatura maxima sacada de la linea del documento
		int tMax;

		// int tMin: temperatura minima sacada de la linea del documento
		int tMin;

		// Try-Catch: lee el fichero y de ahi inserta sus datos en el ArrayList
		try {

			// Abre el BufferedReader
			br = new BufferedReader(new FileReader("src/ejercicioB2_08/datosTemperaturas.txt"));

			// While: lee todas las lineas del fichero hasta acabarlo
			while ((linea = br.readLine()) != null) {

				// Divide las palabras por comas y pasala al array palabras
				palabras = linea.split(",");

				// Fecha sera el indice 0 de palabras
				fecha = palabras[0];

				// tMax sera el indice 1 de palabras
				tMax = Integer.parseInt(palabras[1]);

				// tMin sera el indice 2 de palabras
				tMin = Integer.parseInt(palabras[2]);

				// Añade el nuevo registro
				listaRegistros.add(new Registros(fecha, tMax, tMin));

			} // Fin While

			// Cierra el BufferedReader
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Fin Try-Catch

	}

	/**
	 * Metodo listarTabla(): lista la tabla de registros por pantalla
	 */
	public void listarTabla() {
		for (Registros registro : listaRegistros) {
			System.out.println(registro.toString());
		}
	}

	/**
	 * Metodo tempMax(): saca la temperatura mas alta de todos los registros
	 * 
	 * @return temperatura mas alta de todos los registros
	 */
	public int tempMax() {

		// int absoluteMax: temperatura mas alta de todas
		int absoluteMax = -9000000;

		// For-Each: recorre el ArrayList y analiza las temperaturas maximas
		for (Registros registro : listaRegistros) {
			if (registro.gettMax() >= absoluteMax) {
				absoluteMax = registro.gettMax();
			}
		} // Fin For-Each

		// Devuelve absoluteMax
		return absoluteMax;

	}

	/**
	 * Metodo tempMin(): saca la temperatura mas baja de todos los registros
	 * 
	 * @return temperatura mas alta de todos los registros
	 */
	public int tempMin() {

		// int absoluteMin: temperatura mas baja de todos los registros
		int absoluteMin = 9000000;

		// For-Each: recorre el ArrayList y analiza las temperaturas minimas
		for (Registros registro : listaRegistros) {
			if (registro.gettMin() <= absoluteMin) {
				absoluteMin = registro.gettMin();
			}
		} // Fin For-Each

		// Devuelve absolutein
		return absoluteMin;

	}

	/**
	 * Metodo añadirRegistro: añade un registro al ArrayList
	 * 
	 * @param reg registro a añadir
	 * @return si se ha podido añadir el registro o no
	 */
	public boolean añadirRegistro(Registros reg) {

		// boolean añadido: indicador de si se ha podido añadir el registro o no
		boolean añadido = false;

		// If: si los tres parametros de reg son validos, añade reg al ArrayList
		if (reg.gettMax() != 9000001 && reg.gettMin() != -9000001 && reg.getFecha() != null) {
			listaRegistros.add(reg);
			añadido = true;
		} // Fin If

		// Devuelve añadido
		return añadido;

	}
	
	/**
	 * Metodo guardar: guarda los datos del ArrayList en el fichero datosTemperaturas.txt
	 */
	public void guardar() {
		
		// Try-Catch 1: guarda los datos en el fichero datosTemperaturas.txt
		try {
			
			// Inicia el BufferedWriter
			bw = new BufferedWriter(new FileWriter("src/ejercicioB2_08/datosTemperaturas.txt"));
			
			// For-Each: recorre el ArrayList y guarda cada linea en datosTemperaturas.txt
			for (Registros reg : listaRegistros) {
				bw.write(reg.getFecha()+","+reg.gettMax()+","+reg.gettMin());
				bw.newLine();
			} // Fin For-Each
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			// Try-Catch 2: limpia y cierra el BufferedWriter
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // Fin Try-Catch 2
			
		} // Fin Try-Catch 1
		
	}

}