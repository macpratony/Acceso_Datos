package com.marco.Principal2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.Operation;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.marco.principal.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
//				@SuppressWarnings("unused")
//			    Logger logger = Logger.getLogger("org.hibernate");
//			    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need
			    
		BufferedReader mac = new BufferedReader (new InputStreamReader(System.in));
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction();
		
			
			try {
				System.out.println("Elija una de las siguientes opciones");
				System.out.println("1.- Insertar Empleado \n 2.- Insertar Proyecto \n 3.- Insertar Departamento \n 4.- Insertar Sedes \n 5.- Asignar Proyecto a Sedes \n 6.- Cambiar un Proyecto de Sede"
				+ "\n 7.- Insertar o modificar datos profesionales de un empleado \n 8.- Eliminar proyectos y empleados \n 9.- Obtener la Sede con mas proyectos asignados \n 10.- Obtener el empleado de mayor sueldo");
				int op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion"));
				
				switch (op) {		
				 
					case 1:
						Operations.insertarEmpleado(sesion, tx);
						break;
					case 2: 
					try {
						Operations.insertarProyecto(sesion, tx);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						break;
						
					case 3:
						
						break;
						
					case 4:
						
						break;
						
					case 5:
						
						break;
						
					case 6:
						
						break;
						
					case 7:
						
						break;
						
					case 8:
						
						break;
						
					case 9:
						
						break;
						
					case 10:
						
						break;
					default:
						break;
					}
							
				
				
				
				
				
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//tx.commit();
			sesion.close();
		
		
	}

}
