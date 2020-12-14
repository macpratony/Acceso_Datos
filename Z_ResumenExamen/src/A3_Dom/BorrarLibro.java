package A3_Dom;


import java.io.File;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BorrarLibro {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		
		    
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      	DocumentBuilder builder = factory.newDocumentBuilder();
		
      	
      	Document document = builder.parse( new File("src/libros.xml"));
      	
      
      
      	Node nodo = document.getFirstChild();
      	//	Recursividad.recursivo(nodo);
      	      	      	
      	NodeList nodos = document.getChildNodes();
      	System.out.println(nodos.getLength());
      	
      	/*for(int i=0;i<nodos.getLength();i++)
      		System.out.println(nodos.item(i).getNodeName());
		*/
      	
		 Recursividad.recursivo(nodos);
      	
		//Node raiz = nodos.item(0);
		
		String autor = null, titulo = null;
		
		//NodeList nodos2 = raiz.getChildNodes();
		
		
		/*for(int i=0;i<nodos2.getLength();i++) {
			
			Node libro = nodos2.item(i);
			
			if(libro.getNodeType()==Node.ELEMENT_NODE) {
				
				NodeList hijos_libro = libro.getChildNodes();
				
				for(int j=0;j<hijos_libro.getLength();j++) {
					
					if(hijos_libro.item(j).getNodeType()==Node.ELEMENT_NODE) {
						
						if(hijos_libro.item(j).getNodeName().equals("autor"))
							autor = hijos_libro.item(j).getFirstChild().getNodeValue();
						
						if(hijos_libro.item(j).getNodeName().equals("titulo"))
							titulo = hijos_libro.item(j).getFirstChild().getNodeValue();
						
					}
					
				}//for que recorre los hijos de cada libro
				
				System.out.println("El libro "+(i+1)+ " tiene de título "+titulo+" y de autor "+autor);
			}
			
		}// for que recorre todos los libros
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		Node raiz = document.getFirstChild();
		
		NodeList nodes = raiz.getChildNodes();
		
		Node listaLibros = nodes.item(1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Introduzca autor a eliminar:");
		Scanner scan = new Scanner(System.in);
		String nombre = scan.nextLine();
		
		NodeList libros = listaLibros.getChildNodes();
		
		for(int i=0;i<libros.getLength();i++) {
			
			if(libros.item(i).getNodeType() == Node.ELEMENT_NODE) {
				
				NodeList datosLibro = libros.item(i).getChildNodes();
				for(int j=0;j<datosLibro.getLength();j++) {
					
					if(datosLibro.item(j).getNodeType() == Node.ELEMENT_NODE)
						if(datosLibro.item(j).getNodeName().equals("autor")) {
							if(datosLibro.item(j).getFirstChild().getNodeValue().equals(nombre))
								//listaLibros.removeChild(libros.item(i));
								datosLibro.item(j).getFirstChild().setNodeValue("Michael Ende");
								
						}
				}
				
				
				
			}
		}
		
		Source src = new DOMSource(document); 
		Result result = new StreamResult(new File("libros2.xml"));
		
		Transformer trf = TransformerFactory.newInstance().newTransformer();
		
		trf.transform(src, result);
		
		
		*/


	}

}