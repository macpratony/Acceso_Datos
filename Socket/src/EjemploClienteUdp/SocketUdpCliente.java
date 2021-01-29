package EjemploClienteUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketUdpCliente {

	public static void main(String[] args) {
		
		DatagramSocket socketCliente = null;
		
		try {
			//InetSocketAddress addr = new InetSocketAddress("localhost");
			byte[] mensaje = new byte[25];
			socketCliente = new DatagramSocket();
		//	InetAddress addr = new InetAddress.getName("localhost");
			DatagramPacket data = new DatagramPacket(mensaje, 25);
			socketCliente.receive(data);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
