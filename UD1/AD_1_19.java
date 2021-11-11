import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Favila
 *
 */

public class AD_1_19 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\favil\\OneDrive\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\txtActividad19.txt");
		BufferedWriter bfw = new BufferedWriter(new FileWriter(f));//creamos un nuevo bufer de escritura y le pasamos la ruta
		bfw.write("Esta es la primera línea del fichero");//ponemos lo que queremos que vaya en la primera linea
		 bfw.newLine();//con el metodo new line se agrega al archivo un salto de linea
		 bfw.write("Segunda línea");
		 bfw.newLine();
		 bfw.write("tercera Linea");
		 bfw.newLine();
		 bfw.close();
		 System.out.println(" escrito el fichero " );
		

	}

}
