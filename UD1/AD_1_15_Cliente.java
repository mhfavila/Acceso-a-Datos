import java.io.Serializable;
import java.util.ArrayList;

public class AD_1_15_Cliente implements Serializable{

	
	private String nombre;
	private String puesto;
	private int antiguedad;
	private ArrayList<Integer> telefono;
	private boolean definido;
	
	
	public AD_1_15_Cliente(String nombre, String puesto, int antiguedad, ArrayList<Integer> telefono, boolean definido) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
		this.antiguedad = antiguedad;
		this.telefono = telefono;
		this.definido = definido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}


	public ArrayList<Integer> getTelefono() {
		return telefono;
	}


	public void setTelefono(ArrayList<Integer> telefono) {
		this.telefono = telefono;
	}


	public boolean isDefinido() {
		return definido;
	}


	public void setDefinido(boolean definido) {
		this.definido = definido;
	}
	
	
	
	
	
	
	
} 
