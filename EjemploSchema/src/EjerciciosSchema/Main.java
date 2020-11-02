package EjerciciosSchema;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Main {

	public static void main(String[] args) {
		try {
			Libro l = new Libro();
			
			
			l.setTitulo("Angeles y demonios");
			l.setEditorial("Planeta");
			l.getAutores().add("Dan Brown");
			l.setPrecio(20.0);
			
			/*
			JAXBContext contexto = JAXBContext.newInstance(Libro.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(l, new File("libros.xml"));*/
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Libro.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			Libro proyecto = (Libro)u.unmarshal(new File("libros.xml"));
			
			System.out.println(proyecto.getTitulo());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
