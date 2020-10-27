package ConvertirClasesAXML;


public class Asignatura {
	
	String nombre, profesor;
	
	public Asignatura(String nombre, String profesor) {
		super();
		this.nombre = nombre;
		this.profesor = profesor;
		
		
	}
	
	public Asignatura() {
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	

}
