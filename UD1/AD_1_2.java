import java.io.File;
import java.util.Date;

/*Construye un programa que a partir del directorio actual ofrezca al usuario toda 
 * la información posible sobre cada uno de los archivos y directorios que se encuentren
 * dentro del propio directorio actual. Es importante que el programa informe al
 *  usuario del tipo de archivos que va encontrando (si son directorios o no).*/

/**
 * 
 * @author Favila
 *
 */
public class AD_1_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Ficheros en el directorio actual: ");
		File f = new File(".");
		String[] archivos = f.list();

		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);// nombre
			File fich = new File(archivos[i]);
			
			if (fich.isDirectory()) {
				System.out.println("Es un directorio");
				// nombre
				System.out.println("\tNombre: " + fich.getName());
				
			} else {
				// nombre
				System.out.println("\tNombre: " + fich.getName());
				//Ultima modificacion
				Date d = new Date(fich.lastModified());//usamos la clase Date para que nos lo saque lejible
				System.out.println("\tUltima modificacion: " + d);
				// el fichero pesa?
				System.out.println("\tEspacio que ocupa: " + fich.length() + "bytes");
				// absulete path
				System.out.println("\tRuta absoluta: " + fich.getAbsolutePath());

			}

		}
	}
}

