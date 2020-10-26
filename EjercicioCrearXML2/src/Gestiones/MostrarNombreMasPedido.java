package Gestiones;

import java.util.HashSet;

import javax.swing.JOptionPane;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MostrarNombreMasPedido {
	
	public static void clienteConMasPedidos(Node nodo, Node nodo1) {
		
		HashSet<String> dni = new HashSet<String>();
		String dniPrincipal = "";
		String dniAux = "";
		int contador = 0;
		int contadorAux = 0;
		
		NodeList nodoPedido = nodo.getChildNodes();
		for(int i=0; i<nodoPedido.getLength(); i++) {
			if(nodoPedido.item(i).getNodeType() == Node.ELEMENT_NODE) {
				if(nodoPedido.item(i).getNodeName().equals("pedido")) {
					
					NodeList nodoDni = nodoPedido.item(i).getChildNodes();
					for(int x=0; x<nodoDni.getLength();x++) {
						if(nodoDni.item(x).getNodeType() == Node.ELEMENT_NODE) {
							if(nodoDni.item(x).getNodeName().equals("dni_cliente")) {
								dni.add(nodoDni.item(x).getFirstChild().getNodeValue());
							}
						}
					}
					
				}
			}
		}
		
		for(String d : dni) {
			for(int i=0; i<nodoPedido.getLength(); i++) {
				if(nodoPedido.item(i).getNodeType() == Node.ELEMENT_NODE) {
					if(nodoPedido.item(i).getNodeName().equals("pedido")) {
						
						NodeList nodoDni = nodoPedido.item(i).getChildNodes();
						for(int x=0; x<nodoDni.getLength();x++) {
							if(nodoDni.item(x).getNodeType() == Node.ELEMENT_NODE) {
								if(nodoDni.item(x).getNodeName().equals("dni_cliente")) {
									if(nodoDni.item(x).getFirstChild().getNodeValue().equals(d)) {
										
										dniPrincipal = nodoDni.item(x).getFirstChild().getNodeValue();
										contador++;
									}
								}
							}
						}
					
						
						
					}
				}
			}
			
			if(contador >= contadorAux) {
				contadorAux = contador;
				dniAux = dniPrincipal;
							
			}
						contador = 0;
		}
		
		
		//Recorremos el nodo del archivo clientes.html Para buscar el que mas pedidos tiene
		NodeList nodoCliente = nodo1.getChildNodes();
		for(int i=0; i<nodoCliente.getLength(); i++) {
			if(nodoCliente.item(i).getNodeType() == Node.ELEMENT_NODE) {
				if(nodoCliente.item(i).getNodeName().equals("cliente")) {
					
					NodeList nodoNombre = nodoCliente.item(i).getChildNodes();
					for(int x=0; x<nodoNombre.getLength(); x++) {
						if(nodoNombre.item(x).getNodeType() == Node.ELEMENT_NODE) {
							if(nodoNombre.item(x).getNodeName().equals("dni")) {
								if(nodoNombre.item(x).getFirstChild().getNodeValue().equals(dniAux)) {
									
									JOptionPane.showMessageDialog(null, "El cliente que mas pedidos tiene es: \n" +  nodoNombre.item(1).getFirstChild().getNodeValue());
								}
							}
						}
					}
				}
			}
			
		}
	}

}
