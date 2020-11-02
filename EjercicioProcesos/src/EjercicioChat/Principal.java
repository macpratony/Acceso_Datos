package EjercicioChat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JOptionPane;

public class Principal {
	 static String global1 = "";
	 static String global2 = "";
	 
	public static void main(String[] args) {
		
		//Pedimos los nombres de las personas que van a participar en el chat
		String nombreVentana1 = JOptionPane.showInputDialog("Ingrese el nombre de la primera persona del chat");
		String nombreVentana2 = JOptionPane.showInputDialog("Ingrese el nombre de la segunda persona del chat");
		
		//Instanciamos la ventana dos veces para crear dos pantallas
			Ventana v1 = new Ventana();
			Ventana v2 = new Ventana();
			
			
			v1.setVisible(true);
			v2.setVisible(true);
			v1.lblNewLabel.setText(nombreVentana1);
			v2.lblNewLabel.setText(nombreVentana2);
			v2.setLocationRelativeTo(null);
		
			//Conectamos las tuberias
			try {
				v1.escribir.connect(v2.leer);
				v2.escribir.connect(v1.leer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			//Esta primera clase lee la tuberia de la primera ventana del chat
			class Leer extends Thread{
				
				@Override
				public void run() {
					
					while(true) { //Bucle infinito
						String cadena = "";
	
						try {
							
							do {
								int n = v1.leer.read();
								cadena += (char) n;
								
							}while(v1.leer.available()>0);
							v1.resultado += cadena + "          escribe...."+v2.lblNewLabel.getText()+"\n"; //Se muestra en pantalla el mensaje recibido seguido de quien lo escribe
							v1.textDatos.setText(v1.resultado);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
			
			//Esta clase es igual que la de arriba con el simple hecho que lee la tuberia del segundo chat
			class Leer2 extends Thread{
				
				@Override
				public void run() {
					while(true) {
						String cadena2 = "";						
						try {	
							do {
								int n = v2.leer.read();
								cadena2 += (char) n;
								
							}while(v2.leer.available()>0);
							v2.resultado += cadena2+ "          escribe...."+v1.lblNewLabel.getText()+"\n";
							v2.textDatos.setText(v2.resultado);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
			}
			//Iinstanciamos las dos clases
			Leer le = new Leer();
			Leer2 l = new Leer2();
			le.start();
			l.start();
			
			
			
			
	}
	
}
