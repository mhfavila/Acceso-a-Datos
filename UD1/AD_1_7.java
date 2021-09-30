import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Favila
 *
 */
/*
 * Escribe un programa en java que haga lo siguiente: 
 * a. Debe acceder a un fichero de texto “nombres.txt” que almacenará nombre de personas. 
 * b. Debe leer los caracteres entre las posiciones 10 y 15 incluidas. 
 * c. Por último, a partir de la posición 20 añadirá la cadena “holamundo” al fichero.
 */
public class AD_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\nombres.txt
		File archivo = new File("C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\nombres.txt");
		// FileReader fr = new FileReader(archivo);//lo utilizamos para poder leer lo
		// que hay en el archivo de la ruta que le hemos pasado
		// BufferedReader br = new BufferedReader(fr);//se usa para pode leer lineas completas en un archivo

		try {
			RandomAccessFile fic = new RandomAccessFile(archivo, "rw");//Creamos una secuencia de archivos de acceso aleatorio para leer y escribir en el archivo especificado en file
			try {
				fic.seek(10);//sirve para mover el puntero dentro del archivo a la posicicion que queramos
				for(int i =0;i<5;i++) {//para recorer esas letras de la 10 a la 15
					char c =(char) fic.read();//guardamos las letras leidas en c
					System.out.println(c);
					
				}
				fic.seek(20);//colocamos el puntero en la posicion ,dentro del archivo de texto,donde queremos escribir 
				String hola = "holamundo";
				fic.write(hola.getBytes());//se le pasa la cadena que queremos escribir en el archivo
				fic.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
