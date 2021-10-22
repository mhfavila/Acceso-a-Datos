import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */

/*
 * Escribe un programa en Java que permita escribir en un fichero cadenas
 * pedidas por consola el usuario hasta que introduzca una cadena determinada
 * (por ejemplo “FIN”).
 */
public class AD_1_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String cadena = " ";
		String fin = "FIN";
		String ruta =  "C:\\Users\\favil\\OneDrive\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
				//"C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		//String ruta = "C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		 BufferedWriter br = null;
	        try {
	            br = new BufferedWriter(new FileWriter(ruta));//creamos el bufer para poder escribir en el archivo
	            while(!(cadena.equals(fin))) {//mientras que las cadenas sean distintas del contenido de la cadena fin
	            	System.out.println("introduce la cadena");
	            	cadena = sc.nextLine();
	            	br.write(cadena);//escribimos la cadena en el archivo
	            }
	            br.close();//se cierra el buffer
	            
	        } catch (IOException e) {
	            System.out.println("Exception occurred: " + e.getMessage());

	        
	        }
	}

}
