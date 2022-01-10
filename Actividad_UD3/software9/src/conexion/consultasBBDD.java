package conexion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import tablas.Empleado;
import tablas.Proyecto;
import tablas.Tarea;
import tablas.TareaId;

public class consultasBBDD {
	static ArrayList<String> dniEmpleados = new ArrayList<String>();
	static ArrayList<String> ids;
	static ArrayList<Tarea> taress;
	static ArrayList<Proyecto> proyectos2;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// llenarArrays();
		System.out.println("QUE DESEAS HACER");
		int opcion;

		do {
			System.out.println("1.ListadoDetallado");
			System.out.println("2.ListadoEmpleadoTarea");
			System.out.println("3.Borrar Tarea");
			System.out.println("4.Borrar Empleado");
			System.out.println("5.Insertar Empleado");
			System.out.println("6.Insertar Tarea");
			System.out.println("7.BuscarEmpleado");
			System.out.println("8.Buscar Proyecto");
			System.out.println("9.Actualizar Tarea");
			System.out.println("10.Eliminar empleado");
			opcion = sc.nextInt();

			String nombreProyecto;
			String nombreTarea;
			Tarea tarea;

			switch (opcion) {
			case 1:
				listadoDetallado();
				break;
			case 2:

				System.out.println("Introduce el nombre del proyecto");
				nombreProyecto = sc.nextLine();
				nombreProyecto = sc.nextLine();

				System.out.println("Introduce el nombre de la tarea");
				nombreTarea = sc.nextLine();

				tarea = new Tarea();

				tarea.setId(new TareaId(nombreProyecto, nombreTarea));
				listadoEmpleadosTarea1(tarea);

				break;
			case 3:

				System.out.println("Introduce el nombre del proyecto");
				nombreProyecto = sc.nextLine();
				nombreProyecto = sc.nextLine();

				System.out.println("Introduce el nombre de la tarea");
				nombreTarea = sc.nextLine();

				tarea = new Tarea();

				tarea.setId(new TareaId(nombreProyecto, nombreTarea));
				// borrarTarea(tarea);
				borrarTareSinSQL(tarea);
				break;
			case 4:
				System.out.println("BorrarEmpleado");
				System.out.println("Introduce el dni del empleado");
				String dni;
				dni = sc.nextLine();
				dni = sc.nextLine();

				borrarEmpleado(dni);

				break;

			case 5:
				System.out.println("");
				String dniEmple;
				String nombre;
				String apellido;
				String telefono;

				Empleado empleado = new Empleado();
				System.out.println("Introduce el dni del empledo");
				dniEmple = sc.next();
				sc.nextLine();
				
				

				System.out.println("Introduce el Nombre del empledo");
				nombre = sc.next();
				sc.nextLine();
				System.out.println("Introduce el Apellido del empledo");
				apellido = sc.next();
				sc.nextLine();
				System.out.println("Introduce el Telefono del empledo");
				telefono = sc.next();
				sc.nextLine();

				empleado.setDni(dniEmple);
				empleado.setNombre(nombre);
				empleado.setApellidos(apellido);
				empleado.setTelefono(telefono);

				insertarEmpleado(empleado);
				break;
			case 6:
				String estado;
				tarea = new Tarea();
				TareaId tid = new TareaId();
				System.out.println("Introduce el nombre del proyecto");
				nombreProyecto = sc.next();
				sc.nextLine();
				System.out.println("Introduce el nombre de la tarea");
				nombreTarea = sc.nextLine();

				tid.setNombre(nombreTarea);
				tid.setNombreProyecto(nombreProyecto);
				System.out.println("Introduce el estado de la tarea");
				estado = sc.nextLine();
				System.out.println("Introduce las horas de la tarea");
				int horas = sc.nextInt();
				tarea.setId(tid);
				tarea.setEstado(estado);
				tarea.setHoras(horas);
				insertarTarea(tarea);

				break;
			case 7:
				System.out.println("Introduce el dni que quieres buscar");
				dni = sc.next();
				sc.nextLine();
				buscarEmpleadoCompleto(dni);
				break;
			case 8:
				System.out.println("");
				System.out.println("Introduce el nmbre del proyecto que quieres buscar");
				nombreProyecto = sc.next();
				sc.nextLine();
				buscarProyecto(nombreProyecto);
				break;
			case 9:
				System.out.println("");
				System.out.println("Introduce el nombre de la tarea");
				nombreTarea = sc.next();
				sc.nextLine();
				int numeroHoras;
				System.out.println("Introduce el numero de horas");
				numeroHoras = sc.nextInt();
				System.out.println("\n");
				System.out.println("Tareas actualizadas = " + actualizarTarea(nombreTarea, numeroHoras));
				System.out.println("\n");

				break;
			case 10:
				System.out.println("");

				System.out.println("Introduce el apellido que quieres eliminar");
				apellido = sc.next();
				sc.nextLine();
				System.out.println("\n");
				System.out.println("Numero de empleados eliminados con el apellido " + apellido + " = "
						+ eliminarEmpledo(apellido));
				System.out.println("\n");

				break;

			}
		} while (opcion != 0);

	}
	/**
	 * elimina los empleados que tengan el apellido que se le pasa como parametro
	 * @param apellido el parametro que pasamos
	 * @return devuelve el numero de empleados que see han elimminado
	 */
	private static int eliminarEmpledo(String apellido) {
		int numero = 0;
		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			Query q = s.createQuery("Delete Empleado where apellidos =:apellido").setParameter("apellido", apellido);
			numero = q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		}
		return numero;
	}
	/**
	 * actualiza las horas de las tareas con el nombreTarea que le pasamos 
	 * @param nombreTarea le pasamos el nombre de las tareas 
	 * @param numeroHoras le pasamos las nuevas horas
	 * @return nos devueve el numero de tareas que se han modificado
	 */
	private static int actualizarTarea(String nombreTarea, int numeroHoras) {
		int tareasActualizadas = 0;

		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			Query q = s.createQuery("UPDATE Tarea set horas =:horas  where nombre =:nombre")
					.setParameter("horas", numeroHoras).setParameter("nombre", nombreTarea);
			tareasActualizadas = q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		}

		return tareasActualizadas;
	}

	/**
	 * busca los proyectos segun el parametro que le pasamos
	 * 
	 * @param nombreProyecto el nombre que le pasamos
	 */
	private static void buscarProyecto(String nombreProyecto) {

		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			Query q = s.createQuery("From Proyecto where nombre =:nombre").setParameter("nombre", nombreProyecto)
					.setReadOnly(true);
			List<tablas.Proyecto> listaProyecto = (List<tablas.Proyecto>) q.getResultList();
			for (tablas.Proyecto unPro : listaProyecto) {
				System.out.println("Proyecto: " + unPro.getNombre() + "fecha Fin: " + unPro.getFechFin());

				Date date = unPro.getFechFin();
				if (date != null) {
					System.out.println("EL Proyecto esta Finalizado");

				} else {
					System.out.println("EL Proyecto NO  esta Finalizado. Sus tareas son: ");
					System.out.println("Tareas: ");
					Iterator<Tarea> itTarea = unPro.getTareas().iterator();
					while (itTarea.hasNext()) {
						Tarea tarea = itTarea.next();
						System.out.println("=====================");
						System.out.println("\tNombre: " + tarea.getId().getNombre());
						System.out.println("\testado:" + tarea.getEstado() + "\n");
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	/**
	 * busca el empleado con el dni que le pasamos
	 * 
	 * @param dni para metro que le pasamos
	 */
	private static void buscarEmpleadoCompleto(String dni) {
		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();

			Query q = s.createQuery("FROM Empleado WHERE DNI LIKE :Dni").setParameter("Dni", dni);
			// mostrar datos empleado
			List<Empleado> listaProy = (List<Empleado>) q.getResultList();
			for (Empleado unProy : listaProy) {
				System.out.println("========================================");
				System.out.println("DNI: " + unProy.getDni());
				System.out.println("nombre: " + unProy.getNombre());
				System.out.println("apellidos: " + unProy.getApellidos());
				System.out.println("telefono: " + unProy.getTelefono());
				System.out.println("Proyectos asociados al empleado: ");
				Iterator<Proyecto> itTarea = unProy.getProyectos().iterator();
				while (itTarea.hasNext()) {
					Proyecto tarea = itTarea.next();
					System.out.println("-------------------------------");
					System.out.println("\tnombre: " + tarea.getNombre());
					System.out.println("-------------------------------");
				}
				System.out.println("========================================");

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	/**
	 * Añadios tarea
	 * @param tarea
	 */
	private static void insertarTarea(Tarea tarea) {
		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			s.save(tarea);
			t.commit();
			System.out
					.println(" Tarea: " + tarea.getId().getNombreProyecto() + tarea.getId().getNombre() + " Insertada");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	
			

		
	
	/**
	 * Para anadir nuevos empleados
	 * 
	 * @param empleado el empleado qu queremos anadir
	 */
	private static void insertarEmpleado(Empleado empleado) {
		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			
			
			s.save(empleado);
			
			t.commit();
			System.out.println(" Empleado:   " + empleado.getDni() + empleado.getNombre() + " Insertada");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	/**
	 * En este caso no uso ningun tipo de consulta sql
	 * 
	 * @param tarea la tarea que se le pasa
	 */
	private static void borrarTareSinSQL(Tarea tarea) {

		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			Transaction t = null;
			try {
				t = s.beginTransaction();
				String nombreTarea = tarea.getId().getNombre();
				String nombreProyecto = tarea.getId().getNombreProyecto();
				// tablas.Tarea tareaq = (tablas.Tarea) s.get(tablas.Tarea.class, borrTare);
				tarea = (tablas.Tarea) s.get(tablas.Tarea.class, tarea.getId());
				s.delete(tarea);
				t.commit();
				System.out.println("la tarea con id " + nombreProyecto + "-" + nombreTarea + " se a eliminado");

			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}

	}

	/**
	 * para borrar un empleado pasando su dni
	 * 
	 * @param dni
	 */
	private static void borrarEmpleado(String dni) {
		Transaction t = null;
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			tablas.Empleado empleado = (tablas.Empleado) s.get(tablas.Empleado.class, dni);
			// estamos creando un objeto apartir del dni para asi poderborrarlo
			s.delete(empleado);
			t.commit();
			System.out.println("El empleado con dni " + dni + " se a eliminado");

		} catch (Exception e) {
			e.printStackTrace(System.err);

		}

	}
	/**
	 * Muestra los dni de los empleados asignados a esa tarea
	 * 
	 * @param tarea tarea de lo que queremos ver los dni de los empleados
	 */
	public static void listadoEmpleadosTarea1(Tarea tarea) {

		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			Transaction t = null;
			try {
				t = s.beginTransaction();
				
				Tarea tarea1 = (Tarea)s.get(Tarea.class, tarea.getId());
				t.commit();
				
				Iterator<Empleado> itTarea = tarea1.getEmpleados().iterator();
				System.out.println("-------------------------------");
				while (itTarea.hasNext()) {
					Empleado empleado = itTarea.next();
					
					System.out.println("\tnombre: " + empleado.getDni());
					
				}
				System.out.println("-------------------------------");
				

			} catch (Exception e) {
				e.printStackTrace(System.err);
				if (t != null) {
					t.rollback();
				}
			}
		}
	}

	/**
	 * Muestra los dni de los empleados asignados a esa tarea
	 * 
	 * @param tarea tarea de lo que queremos ver los dni de los empleados
	 */
	public static void listadoEmpleadosTarea(Tarea tarea) {
		try (Session s = conexionHiber.getSessionFactory().openSession()) {

			Query q = (Query) s.createSQLQuery(
					"SELECT DNI_empleado FROM empleado_tarea WHERE nombre_tarea LIKE ? AND nombre_proyecto_tarea LIKE ?;")
					.setParameter(2, tarea.getId().getNombreProyecto()).setParameter(1, tarea.getId().getNombre());
			List<String> empData = q.getResultList();
			System.out.println("Lista los dni de empleados en esa tarea: ");
			for (String row : empData) {
				System.out.println("dni: " + row);
				dniEmpleados.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * listado de los proeyectos y sus tareas
	 */
	private static void listadoDetallado() {

		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			ids = new ArrayList<String>();
			int h = 0;// contador es como si fuese la i en un for normal
			proyectos2 = new ArrayList<Proyecto>();
			taress = new ArrayList<Tarea>();
			Query q = s.createQuery("FROM Proyecto ").setReadOnly(true);
			List<tablas.Proyecto> listaProyectos = (List<tablas.Proyecto>) q.getResultList();
			tablas.Proyecto proyecto;// creo un objeto del tipo proyecto
			// primero sacamos la primera consulta que es la de los proyectos
			for (tablas.Proyecto unPro : listaProyectos) {
				proyecto = new tablas.Proyecto();
				// voy a creara un array de proyectos para luegopoder usarlo en el otro apartado
				proyecto.setNombre(unPro.getNombre());
				proyecto.setDuracion(unPro.getDuracion());
				proyecto.setFechIn(unPro.getFechIn());
				proyecto.setFechFin(unPro.getFechFin());

				proyecto.setTareas(unPro.getTareas());

				proyectos2.add(proyecto);

				System.out.println("Proyecto: [" + unPro.getNombre() + "] \n " + "\t Duracion: " + unPro.getDuracion()
						+ " semanas" + "\n" + "\t FechaInicio: " + unPro.getFechIn() + "\n" + "\t FechaFin: "
						+ unPro.getFechFin());
				ids.add(unPro.getNombre());// anadimos los ids al arrayList

				Query q1 = s.createQuery("FROM Tarea WHERE nombre_proyecto = :id").setParameter("id", ids.get(h))
						.setReadOnly(true);
				// estamos indicando el valor del parametro id
				List<tablas.Tarea> listaTareas = (List<tablas.Tarea>) q1.getResultList();
				// sacamos la segunda consulta que son las taras
				System.out.println("\t Tareas Proyecto: ");
				for (tablas.Tarea unTareas : listaTareas) {

					System.out.println("\t\t Tarea: " + unTareas.getId().getNombreProyecto()
							+ unTareas.getId().getNombre() + "  \n " + "\t\t\t Estado: " + unTareas.getEstado()
							+ ";\n  \t\t\t Numero de Horas: " + unTareas.getHoras() + ";\n \t\t\t Proyecto Pertenece: "
							+ unTareas.getProyecto().getNombre() + ";");
					System.out.println("========================================");
				}
				h++;

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

}
