package contarConexion;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket cliente=new Socket("localhost",7775);				
			int tiempo=(int)(Math.random()*20);
			System.out.println(tiempo+" segundos durmiendo.");
			Thread.sleep(1000*tiempo);							
			cliente.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
