package es.marco;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Principal {

	public static void main(String[] args) {
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
				@SuppressWarnings("unused")
			    Logger logger = Logger.getLogger("org.hibernate");
			    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need
			    
			    BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));
			    //Crear el  gestor de persistencia (EM)
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticaJPA");
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
			        	 
			        	 int opcion = Integer.parseInt(mac.readLine());
			        	 
			        	 switch (opcion) {
							case 1:
								
								 Empleado empleado = new Empleado();
								 System.out.println("Ingrese el dni");
								 String dni = mac.readLine();
								 System.out.println("Ingrese el nombre");
								 String nombre = mac.readLine();
								 
					        	 empleado.setDni(dni);
					        	 empleado.setNom_emp(nombre);
					        	 
					        	 manager.persist(empleado);
					        	 manager.getTransaction().commit();
					        	 
					        	 
								break;
							
							case 2:
	
								Proyecto proyecto = new Proyecto ();
	
								System.out.println("Introduzca el nombre del proyecto");
								String nombreProyecto = mac.readLine();
								System.out.println("Introduzca el dni del jefe");
								String dniJefe = mac.readLine();
	
								Empleado e = manager.find(Empleado.class, dniJefe);
							
	
									if(e != null) {
	
							        	 proyecto.setNom_proy(nombreProyecto);
							        	 proyecto.setJefe_proy(e);
							        	 
							        	 manager.persist(proyecto);
							        	 manager.getTransaction().commit();
									}else {
										System.out.println("No se puede crear el proyecto porque no existe el empleado");
										
									}
									
	
								break;
								
							case 3:
								
								System.out.println("Introduzca el id del proyecto al que desea añadir empleados");
								Integer idProy = Integer.parseInt(mac.readLine());
								
								Proyecto pro = manager.find(Proyecto.class, idProy);
							System.out.println(pro.getNom_proy());
								
									if(pro != null) {
										System.out.println("Ingrese el dni del empleado al que desea añadir al proyecto");
											String dniEm = mac.readLine();
										Empleado em = manager.find(Empleado.class, dniEm);
										System.out.println(em.getNom_emp());
										if(em != null) {
											if(pro.getEmpleado() == null) {
												System.out.println(pro.toString());
												pro.setEmpleado(new HashSet<Empleado>());
												pro.getEmpleado().add(em);
												manager.getTransaction().commit();
											}else {
												pro.getEmpleado().add(em);
												manager.getTransaction().commit();
											}
										}else {
											System.out.println("No existe empleado con esa id");
										}
											
									}else {
										System.out.println("No existe proyecto con esa id");
									}	
	
								break;
								
							case 4:
								
								System.out.println("Ingrese el id del proyecto al que le desea cambia el jefe");
								int idP = Integer.parseInt(mac.readLine());
									Proyecto proyc = manager.find(Proyecto.class, idP);
									if(proyc != null){
										System.out.println("Ingrese el dni del nuevo jefe");
										String dni1 = mac.readLine();
										
										Empleado em = manager.find(Empleado.class, dni1);
										if(em != null) {
											proyc.setJefe_proy(em);
											 manager.persist(em);
											 manager.getTransaction().commit();
											
										}else {
											System.out.println("El dni introducido no pertenece a ningun empleado ");
										}
										
									}else {
										System.out.println("El id del proyecto introducido no existe");
									}
								
								break;
		
							default:
								System.out.println("La opcion introducida no es correcta");
								break;
						}	 
			        	 System.out.println("Desea continuar..?");
			        	 System.out.println("Ingrese si o no");
			        	 op = mac.readLine();
		        	 
		        	}while(op.equals("si"));
		        	
		        }catch(Exception e) {
		        	manager.getTransaction().rollback();
		        }
			        
			        manager.close();
			        emf.close();
		           

	}

}
