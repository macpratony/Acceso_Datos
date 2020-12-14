package Principal;

public class Ireport {
	
	String nombreEmpleado;
	String nombreProyecto;
	
	public Ireport(String nombreEmpleado, String nombreProyecto) {
		super();
		this.nombreEmpleado = nombreEmpleado;
		this.nombreProyecto = nombreProyecto;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	
}
