package TranferenciaArchivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		final int puerto = 8888;
		DataInputStream in;
		DataOutputStream out;
		Socket sc;
		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Servidor Iniciado");
			
			while(true) {
				sc = servidor.accept();
				System.out.println("Cliente conectado");
				
				in = new DataInputStream(sc.getInputStream());
				String mensajeRecibido = in.readUTF();
				System.out.println(mensajeRecibido);
				
				System.out.println("Enviando confirmación ");
				
				out = new DataOutputStream(sc.getOutputStream());
				
				out.writeUTF("Mensaje Recibido perfectamente");
				
				System.out.println("Cliente desconectado");
				sc.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}