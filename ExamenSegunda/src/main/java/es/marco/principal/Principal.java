package es.marco.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.marco.prado.Clientes;
import es.marco.prado.Cuentas;
import es.marco.prado.Prestamos;

public class Principal {

	public static void main(String[] args) throws Exception {
BufferedReader mac = new BufferedReader ( new InputStreamReader(System.in));
		
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
		@SuppressWarnings("unused")
	    Logger logger = Logger.getLogger("org.hibernate");
	    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction(); //Permite ejecutar todo un bloque en conjunto
		 
		System.out.println("Elija una de las siguientes opciones");
		System.out.println("1.- Mostrar los nombres de clientes con cuentas de saldo negativo");
		System.out.println("2.- Eliminar los préstamos de cantidad cero");
		System.out.println("3.- Mostrar el cliente que más dinero tenga en el banco (solo teniendo en cuenta las cuentas");
		
		
		int opciones = Integer.parseInt(mac.readLine()); 
		
		switch (opciones) { 
		
			case 1:

				Query sentencia = sesion.createQuery("FROM Cuentas WHERE saldo < 0");
				List<Cuentas> cuentas = sentencia.getResultList();
				for (Cuentas c : cuentas) {
					System.out.println(c.getClientes().getNomCliente());
				}
				
				tx.commit();
				sesion.close();
				break;
				
			case 2:
				Query sentencia1 = sesion.createQuery("FROM Prestamos WHERE cantidad = 0");
				List<Prestamos> prestamo = sentencia1.getResultList();
				for (Prestamos pres : prestamo) {
					sesion.remove(pres);
				}

				tx.commit();
				sesion.close();
				break;
				
			case 3:
				int saldo=0;
				int auxSaldo=0;
				String nombre="";
				
				Query sentencia2 = sesion.createQuery("FROM Clientes");
				
				List<Clientes> clientesList=sentencia2.getResultList();
				
				for (Clientes cliente : clientesList) {
					
					auxSaldo=0;
					
					Set<Cuentas> cuenta = cliente.getCuentases();
					
					for(Cuentas c : cuenta) {
						
						auxSaldo+=c.getSaldo();
						
					}
					
					if(auxSaldo > saldo) {
						saldo = auxSaldo;
						nombre=cliente.getNomCliente();
						
					}
					
				}
				System.out.println(nombre);
				
				tx.commit();
				sesion.close();
				
				break;
		
			case 4: 
				
				break;
		
			case 5:
				 
				break;
				
			default :
				 System.out.println("La opción introducida no existe");
				break;
		}

	}

}
