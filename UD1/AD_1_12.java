import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * Dado que la clase FileReader no dispone de m�todos para leer l�neas
 * completas, investiga sobre el uso de la clase BufferedReader, que s� que
 * tiene un m�todo denominado readLine() y que sirve para leer l�neas de un
 * fichero. Elabora un programa que, dado un n�mero N y un fichero (ambos datos
 * se piden por consola al usuario), lea las primeras N l�neas del fichero. En
 * caso de que el fichero tenga menos l�neas debe avisar al usuario. Tambi�n
 * debe informar por pantalla del n�mero de l�nea que va leyendo.
 * 
 */
public class AD_1_12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// *******************************REVISAR NO FUNCIONA BIEN

		// C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A
		// DATOS\\T_1\\src\\texto.txt

		int nLineas;

		Scanner sc = new Scanner(System.in);
		

		System.out.print("Introduce el fichero que quieres leer: ");
		String opcion = sc.nextLine();
		BufferedReader fichero = new BufferedReader(new FileReader(
				"C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\" + opcion + ".txt"));

		System.out.print("Introduce el numero de lineas que quieres leer: ");
		nLineas = sc.nextInt();
		int contador = 0;
		if (contarLineas(opcion, nLineas)) {

			String linea = fichero.readLine();

			while (linea != null) {

				if (contador == nLineas) {
					break;
				}

				System.out.println((contador + 1) + linea);
				linea = fichero.readLine();
				contador++;

			}

			fichero.close();

		} else {
			System.out.println("no hay esas lineas en el fichero");
		}
	}

	/**
	 * 
	 * @param ruta  le pasamos la ruta del archivo que hay q leer
	 * @param linea el numero de lineas q quiere leer
	 * @return
	 * @throws IOException
	 */
	public static boolean contarLineas(String ruta, int linea) throws IOException {

		BufferedReader fichero = new BufferedReader(new FileReader(ruta + ".txt"));

		String lineas = fichero.readLine();

		int contarLineas = 0;

		while (lineas != null) {
			lineas = fichero.readLine();
			contarLineas++;
		}

		if (linea > contarLineas) {
			return false;
		}
		return true;
	}
}
