package TranferenciaArchivos;

import java.io.BufferedReader;
import java.io.DataInputStream;


import java.io.DataOutputStream;

import java.io.FileReader;
import java.io.IOException;

import java.net.Socket;



public class Cliente {

	public static void main(String[] args) {
		//Tranferir una pareja de programa que transfieran un fichero entre ellos.
		//el programa A deberá leer un fichero del disco y enviarlo a B. B recibirá el contenido
		//del fichero y lo imprimirá por su salida estandar. Utiliza para ello sockets stream
		final int puerto = 8888;
		BufferedReader br;
		DataInputStream in;
		DataOutputStream out;
		
		Socket sc;
			
		try {
			sc = new Socket("localhost", puerto);
			
			System.out.println("Enviando mensaje al servidor desde el cliente");
			out = new DataOutputStream(sc.getOutputStream());
			
			br = new BufferedReader(new FileReader("script.txt"));
			String aux;
			String cadena = "";
			while((aux = br.readLine()) != null) {
				cadena = cadena+ aux+"\n";
				
			}
			out.writeUTF(cadena);

			sc.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
