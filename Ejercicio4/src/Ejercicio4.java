//4.	DIVIDIR UN FICHERO DE TEXTO EN TANTAS PORCIONES COMO INDIQUE UN NÚMERO ENTERO QUE SE SOLICITARÁ.



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ejercicio4 {
	
	public static void main (String [] args ) throws IOException {
		
		String fichero = JOptionPane.showInputDialog("Ingrese el nombre del archivo");
		int particiones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de particiones el que desea el archivo"));
		int contador = 1; //CONTADOR PARA ENUMERAR LOS ARCHIVOS QUE SE CREAN
		int cont = 0;
		int division = 0;
		
		FileInputStream archivo = new FileInputStream(new File("C:\\Users\\Marco\\Desktop\\Prueba\\"+fichero+".txt"));
		FileOutputStream escribir = null ;
		
		byte[] numero = archivo.readAllBytes(); //OBTENEMOS EL TAMAÑO TOTAL DEL ARCHIVO
		division = numero.length/particiones;
	
		int almacen = division;
		
		FileInputStream archivo1 = null;
		for(int i=0; i<particiones; i++) {
			File nuevo = new File(fichero+contador);
			escribir = new FileOutputStream("C:\\Users\\Marco\\Desktop\\Prueba\\"+nuevo+".txt");
			 archivo1 = new FileInputStream(new File("C:\\Users\\Marco\\Desktop\\Prueba\\"+fichero+".txt"));	
		
				byte[] prueba = archivo1.readAllBytes();
				for(int x=cont; x<=almacen;x++) {
					
						escribir.write(prueba[x]);
						
						cont++;
					
					
				}
				
				almacen = division+almacen;
				contador++;	
			
			
	}
		
		
		
			archivo.close();
			escribir.close();
			archivo1.close();
		
		}

}
