package TranferenciaArchivos;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		//Tranferir una pareja de programa que transfieran un fichero entre ellos.
		//el programa A deberá leer un fichero del disco y enviarlo a B. B recibirá el contenido
		//del fichero y lo imprimirá por su salida estandar. Utiliza para ello sockets stream
		
		try {
//			File fichero = new File("script.txt");
//			DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
//			String cadena = dis.readUTF();
			Socket cliente = new Socket("localhost",9999);
			
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			dos.writeUTF("Hola");
			
			dos.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"ni idea");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+" ni idea señor");
		}
		

	}

}
