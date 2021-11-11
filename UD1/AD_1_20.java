import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */

public class AD_1_20 {

	static ArrayList<String> lineas;
	public static void main(String[] args) {
		
		 
		LeerEscribir();
		
	}
	
	public static void LeerEscribir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce fichero de lectura: ");//fichero en el que vamos a leer
		String leer = sc.nextLine();
		System.out.println("Introduce fichero de escritura: ");//fichero en el que se va a escribir
		String escribir = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(leer+".txt")))
		{
		    String line;
		    lineas = new ArrayList<String>();
		    while ((line = br.readLine()) != null) {
		    	lineas.add(line);
		    }
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir+".txt"))) {
		    for (int i = 0; i < lineas.size(); i++) {
		        bw.write( lineas.get(i));
		        bw.newLine();
		       
		    }
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
