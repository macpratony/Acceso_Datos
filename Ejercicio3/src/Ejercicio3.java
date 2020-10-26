//3.	DADO UN NOMBRE DE DIRECTORIO Y UN FICHERO, SE BORRARÁ ESE FICHERO DEL DIRECTORIO (BUSCÁNDOLO TAMBIÉN EN TODOS SUS SUBDIRECTORIOS).



import java.io.File;



import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio3 {
	static final Logger logger = LogManager.getLogger(Ejercicio3.class);
	
	public static void recursivo(File directorio,String archivo) {
		
	try {
		
	
		File[] archivos = directorio.listFiles();
		
			for(int i=0; i<archivos.length; i++) {
				
							
					if(archivos[i].isDirectory()) {
						
							recursivo(archivos[i],archivo);
									
				
					}
						
						if(archivos[i].getName().equals(archivo)) {
							archivos[i].delete();
							
						
						}
				
			}


	} catch (NullPointerException e) {
		logger.error("El directorio no existe");
	}
	}
	
	

	public static void main(String[] args) {
	
		String cadena = JOptionPane.showInputDialog("Ingrese el nombre del directorio");
		String archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo que desea eliminar");

		
			File directorio = new File (cadena);
			
			recursivo(directorio, archivo);
		
	}

}
