package A4_JaxB;

import java.util.ArrayList;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nif","nombre","nota","asignaturas"}) //Especifica el orden con el que quiere que aparezca el XML
public class Alumno {
	
	String nombre, nif, nota;
	List<Asignatura> asignaturas;
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre, String nif, String nota, List<Asignatura> asignaturas) {
		super();
		this.nombre = nombre;
		this.nif = nif;
		this.nota = nota;
		this.asignaturas = asignaturas;
	}
	
	
	//@XmlTransient // Hace que no aparezca en el XML la etiqueta nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name = "dni") //Hace que al general el xml la etiqueta nif aparezca como dni
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	@XmlAttribute            // Especifica que es un atributo
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public List<Asignatura> getAsignaturas() {
		
		/*if(asignaturas == null)
			return new ArrayList<Asignatura>();*/
		
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	

}
