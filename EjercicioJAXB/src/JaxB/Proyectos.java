package JaxB;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proyectos {
	
	List<Proyecto> proyecto;

	public Proyectos(List<Proyecto> proyecto) {
		super();
		this.proyecto = proyecto;
	}

	public Proyectos() {
	
	}

	public List<Proyecto> getProyecto() {
		
		/*if(proyecto == null)
			return new ArrayList<Proyecto>();*/
		
		return proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	
	

}
