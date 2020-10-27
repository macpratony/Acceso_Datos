package JaxB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre","dni_jefe", "empleado"})
public class Proyecto {
	
	String nombre;
	String dni_jefe;
	List<Emp_Asignados> empleado;
	
	public Proyecto(String nombre, String dni_jefe, List<Emp_Asignados> empleado) {
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

	public List<Emp_Asignados> getEmpleado() {
		if(empleado == null)
			return new ArrayList<Emp_Asignados>();
		return empleado;
	}

	public void setEmpleado(List<Emp_Asignados> empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
	
	

}
