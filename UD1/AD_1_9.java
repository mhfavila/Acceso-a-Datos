import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * A partir del primer ejemplo en los apuntes de lectura de ficheros de texto,
 * escribe un programa en java que haga lo lea caracteres de X en X, siendo X un
 * número entre 4 y 10 introducido por el usuario (para almacenar las lecturas
 * de X caracteres tendréis que crear un array de tamaño X y del tipo
 * correspondiente para guardar caracteres).
 */
public class AD_1_9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File fichero = new File(
				"C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt");
		FileReader fic = new FileReader(fichero);

		int nCaracteres;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el numero de caracteres: ");
		nCaracteres = sc.nextInt();

		char[] c = new char[nCaracteres];// guardamos en un array el valor de los caracteres
		int i;
		int contador = 0;
		while ((i = fic.read()) != -1) {// leemos el archivo
			if (contador == nCaracteres) {
				// cuando el contador sea igual a la los caracteres se sale del bucle
				break;
			}
			fic.skip(nCaracteres);// se saltan los carracteres
			c[contador] = (char) i;
			contador++;
		}

		fic.close();
		System.out.print(c);
	}

}
