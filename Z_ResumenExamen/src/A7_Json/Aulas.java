package A7_Json;

import java.util.List;

public class Aulas {
	
	String nombre;
	List<Notas> notas;
	
	public Aulas(String nombre, List<Notas> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {		
		return "Nombre="+ nombre + "notas "+ notas ;
	}
	
	
}
