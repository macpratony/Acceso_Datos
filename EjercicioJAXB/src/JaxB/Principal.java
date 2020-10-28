package JaxB;

import java.io.File;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {

	public static void main(String[] args) throws JAXBException {
		
		/*JAXBContext jaxbContext;
		Unmarshaller u;
		
		try {
			
			jaxbContext = JAXBContext.newInstance(Proyectos.class);
			u = jaxbContext.createUnmarshaller();
			Proyectos proyecto = (Proyectos)u.unmarshal(new File("proyect.xml"));
			
			System.out.println(proyecto.getProyecto().size());
			
			
			for(Proyecto p : proyecto.getProyecto()) {
				System.out.println(p.getDni_jefe());
				
			}
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		List<String> d = new ArrayList<String>();
		d.add("111");
		d.add("222");
		d.add("333");
		
		List<String> d1 = new ArrayList<String>();
		d1.add("444");
		d1.add("666");
		
		Emp_Asignados em = new Emp_Asignados(d);
		Emp_Asignados e = new Emp_Asignados(d1);
		
		
		
		Proyecto pro = new Proyecto("Informatica", "0101", em);
		Proyecto pro1 = new Proyecto("Contabilidad", "0202", e);
		
		
		Proyectos p = new Proyectos(new ArrayList<Proyecto>());
		
		p.getProyecto().add(pro);
		p.getProyecto().add(pro1);
		
		
		JAXBContext contexto = JAXBContext.newInstance(Proyectos.class);
		
		Marshaller m = contexto.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		m.marshal(p, new File("proyecto.xml"));		
		
			

	}

}
