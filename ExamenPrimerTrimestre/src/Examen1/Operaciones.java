package Examen1;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class Operaciones {

	public static void anadirProducto() {
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
			builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(new File("listapedidos.xml"));
			
			Node nodo = doc.getFirstChild();
			
			Element nodo_pedido = doc.createElement("producto"); //Crea el sub nodo principal
			nodo.appendChild(nodo_pedido); //Asigna al arbol el pedido creado
			
			Element nodoid = doc.createElement("nombre"); //Crea la siguiente etiqueta que va dentro de pedido
			nodo_pedido.appendChild(nodoid); //lo mete dentro de la etiqueta pedido
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto"); //Solicita por teclado el valor que va dentro de la etiqueta id
			Text texto_nombre = doc.createTextNode(nombre); //transforma el dato recibido 
			nodoid.appendChild(texto_nombre); //introduce el dato recibido dentro de la etiqueta id
			
			Element nodoNombre = doc.createElement("cantidad");
			nodo_pedido.appendChild(nodoNombre);
			String nombreProducto = JOptionPane.showInputDialog("Ingrese la cantidad del producto");
			Text texto_nombrePro = doc.createTextNode(nombreProducto);
			nodoNombre.appendChild(texto_nombrePro);
			
			Element nodoPrecio = doc.createElement("precioUnidad");
			nodo_pedido.appendChild(nodoPrecio);
			String precio = JOptionPane.showInputDialog("Ingrese el precio");
			Text texto_precio = doc.createTextNode(precio);
			nodoPrecio.appendChild(texto_precio);
			
			Element nodoPen = doc.createElement("pendiente");
			nodo_pedido.appendChild(nodoPen);
			Text texto_pen = doc.createTextNode("si");
			nodoPen.appendChild(texto_pen);
			
			Source source = new DOMSource(doc);		//Crea una fuente DOM asociada al árbol DOM
			
			Result result = new StreamResult(new java.io.File("listapedidos.xml"));	//La fuente le asociamos al nombre del fichero
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();	//Se crea un objeto transformador
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");		/*Ordenes que se le dan al tranformador para que tenga en cuenta ciertas cosas*/ 
			/*En este caso la orden lo que hace es crear un árbol visul bonito sin esa orden saldria todas las etiquetas seguidas */
			
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		
	}
	
	public static void comprarProductos(String nombre) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
		
			
				builder = dbf.newDocumentBuilder();
			
			Document doc = builder.parse(new File("listapedidos.xml"));
			
			Node nodo = doc.getFirstChild();
			
			NodeList nodoProducto = nodo.getChildNodes();
			for(int i=0; i<nodoProducto.getLength();i++) {
				if(nodoProducto.item(i).getNodeType() == Node.ELEMENT_NODE) {
					if(nodoProducto.item(i).getNodeName().equals("producto")) {
						
						NodeList nodoNombre = nodoProducto.item(i).getChildNodes();
						for(int x=0; x<nodoNombre.getLength(); x++) {
							if(nodoNombre.item(x).getNodeType()== Node.ELEMENT_NODE) {
								if(nodoNombre.item(x).getNodeName().equals("nombre")) {
									
									String nombreProducto = nodoNombre.item(x).getFirstChild().getNodeValue();
									if(nombreProducto.equals(nombre)) {
										
										if(nodoNombre.item(x).getNodeName().equals("pendiente")) {
											
										}
										
									}
								}
							}
						}
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void productoMasCaro() {
		
;
		try {
			
				JAXBContext jaxbContext = JAXBContext.newInstance(ListaCompra.class);
				Unmarshaller u = jaxbContext.createUnmarshaller();
				ListaCompra compra = (ListaCompra)u.unmarshal(new File("listapedidos.xml"));
				
				int precioActual = 0;
				int precio=0;
				String nombre = "";
				
				for (Producto c : compra.getProducto()) {
					precioActual = Integer.parseInt(c.getPrecioUnidad());
					if(precioActual > precio) {
						precio = precioActual;
						nombre = c.getNombre();
					}
				}
				System.out.println("El producto mas caro es "+nombre+ " con precio "+precio);
				
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void generarInforme() throws JAXBException {
		try {
		
			JAXBContext jaxbContext = JAXBContext.newInstance(ListaCompra.class);
		Unmarshaller u = jaxbContext.createUnmarshaller();
		ListaCompra compra = (ListaCompra)u.unmarshal(new File("listapedidos.xml"));
		ArrayList<Ireport> report = new ArrayList<>();
		
		for (Producto c : compra.getProducto()) {
			String pendiente = c.getPendiente();
			if(pendiente.equals("si")) {
				
			}
				
		}
		
		String reportSource = "./Mireport/Mireport2.jrxml"; //
	
		String reportPDF = "Informe.pdf";
		


		
		
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
			
			
			
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(report);
			
			JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, null , datasource);
			
			
			JasperViewer.viewReport(MiInforme);
		
			JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}
