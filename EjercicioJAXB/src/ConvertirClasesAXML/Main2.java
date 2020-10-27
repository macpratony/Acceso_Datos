package ConvertirClasesAXML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main2 {

	public static void main(String[] args) throws JAXBException {
		
		//Lo que hace este bloque es convertir un fichero XML en clases de java para ello debemos estructurar bien las clases de java
		JAXBContext jaxbContext = JAXBContext.newInstance(Alumnos.class);
		
		Unmarshaller u = jaxbContext.createUnmarshaller();
		
		Alumnos alumnos = (Alumnos)u.unmarshal(new File("alumnos.xml"));
		
		
		
		System.out.println(alumnos.getAlumno().size());
		
		for(Alumno a : alumnos.getAlumno())
			System.out.println(a.getNif());

	}

}
