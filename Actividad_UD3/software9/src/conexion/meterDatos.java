package conexion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tablas.Empleado;
import tablas.Proyecto;
import tablas.Tarea;
import tablas.TareaId;

public class meterDatos {
	static ArrayList<String> listaNombre;
	static ArrayList<String> listaApellido;
	static ArrayList<String> numero;
	static ArrayList<String> telefono;
	static ArrayList<String> letras;
	static ArrayList<String> dni;
	static ArrayList<String> nTarea;
	static ArrayList<String> estadoTarea;
	static ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	static ArrayList<Tarea> tareas = new ArrayList<Tarea>();

	public static void main(String[] args) {
		llenarArray();
		creacionProyecto();
		creacionEmpleado();
		creacionTarea();
		poblarBBDD();

	}

	/**
	 * Con los arraylist previamente rellenados, los va recorriendo y guardando en
	 * la base de datos
	 */
	private static void poblarBBDD() {
		try (Session s = conexionHiber.getSessionFactory().openSession()) {
			Transaction t = null;

			try {
				t = s.beginTransaction();

				for (int i = 0; i < proyectos.size(); i++) {
					s.save(proyectos.get(i));
					System.out.println("Proyecto " + proyectos.get(i).getNombre() + " añadido.");
				}
				for (int i = 0; i < empleados.size(); i++) {
					s.save(empleados.get(i));
					System.out.println("Empleado " + empleados.get(i).getNombre() + " añadido.");
				}
				for (int i = 0; i < tareas.size(); i++) {
					s.save(tareas.get(i));
					System.out.println("Tarea " + tareas.get(i).getId().getNombre()
							+ tareas.get(i).getId().getNombreProyecto() + " añadido.");
				}

				t.commit();

			} catch (Exception e) {
				e.printStackTrace(System.err);
				if (t != null) {
					t.rollback();
				}
			} finally {
				s.close();
			}
		}

	}

	/**
	 * Crea y guarda los proyectos en el arraylist de proyectos
	 */
	private static void creacionProyecto() {
		tablas.Proyecto proyecto;
		String nombreProyecto;

		int diasDuracion = 0;

		Calendar calendario;
		Date fechaActual;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");// para dar forma a la fecha
		Date fechaRestad;// la fecha inicial
		Date fechaInicio;// fecha inicial con el formato corrrecto
		Date fechaFin;
		int numeroAletroioGeneraProyectos = (int) (Math.random() * (6 - 3) + 3);
		int aleatorioSemanas;// para sacar la fecha de inicio
		int numeroDeDiasTotalesdelProyeccto;// dias totales que dura el proyecto
		int nAleaDuracion;// semanas que va a durar el proyecto desde su fecha de inicio
		for (int i = 0; i < numeroAletroioGeneraProyectos; i++) {
			proyecto = new tablas.Proyecto();
			nombreProyecto = "PROYECTO_" + i;

			calendario = Calendar.getInstance();

			fechaActual = calendario.getTime();// sacamos la fecha de hoy

			nAleaDuracion = (int) (Math.random() * (12 - 4) + 4);// Numero de semanas que tiene que durar el
																	// proyecto (entre 4 y 12)

			aleatorioSemanas = (int) (Math.random() * (56 - 42) + 42);// Numero de dias que hay que restar a la
																		// feccha actual para sacar la fecha de
																		// inicio del proyecto

			calendario.add(Calendar.DATE, -aleatorioSemanas);// para sacar la feccha de inicio
			fechaRestad = calendario.getTime();// sacamos la fecha ya restadda

			fechaInicio = new Date(formatoFecha.format(fechaRestad));

			proyecto.setNombre(nombreProyecto);
			proyecto.setDuracion(nAleaDuracion);
			proyecto.setFechIn(fechaInicio);

			numeroDeDiasTotalesdelProyeccto = nAleaDuracion * 7;
			calendario.setTime(fechaInicio);// establecemos el calendario con la fecha de inicio
			calendario.add(Calendar.DATE, numeroDeDiasTotalesdelProyeccto);
			fechaFin = calendario.getTime();

			if (fechaFin.before(fechaActual)) {
				// es si la fecha final es antesque la fecha actual
				proyecto.setFechFin(fechaFin);
			} else {

				proyecto.setFechFin(null);
			}

			proyectos.add(proyecto);

		}

	}

	/**
	 * crea empleados y los guarda en el arraylist de empleados
	 */
	private static void creacionEmpleado() {
		int nAleatNombre;// generara un numero aleatorio para sacar un dni de dentro del array
		int nAleatApellido;

		int nAleatTelefono;
		int nAleatorioAsignacionProyecto;// para sacar el numero de proyectos en el q esta el empleado
		int nAleatProyecto;// aleatoriopara sacar el proyecto para a;adirlo al epleado
		tablas.Empleado empleado;
		for (int i = 0; i < 10; i++) {
			empleado = new tablas.Empleado();
			nAleatNombre = (int) (Math.random() * (listaNombre.size() - 0) + 0);
			nAleatApellido = (int) (Math.random() * (listaApellido.size() - 0) + 0);

			nAleatTelefono = (int) (Math.random() * (telefono.size() - 0) + 0);
			nAleatorioAsignacionProyecto = (int) (Math.random() * (3 - 0) + 0);

			empleado.setDni(dni.get(i));
			empleado.setNombre(listaNombre.get(nAleatNombre));
			empleado.setApellidos(listaApellido.get(nAleatApellido));

			// empleado.setTelefono(Integer.parseInt(telefono.get(nAleatTelefono)));
			empleado.setTelefono(telefono.get(nAleatTelefono));
			// Revisar lo de los empleados en proyectos

			for (int k = 0; k < nAleatorioAsignacionProyecto; k++) {
				nAleatProyecto = (int) (Math.random() * (proyectos.size() - 0) + 0);
				empleado.getProyectos().add(proyectos.get(nAleatProyecto));

			}

			empleados.add(empleado);
		}

	}

	/**
	 * crea tareas y los guarda en el arraylist de tareas
	 */
	private static void creacionTarea() {
		int nAleatTareasProyecto;
		for (int i = 0; i < proyectos.size(); i++) {
			nAleatTareasProyecto = (int) (Math.random() * (8 - 5) + 5);
			Proyecto proyecto = proyectos.get(i);

			int nAleatNombretarea;
			int nAleatProyecto;
			int nAleatHoras;
			int nAleatEstadoTarea;

			int nAleatEmpleados;
			for (int j = 0; j < nAleatTareasProyecto; j++) {
				nAleatNombretarea = (int) (Math.random() * (nTarea.size() - 0) + 0);
				nAleatProyecto = (int) (Math.random() * (proyectos.size() - 0) + 0);
				nAleatEmpleados = (int) (Math.random() * (empleados.size() - 0) + 0);
				nAleatHoras = (int) (Math.random() * (10 - 2) + 2);
				nAleatEstadoTarea = (int) (Math.random() * (estadoTarea.size() - 0) + 0);
				nAleatEmpleados = (int) (Math.random() * (2 - 0) + 0);
				Tarea tarea = new Tarea();
				TareaId tareaId = new TareaId();
				tareaId.setNombre(nTarea.get(nAleatNombretarea));
				tareaId.setNombreProyecto(proyecto.getNombre());
				tarea.setId(tareaId);
				tarea.setHoras(nAleatHoras);
				tarea.setProyecto(proyecto);

				Date date = proyectos.get(i).getFechFin();
				if (date != null) {
					tarea.setEstado("FINALIZADA");

				} else {
					tarea.setEstado(estadoTarea.get(nAleatEstadoTarea));
				}

				for (int k = 0; k < nAleatEmpleados; k++) {
					int indiceEmpleadosAleat = (int) (Math.random() * ((empleados.size() - 1 - 0) + 1)) + 0;
					// aqui añadimos el empleado a la tarea
					tarea.getEmpleados().add(empleados.get(indiceEmpleadosAleat));
				}
				if (comprobarRepetidoNombreTarea(tarea.getId().getNombre(), proyecto)) {
					renombrarTarea(tarea, proyecto);
					tareas.add(tarea);

				} else {
					tareas.add(tarea);

				}
				proyecto.getTareas().add(tarea);

			}

		}

	}

	/**
	 * detecta si el nombre de la tarea esta repetido dentro de dicho proyecto
	 * 
	 * @param nombreTarea nombre de la tarea
	 * @param proyecto    proyecto al que pertenece esa tarea
	 * @return true si esta repetido, false si no esta repetido
	 */
	private static boolean comprobarRepetidoNombreTarea(String nombreTarea, Proyecto proyecto) {
		Iterator<Tarea> it = proyecto.getTareas().iterator();
		while (it.hasNext()) {
			Tarea tarea = it.next();
			if (tarea.getId().getNombre().equals(nombreTarea)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * renombra una tarea recursivamente hasta que no este repetido esa tarea de ese
	 * proyecto.
	 * 
	 * @param tarea    tarea a renombrar
	 * @param proyecto proyecto al que pertenece esa tarea
	 */
	private static void renombrarTarea(Tarea tarea, Proyecto proyecto) {
		tarea.getId().setNombre(tarea.getId().getNombre().concat("Fase_2"));
		if (comprobarRepetidoNombreTarea(tarea.getId().getNombre(), proyecto)) {
			renombrarTarea(tarea, proyecto);
		}

	}

	/**
	 * rellena los arraylist que sirven para generar informacion aleatoria
	 */
	private static void llenarArray() {
		int n = 0;
		estadoTarea = new ArrayList<String>();
		estadoTarea.add("Planificada");
		estadoTarea.add("Empezada");
		estadoTarea.add("Finalizada");
		nTarea = new ArrayList<String>();
		nTarea.add("Analisis");
		nTarea.add("Diseno");
		nTarea.add("Codificacion");
		nTarea.add("Pruebas");
		nTarea.add("Documentacion");
		System.out.println("->hola");
		listaNombre = new ArrayList<String>();
		listaNombre.add("pedro");
		listaNombre.add("marcos");
		listaNombre.add("juan");
		listaNombre.add("raul");
		listaNombre.add("favila");
		listaNombre.add("ramon");
		listaNombre.add("julia");
		listaNombre.add("ana");
		listaNombre.add("jonas");
		listaNombre.add("david");
		listaApellido = new ArrayList<String>();
		listaApellido.add("montero");
		listaApellido.add("herredia");
		listaApellido.add("stuani");
		listaApellido.add("ramirez");
		listaApellido.add("jimenez");
		listaApellido.add("fuente");
		listaApellido.add("crespo");
		listaApellido.add("escan");
		listaApellido.add("hidra");
		listaApellido.add("suat");

		numero = new ArrayList<String>();
		telefono = new ArrayList<String>();
		letras = new ArrayList<String>();
		dni = new ArrayList<String>();
		numero.add("0");
		numero.add("1");
		numero.add("2");
		numero.add("3");
		numero.add("4");
		numero.add("5");
		numero.add("6");
		numero.add("7");
		numero.add("8");
		numero.add("9");
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		letras.add("G");
		letras.add("H");
		letras.add("I");
		letras.add("J");
		letras.add("L");
		letras.add("M");

		System.out.println("->1");
		String dni1 = "0";
		String telefono1 = "6";
		String nombre1 = " ";
		String apellido1 = " ";
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 7; i++) {
				n = (int) (Math.random() * (9 - 1) + 1);
				dni1 = dni1 + numero.get(n);
			}

			n = (int) (Math.random() * (9 - 1) + 1);
			dni1 = dni1 + letras.get(n);

			dni.add(dni1);
			dni1 = "0";
		}

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 8; i++) {
				n = (int) (Math.random() * (9 - 1) + 1);
				telefono1 = telefono1 + numero.get(n);
			}

			telefono.add(telefono1);
			telefono1 = "6";
		}

	}

}
