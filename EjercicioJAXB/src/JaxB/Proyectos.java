package JaxB;

import java.util.ArrayList;
import java.util.List;

public class Proyectos {
	
	List<Proyecto> pro;

	public Proyectos(List<Proyecto> pro) {
		super();
		this.pro = pro;
	}

	public Proyectos() {
		super();
	}

	public List<Proyecto> getPro() {
		
		if(pro == null)
			return new ArrayList<Proyecto>();
		
		return pro;
	}

	public void setPro(List<Proyecto> pro) {
		this.pro = pro;
	}
	
	

}
