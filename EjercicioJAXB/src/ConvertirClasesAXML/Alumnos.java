package ConvertirClasesAXML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Alumnos {
	
	
	List<Alumno> alumno;
	
	public Alumnos() {
		
	}

	public Alumnos(List<Alumno> alumno) {
		super();
		this.alumno = alumno;
	}

	public List<Alumno> getAlumno() {
		
		/*if(alumno == null)
			return new ArrayList<Alumno>();*/
		
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}
	
	

}
