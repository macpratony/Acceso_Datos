package A7_Json;

public class DatosMateria {
	
	String materia;
	String nombre;
	String nota; 
	
	public DatosMateria(String materia, String nombre, String nota) {
		super();
		this.materia = materia;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	
	public DatosMateria(String nombre, String nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
	}


	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
}
