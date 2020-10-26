package ClienteArchivos;

public class Cliente {
	
	int nif;
	String nombre;
	String email;
	
	public Cliente(int nif, String nombre, String email) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.email = email;
	}
	
	

	public Cliente() {
		super();
	}



	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
