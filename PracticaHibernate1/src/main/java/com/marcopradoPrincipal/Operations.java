package com.marcopradoPrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.marcoprado.com.Cocheras;
import clases.marcoprado.com.Estaciones;
import clases.marcoprado.com.LineaEstacion;
import clases.marcoprado.com.LineaEstacionId;
import clases.marcoprado.com.Lineas;
import clases.marcoprado.com.Trenes;

public class Operations {
	
	public static void cambiarNombreCochera(Session sesion, Transaction tx, BufferedReader mac) {
		
		try {
			Cocheras cochera = new Cocheras(); 
			
			if(cochera.equals(null)) {
				System.out.println("No hay cocheras, cree una ");
				System.out.println("*************");
				
				System.out.println("Ingrese el codigo de la cochera");
					int codigoCochera = Integer.parseInt(mac.readLine());
					cochera.setCodCochera(codigoCochera);
					
				System.out.println("Ingrese nombre de la cochera");
				 	String nombreCochera = mac.readLine();
				 	cochera.setNombre(nombreCochera);
				 	
				System.out.println("Ingrese direccion de la cochera");
				 	String direccionCochera = mac.readLine();
				 	cochera.setDireccion(direccionCochera);
				 	
				 	sesion.save(cochera);
				 	tx.commit();
				 	sesion.close();
					
			}else {
				
				System.out.println("Introduzca el codigo de la cochera");
				int codigo = Integer.parseInt(mac.readLine());			
				Query sentencia = sesion.createQuery("UPDATE Cocheras SET nombre = :nombre WHERE codCochera = :codCochera");
	
					System.out.println("Introduzca el nombre de la cochera");
					String nombre = mac.readLine();
					sentencia.setParameter("nombre", nombre);
					sentencia.setParameter("codCochera",codigo);
					sentencia.executeUpdate();
					
					tx.commit();
					sesion.close();

			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void mostrarLineasMasTrenes(Session sesion, Transaction tx) {
		
		Query sentencia = sesion.createQuery("FROM Trenes");
		List<Trenes> tren = sentencia.getResultList();
		Set<Integer> codLinea = new HashSet<Integer>();
		
		int contador = 0;
		int contadorAux = 0;
		int codigoTren = 0;
		
		for ( Trenes t : tren) {
			codLinea.add(t.getLineas().getCodLinea());
		}
		
		
		for (Integer in : codLinea) {
			
			for (Trenes t : tren) {
				
				if(in == t.getLineas().getCodLinea()) {
					contador++;
				
				}
			}
			
			if(contador>contadorAux) {
				contadorAux = contador;
				codigoTren = in;
				contador = 0;
			}
		}
		
		Lineas t = sesion.get(Lineas.class, codigoTren);
		
		System.out.println("La linea "+t.getNombre() + " de codigo "+t.getCodLinea()+" es por la que mas trenes pasan");
		
		tx.commit();
		sesion.close();
		
		
	}
	
	public static void ampliarLineaEstacion() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction();
		BufferedReader mac = new BufferedReader ( new InputStreamReader(System.in));
		
		try {
			
			System.out.println("Introduzcas el codigo de la linea");
			int codigoLinea = Integer.parseInt(mac.readLine());
			
			System.out.println("Introduzca el codigo de la estacion");
			int codigoEstacion = Integer.parseInt(mac.readLine());
			
			
			Lineas linea = sesion.get(Lineas.class, codigoLinea);
			Estaciones estacion = sesion.get(Estaciones.class, codigoEstacion);
			
			if(linea != null && estacion != null ) { 								//Compara si existe la linea y la estacion 
				Query sentencia = sesion.createQuery("FROM LineaEstacion WHERE lineas.codLinea = :codLinea"); //Obtiene la tabla lineaEstacion donde coincidan solo los codigo de linea introducido
				sentencia.setParameter("codLinea", codigoLinea);
				
				List<LineaEstacion> lineaEstacion = sentencia.getResultList();
				
				
				System.out.println("Introduzca el orden de la estacion");
				int orden = Integer.parseInt(mac.readLine());
				
				
				for (LineaEstacion li : lineaEstacion) {
				
					if( li.getOrden()>= orden ) {       //Si el orden de la linea que existe es mayor o igual al que va a entrar la suma uno 
						li.setOrden(li.getOrden()+1);
					}
					
				}
				
				LineaEstacionId li = new LineaEstacionId(codigoLinea, codigoEstacion); //Guardamos codigo linea y codigo estacion 
				LineaEstacion liEstacion = new LineaEstacion();
				
				liEstacion.setId(li);        //Asignamos lo que anteriormente guardamos a la estacion
				liEstacion.setOrden(orden);  //Y le añadimos el orden que va a tener
				
				sesion.save(liEstacion);
				tx.commit();
				
				//Una vez que guardamos la linea y la estacion vamos a comprobar si la linea que hemos guardado se convierte en la linea que mas estaciones tiene
				//Para ello guardamos todos los datos de la linea que hemos introducido
				Lineas line = sesion.get(Lineas.class, codigoLinea); //Guardamos toda la informacion sólo de la linea que hemos introducido
				boolean esLargo = false;
				
				Query sentencia2 = sesion.createQuery("FROM Lineas WHERE codLinea != :codLinea"); //Guardamos el resto de la información omitiendo la linea que hemos obtenido por separado
				sentencia2.setParameter("codLinea", codigoLinea);
				List<Lineas> linea1 = sentencia2.getResultList();
				
				for (Lineas lineas : linea1) { //Recorremos la coleccion de las lineas obtenidas
					
					if(lineas.getLineaEstacions().size() > 0) {  //Comparamos si de la coleccion obtenida las lineas son > que 0
						if(line.getLineaEstacions().size() > lineas.getLineaEstacions().size()) { //Si lo es compara el tamaño de la linea guardada por separado con todas las de la colección
							esLargo = true;       //Si es mayor cambia el boolean a verdadero
						}
					}
				}
				
				if(esLargo) { //Si el boolean es verdadero despues de toda la interacción anterior imprime un mensaje
					System.out.println("La linea "+line.getCodLinea()+" es la mas larga");
				}
	
				sesion.close();
	
			}else {
				System.out.println("Uno de los dos o los dos datos introducidos no existe en la base de datos");
			}
			

			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//	Actualizar los campos de la tabla Estaciones que pueden haberse quedado desactualizados como consecuencia de otras inserciones: numaccesos, numlineas, 
	//	numviajesdestino, numviajesprocedencia. numaccesos es el número de accesos que tiene la estación, numlineas es el número de líneas que pasan por ella, 
	//	numviajesdestino el número de viajes que la tienen como destino y numviajesprocedencia el número de viajes que la tienen como origen.
	public static void actualizarCamposEstaciones(Session sesion, Transaction tx) {
				
		Query sentencia = sesion.createQuery("FROM Estaciones"); //Obtenemos toda la informacion de la tabla estaciones
		List<Estaciones> estaciones = sentencia.getResultList(); //Recogemos el resultado guardando en un list
		for (Estaciones es : estaciones) {  //Interactuamos con el foreach
			es.setNumAccesos(es.getAccesoses().size());    //guardamos el numero de accesos que contiene esa linea a traves de los set que contiene la clase Estaciones
			es.setNumLineas(es.getLineaEstacions().size());
			es.setNumViajesdestino(es.getViajesesForEstacionDestino().size());
			es.setNumViajesprocedencia(es.getViajesesForEstacionOrigen().size());
			sesion.save(es);
		}

		tx.commit();
		sesion.close();
	
	}
	
	//5.	Dado un nombre de línea, mostrar todas las estaciones que la componen, y en orden.
	public static void lineaEstaciones(Session sesion, Transaction tx, BufferedReader mac) {
		
		try {
			System.out.println("Ingrese el nombre de la linea que desea consultar");
			String nombre = mac.readLine();
			
			Query sentencia = sesion.createQuery("FROM Lineas WHERE nombre = :nombre");
			sentencia.setParameter("nombre", nombre);
			List<Lineas> lineas = sentencia.getResultList();
			int codigoLinea = 0;
			for (Lineas li : lineas) {
				codigoLinea = li.getCodLinea();
			}
			
			Query sentencia2 = sesion.createQuery("FROM LineaEstacion WHERE lineas.codLinea = :codLinea");
			sentencia2.setParameter("codLinea", codigoLinea);
			List<LineaEstacion> line = sentencia2.getResultList();
			Collections.sort(line);
			
			for (LineaEstacion li : line) {
				System.out.println("Codigo de linea "+li.getLineas().getCodLinea()+" Codigo de la estacion "+li.getEstaciones().getCodEstacion()+" nombre de la estacion "+li.getEstaciones().getNombre()+" orden "+li.getOrden());	
			}
			
			tx.commit();
			sesion.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
