package es.marco;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));
		
		
		int opciones = Integer.parseInt(JOptionPane.showInputDialog("SELECCIONA LA OPCION QUE DESEAS: \n "
				+ "1.- Insertar un nuevo menú \n"
				+ "2.- Dado el codigo del menu, recuperar los nombres de los platos que lo forman \n"
				+ "3.- Dado el nombre de un plato, mostrar todos los menus que lo contienen \n"
				+ "4.- Dado el codigo de menu, mostrar su precio \n"
				+ "5.- Mostrar los nombres de restaurantes donde se sirve el menu mas caro \n"
				+ "6.- Añadir un plato a un menu dado su codigo"));
		
		switch (opciones) {
		
			case 1:
				
				OperacionesMenus.insertarNuevoMenu();
				
				break;
				
			case 2:
				
				OperacionesMenus.recuperarNombresPlatos();
				
				break;
				
			case 3:
				OperacionesMenus.mostrarMenuPlatos(); 
				
				break;
				
			case 4:
				
				OperacionesMenus.mostrarPrecio();
				break;
				
			case 5:
				
				OperacionesMenus.menuMasCaro();
				
				break;
				
			case 6:
				
				OperacionesMenus.anadirPlatoMenu();
				
				break;
	
			default:
				JOptionPane.showMessageDialog(null, "La opcion que ha seleccionado no es correcta");
		}

	}

}
