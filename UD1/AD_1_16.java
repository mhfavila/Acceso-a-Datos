import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * 
 * @author Favila
 *
 */
/*
 * Escribe un programa en Java que permita recuperar los datos del fichero que
 * crea el programa de la actividad 15. En este caso el usuario deberá poder
 * recuperar los empleados filtrados por cada uno de los siguientes campos: a.
 * Puesto: el usuario deberá poder elegir el tipo de puesto de los empleados que
 * se mostrarán. b. Antigüedad: el usuario deberá poder elegir empleados con una
 * antigüedad menor, mayor o igual a un determinado número de años. c.
 * Indefinido: el usuario tiene que poder elegir filtrar si mostrar empleados
 * indefinidos o no.
 * 
 */
public class AD_1_16 {

	static String puesto;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		leerFichero();
	
	}
	public void menu() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Que tipos de empleado quieres mostrar ? ");
		System.out.println("1)analista");
		System.out.println("2)programador");
		System.out.println("3)tester");
		System.out.println("4)becario");
		System.out.println("5)jefe de equipo");
		int tipo = sc.nextInt();
		switch(tipo) {
		case 1: puesto="analista";
		case 2: puesto="programador";
		case 3: puesto="tester";
		case 4: puesto="becario";
		case 5: puesto="jefe de equipo";
		
		}
		
		System.out.println("Mostrar por orden de antiguedad");
		System.out.println("1)menor que");
		System.out.println("2)mayor que");
		System.out.println("3)igual");
		int orden = sc.nextInt();
		
		
		
		System.out.println("Mostrar definidos(S/N)");
		String mostrar = sc.nextLine();
		
		
		
	}
	public static void leerFichero() throws IOException, ClassNotFoundException {
		
		try {
			FileInputStream ficheroEntrada = new FileInputStream("Clientes.txt ");
			ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
			
			AD_1_15_Cliente cliente;
			do {
				cliente = (AD_1_15_Cliente)objetoEntrada.readObject();
				if(cliente.getPuesto().equals(puesto)) {
					System.out.println("Nombre : "+cliente.getNombre()+"	Puesto : "+cliente.getPuesto()+"	Antiguedad : "+cliente.getAntiguedad()+"	Telefono: "+cliente.getTelefono()+"	Definido: "+cliente.isDefinido());

				}
				
			
			
			}while(cliente.getNombre()!=null);
			
		}catch(Exception e) {
			
		}
			
	}

}
