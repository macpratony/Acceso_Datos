package Gestiones;

import javax.swing.JOptionPane;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MostrarPedido {
	
	public static void mostrarPedido(Node nodo) {
		
		String dni = JOptionPane.showInputDialog("Ingrese el dni del cliente");
		String pedidos = "";
		boolean existe = false;
		NodeList nodoPedido = nodo.getChildNodes();
		
		for(int i=0; i<nodoPedido.getLength(); i++) {
			if(nodoPedido.item(i).getNodeType() == Node.ELEMENT_NODE) {
				if(nodoPedido.item(i).getNodeName().equals("pedido")) {
					NodeList nodosPedidos = nodoPedido.item(i).getChildNodes();
					for(int x=0; x<nodosPedidos.getLength(); x++) {
						if(nodosPedidos.item(x).getNodeType() == Node.ELEMENT_NODE) {
							if(nodosPedidos.item(x).getNodeName().equals("dni_cliente")) {
								if(nodosPedidos.item(x).getFirstChild().getNodeValue().equals(dni)) {
									for(int j=0; j<nodosPedidos.getLength();j++) {
										if(nodosPedidos.item(j).getNodeType() == Node.ELEMENT_NODE) {
											if(nodosPedidos.item(j).getNodeName().equals("nombre")) {
												
												pedidos += nodosPedidos.item(j).getFirstChild().getNodeValue()+"\n";
												existe = true;
												
											}
										}
									}
									
										
								}
							}
						}
					}
				}
			}
		}
		if(existe == true) {
			JOptionPane.showMessageDialog(null, pedidos);
		}else {
			JOptionPane.showMessageDialog(null, "El dni introducido no existe en la base de datos");
		}
	}

}
