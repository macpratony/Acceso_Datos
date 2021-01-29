package TranferenciaArchivos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		
		try {
			ServerSocket servidor = new ServerSocket(9999);
			while(true) {
					Socket miSocket = servidor.accept();
			
					DataInputStream dis = new DataInputStream(miSocket.getInputStream());
					System.out.println(dis.readUTF());
					
					miSocket.close();
			
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
