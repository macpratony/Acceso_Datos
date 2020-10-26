package Ejercicios;

import java.io.File;

import javax.swing.JOptionPane;

//2.	DADO UN NOMBRE DE DIRECTORIO, MOSTRAR TODO SU CONTENIDO, 
	//INCLUYENDO EL CONTENIDO DE TODOS LOS SUBDIRECTORIOS (SE HARÁ DE FORMA RECURSIVA).

public class Ejercicio2 {
	
	public static void recursivo(File directorio) {
		File [] archivos = directorio.listFiles();
		
		for(int i=0; i<archivos.length; i++) {
			System.out.println(archivos[i].getName());
			if(archivos[i].isDirectory()) {
				System.out.println("*************************************");
				recursivo(archivos[i]);
			}
			
		}
		
	}
	
	public static void main(String [] args) {
		String nombre = JOptionPane.showInputDialog("Ingrese el directorio");
		File directorio = new File(nombre);
		
		recursivo(directorio);
		
		
	}
	
	
	
	
}



     