import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * Dado que la clase FileReader no dispone de m�todos para leer l�neas
 * completas, investiga sobre el uso de la clase BufferedReader, que s� que
 * tiene un m�todo denominado readLine() y que sirve para leer l�neas de un
 * fichero. Elabora un programa que, dado un n�mero N y un fichero (ambos datos
 * se piden por consola al usuario), lea las primeras N l�neas del fichero. En
 * caso de que el fichero tenga menos l�neas debe avisar al usuario. Tambi�n
 * debe informar por pantalla del n�mero de l�nea que va leyendo.
 * 
 */
public class AD_1_12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//*******************************REVISAR NO FUNCIONA BIEN
		
		//C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\texto.txt
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta del archivo que quieres leer");
		String ruta = sc.nextLine();
		System.out.println("Introduce el numero de lineas");
		int nLineas= sc.nextInt();
		
		
		BufferedReader br = new BufferedReader (new FileReader(ruta));
		int cLineas =0;
		String linea = "";
		while(((br.readLine())!=null)){
			if(cLineas == nLineas){
				break;
				
			}
			System.out.println("Linea: "+cLineas+" "+br.readLine());
			cLineas+=1;
		}br.close();
		
		

	}

}
