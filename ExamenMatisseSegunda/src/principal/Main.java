package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import com.matisse.MtDatabase;
import com.matisse.MtObjectIterator;

import banco.Cliente;
import banco.Cuenta;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		 
		MtDatabase db = new MtDatabase("localhost", "examenSegundo"); 
	      db.open();
	      Connection conexion = db.getJDBCConnection();
	      db.startTransaction();
	      
	      BufferedReader mac = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Ingrese una de las siguientes opciones");
			System.out.println("1.- Insertar Clientes y cuentas");
			System.out.println("2.- Mostrar el cliente que mas dinero tenga en el banco");
			
			int opciones = Integer.parseInt(mac.readLine());
			
			switch (opciones) {
			case 1:
				
				Cliente cliente = new Cliente(db);
				
				System.out.println("Ingrese el dni del cliente");
				String dni = mac.readLine();
				
				System.out.println("Ingrese el nombre del cliente");
				String nombre = mac.readLine();
			
				cliente.setDni(dni);
				cliente.setNombre(nombre);	
				
			
				Cuenta cuenta = new Cuenta(db);
				
					System.out.println("Ingrese la id de la cuenta");
					String id = mac.readLine(); 
							
					System.out.println("Ingrese el nombre de la cuenta");
					String nombreCuenta = mac.readLine();
					
					System.out.println("Ingrese un importe a la cuenta");
					float saldo = Float.parseFloat(mac.readLine());
					
					cuenta.setId(id);
					cuenta.setNombre(nombreCuenta);
					cuenta.setSaldo(saldo);
					
				cliente.prependTiene_cuentas(cuenta);
				
				db.commit();
				
				break;
				
			case 2:
				
				MtObjectIterator<Cliente> cl = Cliente.instanceIterator(db);
				String nombreCliente = "";
				double saldoBanco =0;
				double saldoAux = 0;
				
				Cuenta[] cu = null;
				
				while(cl.hasNext()) {
					Cliente cli = cl.next(); 
					 cu = cli.getTiene_cuentas();
					for(int i=0; i<cu.length; i++) {
						saldoBanco += cu[i].getSaldo();
					}
					if(saldoBanco>saldoAux) {
						saldoAux = saldoBanco;
						nombreCliente = cli.getNombre();
						saldoBanco = 0;
					}
				}
				
				System.out.println("El cliente con mas dinero en la cuenta es :"+nombreCliente);
				
				db.commit();
				
				break;

			default:
				System.out.println("La opcion ingresada no es valida");
			}
			
			conexion.close();
			db.close();
	}

}
