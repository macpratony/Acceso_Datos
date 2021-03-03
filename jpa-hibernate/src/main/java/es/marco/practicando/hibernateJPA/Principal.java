package es.marco.practicando.hibernateJPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
		@SuppressWarnings("unused")
	    Logger logger = Logger.getLogger("org.hibernate");
	    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need
	    
	    BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));
	    //Crear el  gestor de persistencia (EM)
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaJPA");
        EntityManager manager = emf.createEntityManager();
        
        try {
	        manager.getTransaction().begin();
	   	 	String op = "";
	        
	        do {
	        	 System.out.println("Ingrese una de las siguientes opciones");
	        	 System.out.println("1.- Insertar empleado");
	        	 System.out.println("2.- Insertar proyecto");
	        	 System.out.println("3.- Asignar un empleado a un proyecto");
	        	 System.out.println("4.- Cambiar el jefe de un proyecto");
	        	 System.out.println("5.- Eliminar empleado de proyecto");
	        	 
	        	 int opcion = Integer.parseInt(mac.readLine());
	        	 
	        	switch (opcion) {
				case 1:
					
					Empleado empleado = new Empleado();
						System.out.println("Ingrese el dni del empleado");
						String dni = mac.readLine();
						System.out.println("Ingrese el nombre del empleado");
						String nombre = mac.readLine();
						
					empleado.setDni(dni);
					empleado.setNom_emp(nombre);
					
					manager.persist(empleado);
					manager.getTransaction().commit();
					
					break;
					
				case 2:
					
					Proyecto proyecto = new Proyecto();
					
					System.out.println("Introduzca el nombre del proyecto");
					String nombreProyecto = mac.readLine();
					System.out.println("Introoduzca el dni del empleado");
					String dniEmpleado = mac.readLine();
					
					Empleado e = manager.find(Empleado.class, dniEmpleado);
					
					if(e != null) {
						
						proyecto.setNom_proy(nombreProyecto);
						proyecto.setJefe_proy(e);
						
						manager.persist(proyecto);
						manager.getTransaction().commit();
						
					}else {
						System.out.println("No existe el dni introducido");
					}
					
					
					break;
					
				case 3:
					System.out.println("Ingrese el id del proyecto ");
					int idProyecto = Integer.parseInt(mac.readLine());
					
					Proyecto proyecto1 = manager.find(Proyecto.class, idProyecto);
					if(proyecto1 != null) {
						System.out.println("Ingrese el dni del jefe");
						String dniJefe = mac.readLine();
						
						Empleado empleado1 = manager.find(Empleado.class, dniJefe);
						
						if(empleado1 != null) {
							
							proyecto1.getEmpleado().add(empleado1);
							manager.persist(proyecto1);
							manager.getTransaction().commit();
							
						}
					}
					
					
					break;
					
				case 4:
					
					System.out.println("Ingrese el id del proyecto al que le quiere cambiar el jefe");
					int idProy = Integer.parseInt(mac.readLine());
					
					Proyecto proy = manager.find(Proyecto.class, idProy);
					if(proy != null) {
						
						System.out.println("Introduzca el dni del nuevo jefe");
						String dniJ = mac.readLine();
						
						Empleado em = manager.find(Empleado.class, dniJ);
						if(em != null) {
							
							
							proy.setJefe_proy(em);
							
							manager.persist(proy);
							manager.getTransaction().commit();
						}
						
					}
					
					break;
					
				case 5:
						System.out.println("Ingrese el dni del empleado");
						String dniE = mac.readLine();
						
						
				
					
					break;
					
	
				default:
					break;
				}
	        	
	        	 System.out.println("Desea continuar..?");
	        	 System.out.println("Ingrese si o no");
	        	 op = mac.readLine();
	        	 
	        }while(op.equals("si"));
	 }catch(Exception e) {
     	manager.getTransaction().rollback();
     }
        

	}

}
