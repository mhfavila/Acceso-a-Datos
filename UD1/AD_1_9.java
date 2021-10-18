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
/*A partir del primer ejemplo en los apuntes de lectura de ficheros de texto, escribe un programa en
java que haga lo lea caracteres de X en X, siendo X un número entre 4 y 10 introducido por el
usuario (para almacenar las lecturas de X caracteres tendréis que crear un array de tamaño X y del
tipo correspondiente para guardar caracteres).
 * */
public class AD_1_9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//********************************REVISAR NO FUNCIONA BIEN
		System.out.println("Cuantos caracteres quieres leer :");
		int caracter=0;
		Scanner sc = new Scanner(System.in);
		caracter= sc.nextInt();
		char[] caracteres = null;
		String ruta = "C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		//String ruta = "C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		File fichero = new File(ruta);
		FileReader fic = new FileReader(fichero);
		
		int i;
		while((i = fic.read()) !=-1)
			System.out.println(i);
			//System.out.print((char) i);
		fic.close();
		

	}

}
