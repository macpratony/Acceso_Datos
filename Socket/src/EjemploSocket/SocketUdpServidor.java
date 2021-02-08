package EjemploSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketUdpServidor {

	public static void main(String[] args) {
		
			DatagramSocket socketServidor = null;
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost",8888);
			 socketServidor = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensajes");
			byte[] mensaje = new  byte[1024];
			 
			DatagramPacket datagram1 = new DatagramPacket(mensaje, mensaje.length);	
			socketServidor.receive(datagram1);
			System.out.println(new String(mensaje));
			
			System.out.println("Enviando mensaje de confirmacion");
			String confirmacion = "Enviando respuesta por el puerto "+datagram1.getPort();
			InetAddress addr2 =datagram1.getAddress();
			DatagramPacket dp = new DatagramPacket(confirmacion.getBytes(), confirmacion.getBytes().length, addr2,datagram1.getPort());
			socketServidor.send(dp);
			
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
