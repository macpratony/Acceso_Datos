package JaxB;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre","dni_jefe", "emp_asignados"})
public class Proyecto {
	
	String nombre;
	String dni_jefe;
	Emp_Asignados emp_asignados;
	
	public Proyecto(String nombre, String dni_jefe, Emp_Asignados emp_asignados) {
		super();
		this.nombre = nombre;
		this.dni_jefe = dni_jefe;
		this.emp_asignados = emp_asignados;
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
	public Emp_Asignados getEmp_asignados() {
		return emp_asignados;
	}
	public void setEmp_asignados(Emp_Asignados emp_asignados) {
		this.emp_asignados = emp_asignados;
	}
	

}
