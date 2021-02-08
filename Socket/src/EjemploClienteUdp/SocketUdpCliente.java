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
			socketCliente = new DatagramSocket();
			
			InetAddress addr = InetAddress.getByName("localhost");
			System.out.println("Mando mensaje");
			String mensaje = "Hola desde el cliente UDP";
			
			DatagramPacket dp = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 8888);
				socketCliente.send(dp);
			
				System.out.println("Esperando mensaje de confirmacion");
				byte[] buffer = new byte[25];
				
			DatagramPacket dp2 = new DatagramPacket(buffer, buffer.length);
			socketCliente.receive(dp2);
			System.out.println("Mensaje de confirmacion "+ new String(dp2.getData()));
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socketCliente != null)
			socketCliente.close();
		}

	}

}
