import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * 
 * @author Favila
 *
 */
/*
 * Tienes un fichero con información sobre empleados de una empresa. Este
 * fichero sigue la siguientes estructura en cada una de sus filas:
 * “nombre,puesto,salario,antigüedad”. Los datos se almacenan siguiendo estas
 * indicaciones: a. Para el nombre se guardan las iniciales del nombre y los dos
 * apellidos (no se contemplan más de 3 letras). b. Para el puesto se introducen
 * 2 letras. c. Para el salario se introducen 5 números enteros. d. Para la
 * antigüedad se introducen 2 números enteros (el primero puede ser un 0). e.
 * Todos los campos se separan por punto y coma (;).
 */
public class AD_1_8 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String ruta = "C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\empresaNombres.txt";
		File fichero = new File(ruta);//creamos un nuevo file fichero que le pasaremos la ruta
		RandomAccessFile fic = new RandomAccessFile(fichero, "rw");
		
//----------------NOMBRES-------------------
		ArrayList<String> nombres = new ArrayList<String>();
		// nombre1
		int nCaracter = 4;
		int saltos = 0;
		byte[] caracteres = new byte[nCaracter];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos);// la cantidad de espacios que queremos saltar
		fic.read(caracteres);// leemos los caracteres almacenados en el array

		String nombre1 = new String(caracteres);// combertimos los bytes en un string

		nombres.add(nombre1);

		// nombre2
		int nCaracter2 = 4;
		int saltos2 = 19;
		byte[] caracteres2 = new byte[nCaracter2];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos2);// la cantidad de espacios que queremos saltar
		fic.read(caracteres2);// leemos los caracteres almacenados en el array

		String nombre2 = new String(caracteres2);// combertimos los bytes en un string

		nombres.add(nombre2);
		// nombre3
		int nCaracter3 = 4;
		int saltos3 = 38;
		byte[] caracteres3 = new byte[nCaracter3];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos3);// la cantidad de espacios que queremos saltar
		fic.read(caracteres3);// leemos los caracteres almacenados en el array

		String nombre3 = new String(caracteres3);// combertimos los bytes en un string

		nombres.add(nombre3);
		
		
//-----------------PUESTO------------------
		ArrayList<String> puestos = new ArrayList<String>();
		// puesto1
		int nCaracter11 = 4;
		int saltos11 = 4;
		byte[] caracteres11 = new byte[nCaracter11];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos11);// la cantidad de espacios que queremos saltar
		fic.read(caracteres11);// leemos los caracteres almacenados en el array

		String puesto1 = new String(caracteres11);// combertimos los bytes en un string

		puestos.add(puesto1);

		// puesto2
		int nCaracter22 = 4;
		int saltos22 = 23;
		byte[] caracteres22 = new byte[nCaracter22];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos22);// la cantidad de espacios que queremos saltar
		fic.read(caracteres22);// leemos los caracteres almacenados en el array

		String puesto2 = new String(caracteres22);// combertimos los bytes en un string

		puestos.add(puesto2);
		// puesto3
		int nCaracter33 = 4;
		int saltos33= 42;
		byte[] caracteres33 = new byte[nCaracter33];
		fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
					// archivo
		fic.skipBytes(saltos33);// la cantidad de espacios que queremos saltar
		fic.read(caracteres33);// leemos los caracteres almacenados en el array

		String puesto3 = new String(caracteres33);// combertimos los bytes en un string

		puestos.add(puesto3);
		//-----------------SALARIO------------------
				ArrayList<String> salarios = new ArrayList<String>();
				//salario1
				int nCaracter111 = 6;
				int saltos111 = 8;
				byte[] caracteres111= new byte[nCaracter111];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos111);// la cantidad de espacios que queremos saltar
				fic.read(caracteres111);// leemos los caracteres almacenados en el array

				String salario1 = new String(caracteres111);// combertimos los bytes en un string

				salarios.add(salario1);

				// salario2
				int nCaracter222 = 6;
				int saltos222= 27;
				byte[] caracteres222 = new byte[nCaracter222];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos222);// la cantidad de espacios que queremos saltar
				fic.read(caracteres222);// leemos los caracteres almacenados en el array

				String salario2 = new String(caracteres222);// combertimos los bytes en un string

				salarios.add(salario2);
				
				// salario3
				int nCaracter333 = 6;
				int saltos333= 46;
				byte[] caracteres333 = new byte[nCaracter333];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos333);// la cantidad de espacios que queremos saltar
				fic.read(caracteres333);// leemos los caracteres almacenados en el array

				String salario3 = new String(caracteres333);// combertimos los bytes en un string

				salarios.add(salario3);
				
				
				//-----------------TIEMPO------------------
				ArrayList<String> tiempo = new ArrayList<String>();
				//tiempo1
				int nCaracter1111 = 3;
				int saltos1111 = 14;
				byte[] caracteres1111= new byte[nCaracter1111];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos1111);// la cantidad de espacios que queremos saltar
				fic.read(caracteres1111);// leemos los caracteres almacenados en el array

				String tiempo1 = new String(caracteres1111);// combertimos los bytes en un string

				tiempo.add(tiempo1);

				// salario2
				int nCaracter2222 = 3;
				int saltos2222= 33;
				byte[] caracteres2222 = new byte[nCaracter2222];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos2222);// la cantidad de espacios que queremos saltar
				fic.read(caracteres2222);// leemos los caracteres almacenados en el array

				String tiempo2 = new String(caracteres2222);// combertimos los bytes en un string

				tiempo.add(tiempo2);
				
				// salario3
				int nCaracter3333 = 3;
				int saltos3333= 52;
				byte[] caracteres3333= new byte[nCaracter3333];
				fic.seek(0);// colocamos laposicion del cursor desde donde queremos que empiece a leer en el
							// archivo
				fic.skipBytes(saltos3333);// la cantidad de espacios que queremos saltar
				fic.read(caracteres3333);// leemos los caracteres almacenados en el array

				String tiempo3 = new String(caracteres3333);// combertimos los bytes en un string

				tiempo.add(tiempo3);


		for (int i = 0; i < fic.length() / 16; i++) {
			System.out.println("Nombre: " + nombres.get(i));
			System.out.println("Puesto: " + puestos.get(i));
			System.out.println("Salario: " + salarios.get(i));
			System.out.println("Antiguedad: " + tiempo.get(i));
			System.out.println(" ");
		}

	}
}




	