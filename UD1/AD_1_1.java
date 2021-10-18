import java.io.File;
/*Consulta la documentación de la clase File en la página web de la documentación oficial de Java
(https://docs.oracle.com/en/java/). Elabora un programa que haga uso de, al menos, 6 métodos de
dicha clase y que muestre por pantalla qué método se está utilizando y un resumen de lo que hace.*/

/**
 * 
 * @author Favila
 *
 */
public class AD_1_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ficheros en el directorio actual: ");
		File file = new File(".");//abrimos un nuevo file
		String[] archivos = file.list(); //creamos un array de string donde guardaremos lo que hemos leido de file
		for(int i=0;i<archivos.length;i++) {
			System.out.println(archivos[i]);
		}
		System.out.println("Probando el metodo canExecute sobre el objeto File.");
		System.out.println("\tSe puede ejecutar: "+file.canExecute());
		System.out.println("Probando el metodo canRead sobre el objeto File.");
		System.out.println("\tSe puede leer: "+file.canRead());
		System.out.println("Probando el metodo canWrite sobre el objeto File.");
		System.out.println("\tSe puede escribir: "+file.canWrite());
		System.out.println("Probando el metodo getName sobre el objeto File.");
		System.out.println("\tSu nombre es: "+file.getName());
		System.out.println("Probando el metodo isFile sobre el objeto File.");
		System.out.println("\tSu es un archivo normal es: "+file.isFile());
		System.out.println("Probando el metodo getParent sobre el objeto File.");
		System.out.println("\tSu ruta del padre es es: "+file.getParent());
		

	}

}
