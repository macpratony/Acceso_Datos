package EjercicioXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXML {

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Para crear un arbol DOM vacio
		Document doc = builder.newDocument();
		
		//Creamos un árbol DOM ya con nodo raíz
		//Normalmente es la que más se usa
		DOMImplementation implementacion = builder.getDOMImplementation();
		Document doc2 = implementacion.createDocument(null, "Libros", null); //Creamos el nodo principal
		
		Element nodo_libro1 = doc2.createElement("Libro");
		
		doc2.getFirstChild().appendChild(nodo_libro1); 	//A la raíz del árbol le añadimos un nodo hijo 
		
		Element nodo_libro2 = doc2.createElement("Libro");
		
		doc2.getFirstChild().appendChild(nodo_libro2); 	//Se añade otro hijo al árbol raíz 
		
		/*OBSERVACION
		 * Para asignar un nodo texto a un nodo hay que crear para cada nodo un nodo texto diferente, no se le puede 
		 * asignar el mismo nodo texto a dos nodos
		 */
		
		Text texto_libro1 = doc2.createTextNode("Hola");  //Creamos un nodo texto para añadirle a un nodo
		nodo_libro1.appendChild(texto_libro1);   //Hemos añadido el nodo texto al nodo_libro1
		
		Text texto_libro2 = doc2.createTextNode("Siguiente");
		nodo_libro2.appendChild(texto_libro2);
		
		//doc2.getFirstChild().removeChild(nodo_libro1);  //Este metodo lo que hace es eliminar un nodo en concreto
		
				//Todo el bloque siguiente lo que hace es pasar un árbol DOM a un fichero XML
				Source source = new DOMSource(doc2);		//Crea una fuente DOM asociada al árbol DOM
				
				Result result = new StreamResult(new java.io.File("Libros.xml"));	//La fuente le asociamos al nombre del fichero
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();	//Se crea un objeto transformador
				transformer.setOutputProperty(OutputKeys.INDENT,"yes");		/*Ordenes que se le dan al tranformador para que tenga en cuenta ciertas cosas*/ 
				/*En este caso la orden lo que hace es crear un árbol visul bonito sin esa orden saldria todas las etiquetas seguidas */
				
				transformer.transform(source, result);		//Ese objeto tranformador transforma la fuente del árbol DOM al fichero 
	}

}
