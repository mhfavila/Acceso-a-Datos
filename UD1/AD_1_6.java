import java.io.File;
import java.util.Scanner;
/*Crea un programa que borre un determinado fichero solicitado al usuario por consola*/
/**
 * 
 * @author FAVILA
 *
 */
public class AD_1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);//clase escaner para poder cojer por teclado
		System.out.println("Introduce la ruta del archivo");//pedimos la ruta
		//C:\Users\ALUMNO\Documents\GitHub\2DAM-REP\ACCESO A DATOS\T_1\src\DIR_1\fichero1.txt
		String ruta = sc.nextLine();
		
		File f = new File(ruta);//creamos la clse f que sera el archivo que hemos buscado con la ruta
		
		if(f.exists()) {
			f.delete();//si el archivo existe se borra
			System.out.println("El archivp se a borrado");
			
		}
		else {
			System.out.println("Ese archivo no existe");
		}
		

	}

}
