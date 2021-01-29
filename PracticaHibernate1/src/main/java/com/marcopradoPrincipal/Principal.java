package com.marcopradoPrincipal;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader mac = new BufferedReader ( new InputStreamReader(System.in));
		
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
		@SuppressWarnings("unused")
	    Logger logger = Logger.getLogger("org.hibernate");
	    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction(); //Permite ejecutar todo un bloque en conjunto
		 
		System.out.println("Elija una de las siguientes opciones");
		System.out.println("1.- Modificar el nombre de la cochera en la que se guardará un tren.");
		System.out.println("2.- Mostrar la línea en la que prestan servicio más trenes.");
		System.out.println("3.- Ampliar una línea de metro con una estación más ");
		System.out.println("4.- Actualizar los campos de la tabla Estaciones que pueden haberse quedado desactualizados como consecuencia de otras inserciones");
		System.out.println("5.- Dado un nombre de línea, mostrar todas las estaciones que la componen, y en orden");
		 
		
		int opciones = Integer.parseInt(mac.readLine()); 
		
		switch (opciones) { 
		
			case 1:
					Operations.cambiarNombreCochera(sesion, tx, mac);
				break;
				
			case 2:
				Operations.mostrarLineasMasTrenes(sesion, tx);
				break;
				
			case 3:
				Operations.ampliarLineaEstacion();
				break;
		
			case 4: 
				Operations.actualizarCamposEstaciones(sesion, tx);
				break;
		
			case 5:
				 Operations.lineaEstaciones(sesion, tx, mac);
				break;
				
			default :
				 System.out.println("La opción introducida no existe");
				break;
		}
		
	}

}
