//3.	DADO UN NOMBRE DE DIRECTORIO Y UN FICHERO, SE BORRARÁ ESE FICHERO DEL DIRECTORIO (BUSCÁNDOLO TAMBIÉN EN TODOS SUS SUBDIRECTORIOS).

package Ejercicios;

import java.io.File;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	public static void recursivo(File directorio,String archivo) {
		
		File[] archivos = directorio.listFiles();
		
		for(int i=0; i<archivos.length; i++) {

			if(archivos[i].getName().equals(archivo)) {
				archivos[i].delete();
				
			}
			
				if(archivos[i].isDirectory()) {
					recursivo(archivos[i],archivo);
				
			}
		}

		
	}

	public static void main(String[] args) {
	
		String cadena = JOptionPane.showInputDialog("Ingrese el nombre del directorio");
		String archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo que desea eliminar");

		
			File directorio = new File (cadena);
			
			recursivo(directorio, archivo);
		
	}

}
