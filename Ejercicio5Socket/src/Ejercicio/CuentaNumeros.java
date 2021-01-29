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

	public static void main(String[] args) {
		
		try {
			
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("localhost",7777);
			servidor.bind(direccion);
			int contador = 0;
			Socket miSocket = new Socket();
			System.out.println("Esperando conexion");
			
			while((miSocket = servidor.accept()) != null) {
				
					Thread hilo = new Thread() {
							
						
					};
					contador++;
					System.out.println("Conexión "+contador);
					System.out.println(servidor.getLocalPort());
					System.out.println(miSocket.getInputStream());
	
			}	
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
