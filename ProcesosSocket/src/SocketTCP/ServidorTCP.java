package SocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) {
		
		
		try {

			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost",7777);
			 serverSocket.bind(addr);
			 System.out.println("Aceptando mensajes");
			 Socket socket = serverSocket.accept();
			 
			 InputStream is = socket.getInputStream();
			 OutputStream os = socket.getOutputStream();
			 
			
			 byte[] mensaje = new byte[500];
			 System.out.println("Esperando mensaje");
			 is.read(mensaje);	 
			 System.out.println("Mensaje recibido "+new String(mensaje));
			 
			 socket.close();
			// serverSocket.close();
			 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }

	}

}

//para ejecutar en el cmd se pone el comando----- telnet localhost y numero de puerto en este caso es 7777