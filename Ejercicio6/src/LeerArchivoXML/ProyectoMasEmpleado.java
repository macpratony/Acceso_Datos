package LeerArchivoXML;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProyectoMasEmpleado {
	
	public static void proyectoConMasEmpleados(Node raiz) {
		int contador = 0;
		String proyectoEmpleados = "";
		
		NodeList primero = raiz.getChildNodes();
		for(int i=0;i<primero.getLength();i++) {
			if(primero.item(i).getNodeName().equals("proyecto")) {
				NodeList proyecto = primero.item(i).getChildNodes();
				for(int j=0; j<proyecto.getLength(); j++) {
					if(proyecto.item(j).getNodeName().equals("emp_asignados")) {
						NodeList empleadosAsignados = proyecto.item(j).getChildNodes();
						if(empleadosAsignados.getLength() >= contador) {
							proyectoEmpleados = proyecto.item(1).getFirstChild().getNodeValue();
							contador = empleadosAsignados.getLength();
							
						}
					}
				}
			}
		}
		System.out.println(proyectoEmpleados);
	}

}
