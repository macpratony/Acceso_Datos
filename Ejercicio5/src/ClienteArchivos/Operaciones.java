package ClienteArchivos;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Operaciones {
	
	RandomAccessFile raf;
	
	int nif;
	String nombre;
	String email;
	
	public Operaciones(RandomAccessFile raf) {
		super();
		this.raf = raf;
	}
	public RandomAccessFile getRaf() {
		return raf;
	}
	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	
	public void altaCliente(Cliente cli) throws IOException {
		boolean fin = false;
		raf.seek(raf.length());
		while(!fin) {
			
			if(raf.length()>0) {
				nif = raf.readInt();
					
				
			}
				raf.writeInt(cli.getNif());
				raf.writeUTF(cli.nombre);
				raf.writeUTF(cli.getEmail());
				
				raf.close();
		}
	}
	
	public Cliente mostrarCliente(int nif1) throws IOException {
		
		String cadena = "";
		boolean fin = false;
		Cliente c = null;
		raf.seek(0);
		
		while(!fin) {
			try {
				nif = raf.readInt();
				if(nif == nif1) {
					nombre = raf.readUTF();
					email = raf.readUTF();
					
					cadena = "Nif del cliente es   "+nif+"\n" + "Nombre del cliente   "+ nombre + "\n" + "El email es   "+ email;
					
					c = new Cliente(nif, nombre, email);
					
				}else {
					raf.readUTF();
					raf.readUTF();
				}
				
				
				
			} catch (EOFException e) {
				fin = true;
			}
			
		}
		
		raf.close();
		
		return c;
		
		
	}
	
	public void actualizar(int nif1, String nombre1, String email1)throws IOException {
		
		boolean fin = false;
		raf.seek(0);
		
		while(!fin) {
			try {
				nif = raf.readInt();
				if(nif == nif1) {
					raf.writeUTF(nombre1);
					raf.writeUTF(email1);
					
					
				}else {
					raf.readUTF();
					raf.readUTF();
				}
				
		
				
			} catch (EOFException e) {
				fin = true;
			}
		}
		raf.close();
	}
	
	public void eliminar(int nif1) throws IOException {
		boolean fin = false;
		RandomAccessFile raf1 = new RandomAccessFile("nuevo", "rw");
		raf.seek(0);
		
		while(!fin) {
			try {
				nif = raf.read();
				if(nif == nif1) {
					raf.readUTF();
					raf.readUTF();
				}else {
					
					raf1.writeInt(nif);
						nombre = raf.readUTF();
					raf1.writeUTF(nombre);
						email = raf.readUTF();
					raf1.writeUTF(email);
					
				}
				
			} catch (EOFException e) {
				fin = true;
			}
				
		
			
		}
		raf.close();
		raf1.close();
		
		File antiguo = new File("archivo");
		File aux = new File("nuevo");
		
		antiguo.delete();
		aux.renameTo(antiguo);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + nif;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operaciones other = (Operaciones) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nif != other.nif)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
