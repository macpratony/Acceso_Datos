package ConvertirClasesAXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class Main {

	public static void main(String[] args) throws JAXBException {
		
		
		Asignatura a1 = new Asignatura("lengua","javi");
		Asignatura a2 = new Asignatura("mates","ana");
		
		List<Asignatura> asigs = new ArrayList<>();
		
		asigs.add(a1);
		asigs.add(a2);
		
		
		Alumno al1 = new Alumno("carlos","111","10",asigs);
		
		Alumno al2 = new Alumno("silvia","222","8",asigs);
		
		Alumnos a = new Alumnos(new ArrayList<Alumno>());
		
		a.getAlumno().add(al1);
		a.getAlumno().add(al2);
		
		//Todo el bloque de acontinuacion lo que hace es tranformar las clases de java a un fichero XML
		JAXBContext contexto = JAXBContext.newInstance(Alumnos.class);
		
		Marshaller m = contexto.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		m.marshal(a, new File("alumnos.xml"));
		
		

	}

}
