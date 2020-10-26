package LeerArchivoXML;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Principal {
	
	static final Logger logger = LogManager.getLogger(Principal.class);
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		
		Document documento = builder.parse(new File("src/proyecto.xml"));
		
		Node nodo = documento.getFirstChild();
		
		String opciones = "";
		int numero_opcion=0;
		
			JOptionPane.showMessageDialog(null, "SELECCIONE LA OPCION QUE DESEE\n\n"+"1   Dado un dni, mostrar los proyectos a los que está asignado\n\n"+
										"2   Mostrar el nombre de proyecto con mas empleados\n\n"+"3   Mostrar el dni del jefe que dirige mas proyectos");
			try {
				numero_opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion"));
			} catch (Exception e) {
				System.out.println("Se ha producido un error");
				logger.error("No se ha ingresado un dato de tipo numerico");
			}
			
				switch (numero_opcion) {
				
				case 1: 
					
					String dni = JOptionPane.showInputDialog("Ingrese el dni a consultar");
					 ProyectoAsignadoJefe.jefeProyectosAsignado(nodo, dni);
					
					
					break;
				
				case 2:
					
					ProyectoMasEmpleado.proyectoConMasEmpleados(nodo);
					
					break;
				
				case 3:
					
					
					JefeMasProyecto.proyectoMasDirigeJefe(nodo);
				
					
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Se ha ingresado una opcion no valida");
					logger.error("Se ha ingresado una opción no valida");
				}
						
		
		
	}

}
