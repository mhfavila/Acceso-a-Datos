import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * 10. Escribe un programa que permita leer un fichero hasta una determinada
 * cadena (por ejemplo “FIN”). Cuando llegue a ella el programa imprimirá todo
 * lo leído hasta ese momento y finalizará.
 */
public class AD_1_10 {
	//************************REVISAR NO FUNCIONA BIEN
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String ruta = "C:\\Users\\favil\\OneDrive\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		//String ruta = "C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\fichero.txt";
		File fichero = new File(ruta);
		String palabra = "FIN";
		BufferedReader BR = new BufferedReader (new FileReader(fichero));
		String linea = "";
		while((linea = BR.readLine())!= null){
			if(linea.indexOf(palabra)!= -1){
				System.out.println(linea);
			}else {
				System.out.println("no ha entrado");
			}
		}BR.close();
		
		
	}

}
