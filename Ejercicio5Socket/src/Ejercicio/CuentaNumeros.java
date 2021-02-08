package Ejercicio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class CuentaNumeros {
		static int contador=0;
		
	public static void main(String[] args) {
		
		/*Escribe un programa que cuente el numero de conexiones que vaya recibiendo.
		 * Este programa dispondra de un socket stream servidor. Cada vezx que un socket cliente
		 * se conecte , este le enviara un mensaje con el numero de cliente conectados hasta ahora 
		 * asi pues, el primer cliente que se conecte recibirá un 1, el segundo un 2 y el tercero un 3
		 */
		
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress isa = new InetSocketAddress("localhost", 7777);
			servidor.bind(isa);
			
			
			Socket socket = new Socket();
			System.out.println("Esperadno conexion");
			
			while((socket = servidor.accept()) != null) {
				
				Thread hilo = new Thread() {
					
					@Override
					public void run() {
						contador++;
						System.out.println("Cliente "+contador+" conectado");
						
					}
					
				};
				hilo.start();
				
				
				
				System.out.println("Clientes conectados "+contador);
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			
//			ServerSocket servidor = new ServerSocket();
//			InetSocketAddress direccion = new InetSocketAddress("localhost",7777);
//			servidor.bind(direccion);
//			int contador = 0;
//			Socket miSocket = new Socket();
//			System.out.println("Esperando conexion");
//			
//			while((miSocket = servidor.accept()) != null) {
//				
//					Thread hilo = new Thread() {
//						
//						@Override
//						public void run(){
//							
//						}
//						
//					};
//					contador++;
//					System.out.println("Conexión "+contador);
//					System.out.println(servidor.getLocalPort());
//					System.out.println(miSocket.getInputStream());
//	
//			}	
//			
//			
//			
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
