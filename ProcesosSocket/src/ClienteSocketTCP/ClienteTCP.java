package ClienteSocketTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteTCP {

	public static void main(String[] args) {
		try {
			System.out.println("abriendo socket cliente");
			Socket socket = new Socket("localhost", 7777);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			os.write("hola".getBytes());
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
