package Ejercicio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class PasarToken {

	private static int NParticipantes;
	private static int participante;
	private final static int portBase=8000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2 ) {
			System.out.println("Error de parametros");
			System.out.println("Debe introucir: 1-Numero de miembros y 2-Numero de participante");
		}
		else 
		{
			NParticipantes=Integer.parseInt(args[0]);
			participante=Integer.parseInt(args[1]);
			System.out.println("Participante "+participante+" de "+NParticipantes+ " conectado.");
			
			
			InetSocketAddress addr=new InetSocketAddress("localhost",portBase+participante);
			DatagramSocket datagramSocket;
			try {
				datagramSocket = new DatagramSocket(addr);
				System.out.println("Socket escuchando por el puerto "+datagramSocket.getLocalPort()+" creado");
				if (participante==1) {
					for (int i=2; i <= NParticipantes; i++) {					
						byte[] mensajeVuelta=new byte[5];
						DatagramPacket datagram1=new DatagramPacket(mensajeVuelta,5);
						datagramSocket.receive(datagram1);	

					}
					System.out.println("Anillo formado.");
					InetAddress addrC=InetAddress.getByName("localhost");
					DatagramPacket datagram=
							new DatagramPacket("token".getBytes(),
									"token".getBytes().length,
									addrC, portBase+2);							
					datagramSocket.send(datagram);

																		
					DatagramPacket datagramfin=new DatagramPacket(new byte[5],5);
					datagramSocket.receive(datagramfin);
					System.out.println("Participante "+participante+" recibiendo token del proceso "+datagramfin.getPort());
					
				}
				else
				{
					String mensaje="listo";
					InetAddress addrC=InetAddress.getByName("localhost");
					DatagramPacket datagram=
							new DatagramPacket(mensaje.getBytes(),
									mensaje.getBytes().length,
									addrC, portBase+1);							
					datagramSocket.send(datagram);
					
					/* Recibo token */
					DatagramPacket datagram2=new DatagramPacket(new byte[5],5);
					datagramSocket.receive(datagram2);
					System.out.println("Participante "+participante+" recibiendo token del proceso "+datagram2.getPort());

					/* Mando token */
				/*	InetAddress addrSig=InetAddress.getByName("localhost");
					DatagramPacket datagramSig=
							new DatagramPacket("token".getBytes(),
									"token".getBytes().length,
									addrSig, participante==NParticipantes?
										//	portBase+1portBase+participante+1);							
					//datagramSocket.send(datagramSig);
					*/
				}
				
				
				datagramSocket.close();
				
			} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
			
			} 
			
		}
		
		
	}

}