package contarConexion;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;


public class ContadorConexiones {
	
	static int contador=0;
	static Socket recibe;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket();
			InetSocketAddress addr=new InetSocketAddress("localhost",7775);
			serverSocket.bind(addr);
			System.out.println("Esperando conexión");
			recibe=null;
			while ((recibe=serverSocket.accept())!=null) {	
				Thread hilo=new Thread() {
					public void run() {
						Socket newSocket=recibe;
						try {
							InputStream is=newSocket.getInputStream();
							is.read();
						//	newSocket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						contador--;
						System.out.println("Numero de conexiones "+contador);
					}
				};
				hilo.start();
				contador++;
				System.out.println("Numero de conexiones "+contador);
			}

			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
