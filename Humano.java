package para_repositorio;

public class Humano {
	
	/**
	 * atributos
	 */
	protected int DNI;
	protected String nombre;
	
	
	/**
	 * constuctores
	 */
	public Humano(String n, int dni) {
			DNI = dni;
			nombre = n;
	}
	
	/**
	 * metodos
	 */
	public void setNombre(String n) {
		nombre = n;
	}
	
	public void setDNI(int n) {
		DNI = n;
	}
	
	public int getDNI() {
		return DNI;
	}
	
	public String getNombre() {
		return nombre;
	}
}
