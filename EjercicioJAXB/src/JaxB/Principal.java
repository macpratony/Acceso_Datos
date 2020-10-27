package JaxB;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



import ConvertirClasesAXML.Alumnos;

public class Principal {

	public static void main(String[] args) throws JAXBException {
		/*
		JAXBContext jaxbContext;
		Unmarshaller u;
		
		try {
			
			jaxbContext = JAXBContext.newInstance(Proyectos.class);
			u = jaxbContext.createUnmarshaller();
			Proyectos proyecto = (Proyectos)u.unmarshal(new File("src/proyecto.xml"));
			
			System.out.println(proyecto.getProyecto().size());
			
			
			for(Proyecto p : proyecto.getProyecto()) {
				System.out.println(p.getDni_jefe());
				
			}
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		Emp_Asignados e1 = new Emp_Asignados("111");
		Emp_Asignados e2 = new Emp_Asignados("222");
		Emp_Asignados e3 = new Emp_Asignados("333");
		
		List<Emp_Asignados> emple = new ArrayList<Emp_Asignados>();
				
		emple.add(e1);
		emple.add(e2);
		emple.add(e3);
		
		
		
		Proyecto pro = new Proyecto("Informatica", "0101", emple);
		Proyecto pro1 = new Proyecto("Contabilidad", "0202", emple);
		
		
		Proyectos p = new Proyectos(new ArrayList<Proyecto>());
		
		p.getProyecto().add(pro);
		p.getProyecto().add(pro1);
		
		JAXBContext contexto = JAXBContext.newInstance(Proyectos.class);
		
		Marshaller m = contexto.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		m.marshal(p, new File("proyect.xml"));		
		
			

	}

}
