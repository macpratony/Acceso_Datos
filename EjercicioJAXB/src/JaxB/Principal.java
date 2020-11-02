package JaxB;

import java.io.File;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {

	public static void main(String[] args) throws JAXBException {
		 
		
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Proyectos.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			Proyectos proyecto = (Proyectos)u.unmarshal(new File("proyecto.xml"));
			
			
			JOptionPane.showMessageDialog(null, "INGRESE UNA DE LAS SIGUIENTES OPCIONES \n\n"+"Opcion 1: Jefe con mas proyectos \n"+"Opcion 2: Proyecto asignado a un jefe\n"+"Opcion 3: Proyecto con mas empleados");
			int numeroOpcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion"));
			
			switch (numeroOpcion) {
				case 1: 
					Set<String> dniJefe = new HashSet<String>();
					int contador=0;
					int contadorMaximo = 0;
					String dniMas = "";
					
					for(Proyecto p : proyecto.getProyecto()) {
						dniJefe.add(p.getDni_jefe());
					}
					
					for(String d : dniJefe) {
						for(Proyecto p : proyecto.getProyecto()) {
							if(d.equals(p.dni_jefe)) {
								contador++;
			
							}
						}
						if(contador > contadorMaximo) {
							contadorMaximo = contador;
							dniMas = d;	
						}
						contador = 0;
					}
					
					JOptionPane.showMessageDialog(null, "El DNI del jefe que mas proyecto dirige es....: \n"+dniMas);
				
					break;
				
				case 2:
					String dni = JOptionPane.showInputDialog("Ingrese el dni del cual desea obtener informacion");
					String proyectosJefe = "";
					
					for(Proyecto p : proyecto.getProyecto()) {
						if(dni.equals(p.getDni_jefe())) {
							proyectosJefe += p.getNombre()+"\n";
						}
					}
					
					JOptionPane.showMessageDialog(null, "El jefe con dni "+dni+" tiene a su cargo los siguientes proyectos \n"+proyectosJefe);
					
					break;
					 
				case 3:
					String proyectoMasEmpleado = "";
					int cont = 0;
					int contMax = 0;
					
					for(Proyecto p : proyecto.getProyecto()) {
						cont = p.getEmp_asignados().getDni().size();
						
						if(cont > contMax) {
							contMax = cont;
							proyectoMasEmpleado = p.getNombre();
						}
						cont = 0;
					}
					JOptionPane.showMessageDialog(null, "El proyecto con mas empledados es :\n"+proyectoMasEmpleado);
					break;
				}
		
				
			
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "El valor introducido tiene que ser numerico");
		}
		
		/*El siguiente bloque crea un archivo xml a partir de las clases
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
		
		m.marshal(p, new File("proyect.xml"));		*/
		
			

	}

}
