package Examen1;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

public class Main {

	public static void main(String[] args) {
		
		
		JOptionPane.showMessageDialog(null, "OPCIONES DEL MENU \n 1.- Añadir producto \n 2.- Comprar producto \n 3.- Producto mas caro \n 4.- Generar Pdf");
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion"));
		switch (opcion) {
		case 1:
			Operaciones.anadirProducto();
			break;
			
		case 2:
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
			Operaciones.comprarProductos(nombre);
			break;
			
		case 3:
			Operaciones.productoMasCaro();
			break;
			 
		case 4:
			
			try {
				Operaciones.generarInforme();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		 
		}

	}
	
}
