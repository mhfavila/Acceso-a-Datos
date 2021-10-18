import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
		// TODO Auto-generated method stub
		File fichero = new File("fichero.dat");
		DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero));
		String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres","Julio","Antonio","Maria"};
		int edades[]= {14,15,13,16,12,16,14,13};
		for(int i = 0;i<edades.length;i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);
			
		}
		dataOS.close();
		DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));
	}

}
