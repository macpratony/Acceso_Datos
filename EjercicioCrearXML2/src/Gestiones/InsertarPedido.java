package Gestiones;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class InsertarPedido {
	
	public static void insertaPedido(Node nodo, Document doc) throws TransformerFactoryConfigurationError, TransformerException {
		
		/*Recibe por parametro el nodo raiz PEDIDOS y a traves de ello 
		 * empieza a contruir un nuevo arbol
		 */
		
		Element nodo_pedido = doc.createElement("pedido"); //Crea el sub nodo principal
		nodo.appendChild(nodo_pedido); //Asigna al arbol el pedido creado
		
		Element nodoid = doc.createElement("id"); //Crea la siguiente etiqueta que va dentro de pedido
		nodo_pedido.appendChild(nodoid); //lo mete dentro de la etiqueta pedido
		String idProducto = JOptionPane.showInputDialog("Ingrese el id del producto"); //Solicita por teclado el valor que va dentro de la etiqueta id
		Text texto_nodoid = doc.createTextNode(idProducto); //transforma el dato recibido 
		nodoid.appendChild(texto_nodoid); //introduce el dato recibido dentro de la etiqueta id
		
		Element nodoNombre = doc.createElement("nombre");
		nodo_pedido.appendChild(nodoNombre);
		String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
		Text texto_nombre = doc.createTextNode(nombreProducto);
		nodoNombre.appendChild(texto_nombre);
		
		Element nodoDni = doc.createElement("dni_cliente");
		nodo_pedido.appendChild(nodoDni);
		String dniCliente = JOptionPane.showInputDialog("Ingrese el dni del cliente");
		Text texto_dni = doc.createTextNode(dniCliente);
		nodoDni.appendChild(texto_dni);
		
		
		Source source = new DOMSource(doc);		//Crea una fuente DOM asociada al árbol DOM
		
		Result result = new StreamResult(new java.io.File("pedidos.xml"));	//La fuente le asociamos al nombre del fichero
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();	//Se crea un objeto transformador
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");		/*Ordenes que se le dan al tranformador para que tenga en cuenta ciertas cosas*/ 
		/*En este caso la orden lo que hace es crear un árbol visul bonito sin esa orden saldria todas las etiquetas seguidas */
		
		transformer.transform(source, result);		//Ese objeto tranformador transforma la fuente del árbol DOM al fichero 
		
	}
	

}
