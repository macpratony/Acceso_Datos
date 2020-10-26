package PracticandoDom;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Recursividad {
	//Recibe por parametro un lista de nodos para extraer la raiz
	static void recursivo(NodeList principal) {
		
		Node raiz = principal.item(0); //Extrae el nodo principal 
		NodeList nodos = raiz.getChildNodes();// Combierte en una lista todos los nodos
		
		/*Recorremos la lista de nodos para ir exminando cada nodo, y a cada nodo le preguntamos si el nodo donde se 
		 * encuentra corresponde a un elemento nodo o que es lo mismo que no corresponda a un salto de linea, 
		 * si es asi vuelve a llamarse asi mismo e imprimimos el nombre del nodo donde se encuentra en ese momento*/
		/*
		 * Est o funciona pasandole un nodo por parametro
		if(principal != null) {
			if(principal.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(principal.getNodeName() +"-------- "+principal.getFirstChild().getNodeValue());
			}
			
			NodeList hijos = principal.getChildNodes();
			for(int i=0; i<hijos.getLength();i++) {
				Node nietos = hijos.item(i);
				recursivo(nietos);
			}
			
		}*/
		for(int i=0; i<nodos.getLength();i++) {
			Node primero = nodos.item(i);
			if(primero.getNodeType() == Node.ELEMENT_NODE) {
				
							System.out.println(primero.getFirstChild().getNodeName());
						
						recursivo(primero.getChildNodes());	
				/*Guardamos en el boolean el valor de preguntar si en el nodo donde nos encontramos contiene un atributo
				 * y preguntamos si el nodo es igual a true imprimimos su atributo caso contrario solo imprimimos su nodo */
						}
			
						boolean atri = primero.hasAttributes();  
						if(atri == true)
						System.out.println(primero.getNodeName()+ " "+ primero.getAttributes().item(0));
						else
							System.out.println(primero.getNodeName());
					
			
			/*Si ya no se vuelve a llamar asi mismo empieza analizando en el nodo donde se encuentra para extraer 
			* el contenido de cada nodo*/

			if(primero.getNodeType() == Node.ELEMENT_NODE) { //Si no se corresponde con un salto de linea
				NodeList segundo = primero.getChildNodes();
				for(int j=0; j<segundo.getLength(); j++) {
					Node tercero = segundo.item(j);
					if(tercero.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(tercero.getNodeName() +" "+tercero.getFirstChild().getNodeValue());
					}
					
				}
				System.out.println();//Agrega un espacio entre etiqueta y etiqueta

			}


			}
		
		
		
		
		
		
		
		
	
	}
	
}
