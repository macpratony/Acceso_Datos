

import java.io.File;



import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//1.	REALIZAR UN PROGRAMA QUE MUESTRE EL CONTENIDO DE UN DIRECTORIO QUE SE SOLICITA. 
// DE SU CONTENIDO MOSTRARÁ NOMBRE DE DIRECTORIOS, DE FICHEROS, Y EN CASO DE ESTOS ÚLTIMOS, SU TAMAÑO EN BYTES.

public class Ejercicio1 {
	
	 static final Logger logger = LogManager.getLogger(Ejercicio1.class);
	 
	public static void main(String[] args) {
		
		 try {
			
		
		
			String solicitar = JOptionPane.showInputDialog("Ingrese el directorio ");
		
			
		
		
		
		File archivo = new File(solicitar);
		
		File[] nuevos = archivo.listFiles();
		
		for (File ff : nuevos) {
			if(ff.isDirectory()) {
				System.out.println(ff.getName());
			}else {
				System.out.println("El nombre del archivo es "+ ff.getName() + " y el tamaño "+ ff.length());
			}
		}
		
		
		} catch (NullPointerException e) {
			logger.error("El directorio no existe");
		
		}
		

	}

}
