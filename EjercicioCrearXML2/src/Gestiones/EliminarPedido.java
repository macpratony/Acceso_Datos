package Gestiones;

import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EliminarPedido {
	
	public static void eliminaPedido(Document documento) {
		String idPedido = JOptionPane.showInputDialog("Ingrese el id del pedido");
		
		Node raiz = documento.getFirstChild();
		
		NodeList nodoPedido = raiz.getChildNodes();
		
		for(int i=0; i<nodoPedido.getLength(); i++) {
			if(nodoPedido.item(i).getNodeType() == Node.ELEMENT_NODE) {
				if(nodoPedido.item(i).getNodeName().equals("pedido")) {
					NodeList nodoId = nodoPedido.item(i).getChildNodes();
					Node root = nodoPedido.item(i);
						System.out.println(root.getNodeName());
					for(int x=0; x<nodoId.getLength(); x++) {
						
						if(nodoId.item(x).getNodeType() == Node.ELEMENT_NODE) {
							if(nodoId.item(x).getNodeName().equals("id")){
								if(nodoId.item(x).getFirstChild().getNodeValue().equals(idPedido)) {
									
										raiz.removeChild(root);		

								}
							}
									
								
								
							}
						}
					}
				}
			}
		
		
		}
		
}
