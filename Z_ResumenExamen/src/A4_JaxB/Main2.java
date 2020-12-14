package A4_JaxB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main2 {

	public static void main(String[] args) throws JAXBException {
		
		//Lo que hace este bloque es convertir un fichero XML en clases de java para ello debemos estructurar bien las clases de java
		//Para que pueda hacer la conversion hay que anular la inicializacion del arrayList en el get
		JAXBContext jaxbContext = JAXBContext.newInstance(Alumnos.class);
		
		Unmarshaller u = jaxbContext.createUnmarshaller();
		
		Alumnos alumnos = (Alumnos)u.unmarshal(new File("alumnos.xml")); //Vuelca toda la informacion del xml a la clase principal que
																		 // esta a su vez distribuye la informacion a las demas clases				
		
		System.out.println(alumnos.getAlumno().size());
		
		for(Alumno a : alumnos.getAlumno()) //iteramos sobre el objeto que se ha volcado la informacion
			System.out.println(a.getNif());
		
		//Modificar un dato
		
		for(int i=0; i<alumnos.getAlumno().size(); i++) {
			if(alumnos.getAlumno().get(i).getNombre().equals("carlos")) {
				alumnos.getAlumno().get(i).getAsignaturas().get(i).setNombre("FISICA");
			}
			
		}
		//Una vez que se modifica el dato se vuelve a volcar la informacion al xml
		
		JAXBContext contexto = JAXBContext.newInstance(Alumnos.class); //Se pasa como argumento la clase principal que contiene @XmlRootElement 
		
		Marshaller m = contexto.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		m.marshal(alumnos, new File("alumnos.xml"));  //Asignamos un nombre al fichero que nos va a generar

	}

}
