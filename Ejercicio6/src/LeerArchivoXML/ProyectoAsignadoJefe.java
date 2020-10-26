package LeerArchivoXML;

import javax.swing.JOptionPane;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProyectoAsignadoJefe {
	static String proyectos = "";
	public static void jefeProyectosAsignado(Node raiz, String dni) {
		
		NodeList primero = raiz.getChildNodes(); //Extraemos la lista de nodos de todo el documento xml
		for(int i=0; i<primero.getLength(); i++) {//Recorremos la lista de nodos
			if(primero.item(i).getNodeName() == "proyecto"){ //Y aquí preguntamos si en la etiqueta donde nos encontramos es igual a proyecto y si lo es entramos
				NodeList proyecto = primero.item(i).getChildNodes(); //Extraemos la lista de nodos que se encuentra dentro de la etiqueta proyecto
				for(int j=0; j<proyecto.getLength();j++) {			//Y volvemos a recorrer la lista de nodos que hemos extraido
					//Y preguntamos si en la etiqueta que esta recorriendo el for corresponde a dni__jefe si lo es comparamos tambien si el contenido es igual al dni que pasamos por parametros
					//Si se cumple las dos opciones es que hemos encontrado al jefe con ese dni por lo tanto cogemos el nombre del proyecto
					if(proyecto.item(j).getNodeName().equals("dni_jefe") && proyecto.item(j).getFirstChild().getNodeValue().equals(dni)) { 
						proyectos = proyecto.item(1).getFirstChild().getNodeValue()+"\n"+proyectos; //Para coger el nombre del proyecto nos situamos dentro de la lista de proyecto y extraemos el contenido que se encuentra en la posicion 1
						//Ya que la posicion 0 corresponde a la etiqueta de proyecto
						
					}
					
				}
			}
		}
	
		JOptionPane.showMessageDialog(null,"Los proyectos que dirige el jefe con DNI "+dni+" son:"+"\n"+proyectos );
	}
	
	
}
	


