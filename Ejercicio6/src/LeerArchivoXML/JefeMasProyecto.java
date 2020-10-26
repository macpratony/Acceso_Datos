package LeerArchivoXML;

import javax.swing.JOptionPane;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JefeMasProyecto {
	
	
	public static void proyectoMasDirigeJefe(Node raiz) {
		String dniJefe = "";
		String dniMas = "";
		int contador = 0;
		int contadorAux = 0;
		
		NodeList primero = raiz.getChildNodes(); 										//Extraemos las listas del nodo raiz
		for(int i=0; i< primero.getLength(); i++) { 									//Recorremos la lista
			if(primero.item(i).getNodeName().equals("proyecto")) { 						//Preguntamos si en el nodo que se encuentra corresponde a una etiqueta llamada proyecto, si lo es entra
				NodeList proyecto = primero.item(i).getChildNodes();		 			//Obtenemos todo lo que tiene ese nodo de proyecto
				for(int j=0; j<proyecto.getLength(); j++) {   							//Volvemos a recorrerlo en busca de otra etiqueta llamada dni_jefe que es lo que necesitamos para ver que jefe dirige mas proyectos
					if(proyecto.item(j).getNodeName().equals("dni_jefe")) { 			//Si en el nodo que se encuentra es la etiqueta dni_jefe entra
						dniJefe = proyecto.item(j).getFirstChild().getNodeValue(); 		//Y extrae el contenido de la etiqueta que en este caso seria el dni del jefe
			/*Aquí para cada dni que va cogiendo volvemos hacer que recorra de nuevo todos los nodos empezando desde el principio y esto no lo conseguimos metiendo un bucle for que empiece a recorrerlo desde el inicio*/			
						for(int m=0; m<primero.getLength(); m++) { //Como estamos recorriendo desde el inicio tenemos que de nuevo encontrar las etiquetas de proyecto y el dni_jefe
							if(primero.item(m).getNodeName().equals("proyecto")) { 		//Si es la etiqueta de proyecto entra
								NodeList segundo = primero.item(i).getChildNodes(); 	//Volvemos a desplegar todo el contenido del nodo de proyecto en otra lista
								for(int l=0; l<segundo.getLength();l++) { 				//Recorremos en busca de la etiqueta dni_jefe
					/*Aqui viene la parte interesante porque preguntamos que en el nodo donde se encuentra existe la etiqueta del dni_jefe y si existe ademas le decimos que si el contenido de esa etiqueta corresponde
					 * con el dni que habiamos obtenido anteriormente*/				
									if(segundo.item(l).getNodeName().equals("dni_jefe") && segundo.item(l).getFirstChild().getNodeValue().equals(dniJefe)) { 
										contador++; //Contará mas 1 por cada dni que sea igual al que estamos comparando
									}
								}
							}
						}
						/*Despues de todo el recorrido de cada dni comprueba si el contador es mayor o igual al que hemos creado que al principio será 0 pero una vez que entre su valor cambiará*/
						if(contador >= contadorAux ) {
							contadorAux = contador;
							dniMas = dniJefe;
							contador = 0;
						}
						
						
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "El DNI del jefe que mas proyecto dirige es: \n"+dniMas);
	}
	
}
