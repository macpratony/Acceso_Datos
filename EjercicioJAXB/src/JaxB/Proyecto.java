package JaxB;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	
	String nombre;
	String dni_jefe;
	List<Empleados> empleado;
	
	public Proyecto(String nombre, String dni_jefe, List<Empleados> empleado) {
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

	public List<Empleados> getEmpleado() {
		if(empleado == null)
			return new ArrayList<Empleados>();
		return empleado;
	}

	public void setEmpleado(List<Empleados> empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
	
	

}
