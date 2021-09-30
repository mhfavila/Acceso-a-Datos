import java.io.File;
import java.util.Date;

/*Haciendo uso del código de la actividad anterior, modifica el 
	 * programa para que además muestre información al usuario sobre 
	 * el número total de ficheros y directorios que se encuentran 
	 * dentro del directorio actual.*/

/**
 * 
 * @author Favila
 *
 */
	public class AD_1_3 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("Ficheros en el directorio actual: ");
			File f = new File(".");
			String[] archivos = f.list();
			int contFich=0;
			int contDirec=0;
			
			for (int i = 0; i < archivos.length; i++) {
				System.out.println(archivos[i]);// nombre
				File fich = new File(archivos[i]);

				if (fich.isDirectory()) {
					System.out.println("Es un directorio");
					// nombre
					System.out.println("\tNombre: " + fich.getName());
					contDirec=contDirec+1;//contador de directorio

				} else {
					contFich=contFich+1;//contador de ficheros
					// nombre
					System.out.println("\tNombre: " + fich.getName());
					// Ultima modificacion
					Date d = new Date(fich.lastModified());//usamos la clase Date para que nos lo saque lejible
					System.out.println("\tUltima modificacion: " + d);
					// el fichero pesa?
					System.out.println("\tEspacio que ocupa: " + fich.length() + "bytes");
					// absulete path
					System.out.println("\tRuta absoluta: " + fich.getAbsolutePath());

				}

			}
			System.out.println("El numero de Directorios es :"+contDirec);
			System.out.println("El numero de Ficheros es :"+contFich);
		}

	}

