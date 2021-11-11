import java.io.File;
import java.io.FileNotFoundException;
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
 * Escribe un programa en Java que permita comparar el contenido de dos
 * ficheros. En el caso de que no sean iguales deberá informarse por pantalla de
 * las líneas (numeradas) donde se han encontrado diferencias imprimiendo las
 * líneas por pantalla.
 */

public class AD_1_14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String pat1="C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\comparar1.txt";
		String pat2="C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\comparar2.txt";
		File p1 = new File(pat1);
		File p2 = new File(pat2);
		System.out.println(comparaContenidoFicheros(p1,p2));
		
			
		}
	
	public static boolean comparaContenidoFicheros(File f1, File f2) throws IOException  {
		boolean iguales = false;
		
		
			FileReader is_f1 = new FileReader(f1);
			FileReader is_f2 = new FileReader(f2);
			
			if(f1.length()== f2.length()) {
				iguales = true;
				System.out.println("Tienen el mismo tamaño");
				int F1 = 0;
				int F2 = 0;
				
				while(iguales) {
					
						F1 = is_f1.read();
					
					
						F2 = is_f2.read();
					
					
					
					iguales = F1 == F2;
					if((F1==F2)&&(F1 == -1)) {
					
							is_f1.close();
						
						
							is_f2.close();
						
						return iguales;
					}
				}
				
			}else {
				System.out.println("Son distintos");
				
			}
			
				is_f1.close();
			 
			
				is_f2.close();
			
		
		return iguales;
	}
	
}

