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
 * Escribe un programa que permita almacenar en un fichero informaci�n de
 * empleados de manera estructurada (1 empleado por l�nea). La informaci�n a
 * guardar ser� nombre, puesto (analista, programador, tester, becario, jefe de
 * equipo), antig�edad (n�mero entero de a�os), tel�fono de contacto (9
 * d�gitos), si es o no indefinido (valor booleano). Para acostumbrarnos a
 * trabajar con listas se har� una breve explicaci�n en clase para generar los
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
