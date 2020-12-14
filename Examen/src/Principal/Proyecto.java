package Principal;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre","dni_jefe","empleadoAsignado"}) //Especifica el orden con el que quiere que aparezca el XML
public class Proyecto {
	
	private  String nombre;
	private String dni_jefe;
	private LinkedList <Emp_asignados> empleadoAsignado;
	
	public Proyecto() {
		
	}
	
	public Proyecto(String nombre, String dni_jefe, LinkedList<Emp_asignados> empleadoAsignado) {
		super();
		this.nombre = nombre;
		this.dni_jefe = dni_jefe;
		this.empleadoAsignado = empleadoAsignado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni_jefe() {
		return dni_jefe;
	}
	public void setDni_jefe(String dni_jefe) {
		this.dni_jefe = dni_jefe;
	}
	@XmlElement(name = "") //Hace que al general el xml la etiqueta nif aparezca como dni
	public LinkedList<Emp_asignados> getEmpleadoAsignado() {
		return empleadoAsignado;
	}
	public void setEmpleadoAsignado(LinkedList<Emp_asignados> empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}
	
	
	

}
