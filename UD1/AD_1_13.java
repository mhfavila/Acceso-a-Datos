import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * Elabora un programa en java que permita copiar el contenido de un fichero de
 * texto en otro (el nuevo fichero será creado por el programa). Si el fichero
 * de destino ya existe deberá mostrarse un aviso al usuario para que decida si
 * quiere eliminarlo y crear uno nuevo o desea cancelar la ejecución del
 * programa.
 */
public class AD_1_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String rutaLeer;
		String rutaCopiar;
		System.out.println("Introduce la ruta del archivo que quieres leer");
		String nLeer = sc.nextLine();
		rutaLeer = "C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\"+nLeer+".txt";
		System.out.println("Introdcue el nombre del nuevo fichero");
		String nombre = sc.nextLine();
		rutaCopiar = "C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\"+nombre+".txt";
		File copia = new File(rutaCopiar);
		File leectura = new File(rutaLeer);
		if(!copia.exists()) {
			try {
				copia.createNewFile();
				System.out.println("YA SE A creado");
				copiaContenidoFicheros(leectura,copia);
				System.out.println("YA SE A COPIADO");
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero ya existe");
			System.out.println("que quiere hacer ");
			System.out.println("1.Eliminar ");
			System.out.println("Cancelar ejecucucion ");
			int opcion=sc.nextInt();
			if(opcion==1) {
				copia.deleteOnExit();
				System.out.println("ELIMINADO");
				try {
					copia.createNewFile();
					System.out.println("creado");
					copiaContenidoFicheros(leectura,copia);
					System.out.println("YA SE A COPIADO");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println("Cancelado");
			}
			
		}
	}
	/**
	 * sirve para copiar el contenido de un fichero en otro
	 * @param leer le pasamos el archivo que quetemos leer
	 * @param copia el archivo donde lo tiene que copiar
	 * @throws IOException
	 */
	public static void copiaContenidoFicheros(File leer, File copia) throws IOException {
		FileReader fic = new FileReader(leer);
		FileWriter foc = new FileWriter(copia);
		int i;
		while((i = fic.read()) != -1) {
			//System.out.print((char) i);
			foc.write(i);
			
		}
		fic.close();
		foc.close();
	}

}
