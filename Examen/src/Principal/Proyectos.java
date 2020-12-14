package Principal;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proyectos {
	
	List<Proyecto> proyecto;
	
	public Proyectos() {
		
	}

	public Proyectos(List<Proyecto> proyecto) {
		super();
		this.proyecto = proyecto;
	}

	public List<Proyecto> getProyecto() {
		return proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	
	

}
