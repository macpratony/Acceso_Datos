package ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		DatagramSocket socketServidor=null;
		
		try {
			InetSocketAddress addr=new InetSocketAddress("localhost",8888);
			socketServidor=new DatagramSocket(addr);
			System.out.println("Recibiendo mensajes");
			byte[] mensaje=new byte[25];
			DatagramPacket datagram1=new DatagramPacket(mensaje,25);
			socketServidor.receive(datagram1);
			System.out.println(new String(mensaje));
			
			
			System.out.println("Enviando confirmacion por el puerto "+datagram1.getPort());
			InetAddress addr2=InetAddress.getByName("localhost");
			String mensajeConfirmacion="OK";
			DatagramPacket datagram2=
					new DatagramPacket(mensajeConfirmacion.getBytes(),
							mensajeConfirmacion.getBytes().length,
							addr2, datagram1.getPort());

			socketServidor.send(datagram2);
			
			socketServidor.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch ( IOException	io) {
		// TODO Auto-generated catch block
			io.printStackTrace();
		}
		finally {
			if (socketServidor!=null)
				socketServidor.close();
		}
	}

}
