package JaxB;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre","dni_jefe", "empleado"})
public class Proyecto {
	
	String nombre;
	String dni_jefe;
	Emp_Asignados empleado;
	
	public Proyecto(String nombre, String dni_jefe, Emp_Asignados empleado) {
		super();
		this.nombre = nombre;
		this.dni_jefe = dni_jefe;
		this.empleado = empleado;
	}
	
	public Proyecto() {
		super();
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
	public Emp_Asignados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Emp_Asignados empleado) {
		this.empleado = empleado;
	}
	

}
