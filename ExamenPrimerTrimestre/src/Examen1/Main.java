package Examen1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		
		JOptionPane.showMessageDialog(null, "OPCIONES DEL MENU \n 1.- A�adir producto \n 2.- Comprar producto \n 3.- Producto mas caro");
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
		
		}

	}
	
}
