import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Favila
 *
 */
//******************************************REVISAR
/*
 * Escribe un programa que permita almacenar en un fichero información de
 * empleados de manera estructurada (1 empleado por línea). La información a
 * guardar será nombre, puesto (analista, programador, tester, becario, jefe de
 * equipo), antigüedad (número entero de años), teléfono de contacto (9
 * dígitos), si es o no indefinido (valor booleano). Para acostumbrarnos a
 * trabajar con listas se hará una breve explicación en clase para generar los
 * datos de forma aleatoria.
 * 
 */
public class AD_1_15 {

	public static void main(String[] args) throws IOException {
		
		try {
			escribirClientes();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void escribirClientes() throws IOException {
		
		Random rand = new Random();
		
		File fichero = new File("Clientes.txt");
		
		FileWriter fic = new FileWriter(fichero);
		
		
		ArrayList<String> nombres = new ArrayList<String>(Arrays.asList("Raul","Pedro","Angel","Manuel","Mario"));
		ArrayList<String> puestos = new ArrayList<String>(Arrays.asList("analista","programador", "tester", "becario", "jefe de equipo"));
		ArrayList<Boolean> definido = new ArrayList<Boolean>(Arrays.asList(true,false));
		
		
		for (int i = 0 ; i< nombres.size();i++) {
			int antiguedad = rand.nextInt(30);
			ArrayList<Integer> telefono=new ArrayList<Integer>();
			
			for (int j = 0; j < 9; j++) {
				telefono.add(rand.nextInt(9));
				
			}
			
		String cadenaCliente = "Nombre: "+nombres.get(rand.nextInt(5))+"	Puesto: "+puestos.get(rand.nextInt(5))+"	Antiguedad: "+antiguedad+"	Telefono: "+telefono+"	Definido: "+definido.get(rand.nextInt(2))+"\n";	
			
		
		fic.write(cadenaCliente);
		
		
			
		}
		fic.close();
	}
}
