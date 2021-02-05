package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.matisse.MtDatabase;
import com.matisse.MtObjectIterator;

import clientesPedidos.Clientes;
import clientesPedidos.Pedidos;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		
	
		MtDatabase db = new MtDatabase("localhost", "cliente_pedidos");
		db.open();
		Connection conexion = db.getJDBCConnection();
		db.startTransaction();
		
		BufferedReader mac = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Ingrese una de las siguientes opciones");
		System.out.println("1.- Insertar Clientes");
		System.out.println("2.- Insertar Pedidos");
		System.out.println("3.- Mostrar pedidos de un cliente dado un dni");
		System.out.println("4.- Mostrar el total del gasto de un cliente");
			int opcion = Integer.parseInt(mac.readLine());
			
		switch (opcion) {
			
		case 1:
			Clientes cliente = new Clientes(db);
			
			System.out.println("Ingrese el dni del cliente");
				String dni = mac.readLine();
			System.out.println("Ingrese el nombre del cliente");
				String nombre = mac.readLine();
			
			cliente.setDni(dni);
			cliente.setNombre(nombre);	
			
			db.commit();
			
			break;
			
		case 2:
			Pedidos pedido = new Pedidos(db);
			
			System.out.println("Ingrese el id del producto");
			 	int id = Integer.parseInt(mac.readLine());
			 System.out.println("Ingrese el precio del producto");
			  	float precio = Float.parseFloat(mac.readLine());
			  System.out.println("Ingrese la descripcion del producto");
			   	String nombreProducto = mac.readLine();
			 
			   	System.out.println("Ingrese el dni del cliente que hace este pedido");
			   	String dniCli = mac.readLine();
			   	
			   	PreparedStatement sentencia = conexion.prepareStatement("SELECT REF (Clientes) FROM Clientes WHERE dni = ?");
			   	sentencia.setString(1, dniCli);
			   	
			   	ResultSet resul = sentencia.executeQuery();			   	
				   	while(resul.next()) {
				   		Clientes cli = (Clientes) resul.getObject(1) ;
				   		pedido.setPedido_por(cli);
				   	}
				   	
			   	pedido.setId(id);
			   	pedido.setPrecio(precio);
			   	pedido.setNombre(nombreProducto);
			   
			   	db.commit();
			break;
			
		case 3:
			
			MtObjectIterator<Clientes> client = Clientes.instanceIterator(db);//c.tiene_pedidosIterator();
			System.out.println("Introduzca el dni del cliente a consultar");
			String dniCliente = mac.readLine();
			Pedidos[] pedi = null;
			while(client.hasNext()) {
				Clientes uno = client.next();
				if(uno.getDni().equals(dniCliente)) {
					pedi = uno.getTiene_pedidos();
					for(int i=0; i<pedi.length; i++) {
						System.out.println(pedi[i].getId()+" "+pedi[i].getNombre()+" "+pedi[i].getPrecio());
					}
				}
					
			}
			
			db.commit();
			
			break;
		case 4:
			MtObjectIterator<Clientes> cl = Clientes.instanceIterator(db);//c.tiene_pedidosIterator();
			System.out.println("Introduzca el dni del cliente a consultar");
			String dniClie = mac.readLine();
			Pedidos[] pedid = null;
			int suma = 0;
			
			while(cl.hasNext()) {
				Clientes uno = cl.next();
				if(uno.getDni().equals(dniClie)) {
					pedi = uno.getTiene_pedidos();
					for(int i=0; i<pedi.length; i++) {
						suma += pedi[i].getPrecio();
					}
				}
					
			}
			System.out.println(suma);
			
			db.commit();

			
			break;
		}
		
		conexion.close();
		db.close();

	}

}
