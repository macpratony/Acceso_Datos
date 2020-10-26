package Ejercicio1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Chat1 chat1 = new Chat1();
		Chat2 chat2 = new Chat2();
		chat1.setVisible(true);
		chat2.setVisible(true);
		
		
			chat1.leer.connect(chat2.escribir);
			chat2.lee.connect(chat1.escribe);
			
			
		
		//re.join();
		//wri.join();
	}
}
