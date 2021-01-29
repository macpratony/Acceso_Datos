package EjemploSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketUdpServidor {

	public static void main(String[] args) {
		
		DatagramSocket socketServidor = null;
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost",8888);
			 socketServidor = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensajes");
			byte[] mensaje = new  byte[25];
			
			DatagramPacket datagram1 = new DatagramPacket(mensaje, 25);	
			socketServidor.receive(datagram1);
			System.out.println(new String(mensaje));
			
			socketServidor.close();
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(socketServidor != null)
				socketServidor.close();
		}

	}

}
