package es.marco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Elija una de las siguientes opciones");
		System.out.println("1.- Dar de alta un libro");
		System.out.println("2.- Eliminar todos los libros de un autor");
		System.out.println("3.- Mostrar todos los titulos que pertenecen a una tematica dada");
		
		int opciones;
		try {
			opciones = Integer.parseInt(mac.readLine());
		
		
			switch (opciones) {
			
				case 1:
					
					Operaciones.altaLibro();
					
					break;
					
				case 2:
					
				Operaciones.eliminarLibro();
					
					break;
					
				case 3:
					
					
					break;
	
		
				default:
					JOptionPane.showMessageDialog(null, "La opcion que ha seleccionado no es correcta");
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
