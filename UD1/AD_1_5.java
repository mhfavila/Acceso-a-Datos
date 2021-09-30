import java.io.File;
import java.io.IOException;

public class AD_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\DIR_1
		String path1 = "C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\DIR_1";// cojemos las
																											// direciones
																											// de la
																											// carpeta
		//C:\\Users\\Favila\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\DIR_2
		String path2 = "C:\\Users\\ALUMNO\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\DIR_2";// cojemos las
																											// direciones
																											// de la
																											// carpeta

		File carp = new File(path1);// usamos la ruta 1 para crearlo
		if (!carp.exists()) {
			carp.mkdir();// creamos el directorio 1
			System.out.println("Directorio creado");
		} else {
			System.out.println("lar ruta 1 ya existe");

		}
		File carp2 = new File(path2);// usamos la ruta 2 para crearlo
		if (!carp2.exists()) {
			carp2.mkdir();// creamos el directorio 2
			System.out.println("Directorio creado");
		} else {
			System.out.println("lar ruta 2 ya existe");

		}

		File fich1 = new File(path1 + "\\fichero1.txt");
		File fich2 = new File(path1 + "\\fichero2.txt");
		try {
			if(!fich1.exists()) {
				fich1.createNewFile();
				System.out.println("archivo 1 creado");
			}else {
				System.out.println("el archivo 1 ya existe");
			}
			if(!fich2.exists()) {
				fich2.createNewFile();
				System.out.println("archivo 2 creado");
			}else {
				System.out.println("el archivo 2 ya existe");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
