package ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		
		System.out.println("Socket UDP cliente");
		DatagramSocket sockectCliente=null;
		try {
			sockectCliente=new DatagramSocket();
			
			InetAddress addr=InetAddress.getByName("localhost");
			System.out.println("Mandando mensaje");
			String mensaje="mensaje desde el cliente";
			DatagramPacket datagram=
					new DatagramPacket(mensaje.getBytes(),
							mensaje.getBytes().length,
							addr, 8888);
			sockectCliente.send(datagram);
			System.out.println("Esperando confirmacion");
			byte[] mensajeC=new byte[2];
			DatagramPacket datagram2=new DatagramPacket(mensajeC,2);
			sockectCliente.receive(datagram2);
			System.out.println("Mensaje de confirmación: "+new String(mensajeC));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
