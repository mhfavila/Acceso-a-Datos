import java.io.File;
import java.util.Date;

/*Escribe un programa que dibuje una especie de árbol de directorios del directorio actual (sólo los
directorios) y que para cada uno de ellos nos indique entre paréntesis el número de archivos que
contiene.*/
/**
 * 
 * @author Favila
 *
 */
public class AD_1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Ficheros en el directorio actual: ");
		File f = new File(".");//creamos 
		File[] archivos = f.listFiles();//creamos un array para guardar la lista de los ficheros
		recursionFicheros(archivos, 0);//llamamos al metodo de recursion
		
	}

	public static void sacarDatos(File fich, Integer profundidad) {//le pasamos los datos de fich y la profundidad
		String tabulaciones = "";//para los espacios que debe poner
		for (int i = 0; i < profundidad; i++) {
			tabulaciones = tabulaciones + "\t";
		}
		// nombre
		System.out.println(tabulaciones + fich.getName());
				//tamaño
				System.out.println("\t"+tabulaciones + fich.length()+"bytes");
				//fecha de modificacion
				Date d = new Date(fich.lastModified());//usamos la clase Date para que nos lo saque lejible
				System.out.println("\t"+tabulaciones+"Ultima modificacion: " + d);
		
	}


	public static void recursionFicheros(File[] archivos, Integer profundidad) {
		for (int i = 0; i < archivos.length; i++) {//dentro del array de archivos

			if (archivos[i].isDirectory()) {//si es un directorio
				
				File[] arrayFicheros = archivos[i].listFiles();//creamos un array para guardar la lista de  ficheros
				sacarDatos(archivos[i], profundidad);//sacamos los datos y la profundidad con el metodo sacarDatos
				System.out.print("\n");
				profundidad++;
				recursionFicheros(arrayFicheros, profundidad);//al ser un directorio volvemos a llamar a recursion para sacar lo que hay dentro de ese directorio
				profundidad--;
			} else {
				sacarDatos(archivos[i], profundidad);//sacamos los datos y la profundidad con el metodo sacarDatos
			}

		}

	}
}
