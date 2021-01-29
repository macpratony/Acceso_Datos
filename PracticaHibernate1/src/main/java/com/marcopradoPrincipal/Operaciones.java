package com.marcopradoPrincipal;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import clases.marcoprado.com.Cocheras;
import clases.marcoprado.com.Estaciones;
import clases.marcoprado.com.LineaEstacion;
import clases.marcoprado.com.LineaEstacionId;
import clases.marcoprado.com.Lineas;
import clases.marcoprado.com.Trenes;

public class Operaciones {
	
	public static void modificarNombreCochera(Session sesion, Transaction tx, BufferedReader mac) {
		
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
				
				System.out.println("Ingrese el codigo de la cochera que desea modificar");
				int codigoCochera = Integer.parseInt(mac.readLine());
				Query sentencia = sesion.createQuery("UPDATE Cocheras SET nombre = :nombre WHERE codCochera = :codCochera");
				System.out.println("Ingrese el nuevo nombre de la cochera");
					String nombreCochera = mac.readLine();
				 	sentencia.setParameter("nombre", nombreCochera);
				 	sentencia.setParameter("codCochera", codigoCochera);
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
	
	//Mostrar la línea en la que prestan servicio más trenes.
	public static void mostrarLineasTrenes(Session sesion, Transaction tx) {

		Query sentencia = sesion.createQuery("FROM Trenes"); //Permite obtener 
		List<Trenes> tren = sentencia.getResultList();
		HashSet<Integer> codigoTren = new HashSet<Integer>();
		int lineaMas = 0;
		int linea = 0;
		int contadorAux = 0;
		int contador = 0;
		
		for (Trenes t : tren) {
			codigoTren.add(t.getLineas().getCodLinea());
		}
		
			for (Integer integer : codigoTren) {
				for (Trenes t : tren) {
					if(t.getLineas().getCodLinea() == integer) {
						linea = integer;
						contador++;
					}
				}

				if(contador > contadorAux) {
					contadorAux = contador;
					lineaMas = linea;
					contador = 0;
				}
			}
			
		Lineas lineaTren = sesion.get(Lineas.class, lineaMas);
			
		System.out.println("La linea "+lineaMas+" "+lineaTren.getNombre()+" es la que mas trenes presta servicios");
		
		tx.commit();
		sesion.close();
	}

	//3.	Ampliar una línea de metro con una estación más (las estación y la línea debe existir previamente, 
	//	para lo cuál se realizarán todas las comprobaciones necesarias). Esta estación puede insertarse al final o en medio, 
	//	para este último caso habrá que alterar el orden de las restantes estaciones. Si como consecuencia de esta inserción 
//	la línea se convirtiera en la más larga, mostrar un aviso.
	public static void ampliarLineaMetro(Session sesion, Transaction tx, BufferedReader mac) throws NumberFormatException, IOException {
		int contador = 0;
		

		
		System.out.println("Ingrese el codigo de linea");
		int codigoLinea = Integer.parseInt(mac.readLine());
			Query sentencia = sesion.createQuery("FROM Lineas");
			List<Lineas> lineas = sentencia.getResultList();
			for (Lineas l : lineas) {
				if(l.getCodLinea() == codigoLinea)
					contador++;
			}
		Lineas line = sesion.get(Lineas.class, codigoLinea);
		
			
		if(contador>0) {
			contador = 0;
			System.out.println("Ingrese el codigo de la estación");
			int codigoEstacion = Integer.parseInt(mac.readLine());
			Query sentencia2 = sesion.createQuery("FROM Estaciones");
			List<Estaciones> estacion = sentencia2.getResultList();
			for (Estaciones es : estacion) {
				if(es.getCodEstacion() == codigoEstacion) 
					contador++;
			}
			Estaciones station = sesion.get(Estaciones.class, codigoEstacion);
			
			
			if(contador > 0) {
				System.out.println("Ingrese el numero de orden");
				int numeroOrden = Integer.parseInt(mac.readLine());
				Query sentencia3 = sesion.createQuery("FROM LineaEstacion");
				List<LineaEstacion> lineaEstacion = sentencia3.getResultList();
				for (LineaEstacion li: lineaEstacion) {
					if(li.getOrden()>= numeroOrden) {
						li.setOrden(li.getOrden()+1);
						
					}
					System.out.println("*******"+li.getOrden());
					sesion.save(li);
				}
				
				LineaEstacionId lei = new LineaEstacionId(line.getCodLinea(),station.getCodEstacion());
				LineaEstacion stationLine = new LineaEstacion();
				
				stationLine.setId(lei);
				stationLine.setOrden(numeroOrden);
				
				sesion.save(stationLine);
				tx.commit();
				sesion.close();
			}
			
			
		}
		
		
			
		
	}
	//	Actualizar los campos de la tabla Estaciones que pueden haberse quedado desactualizados como consecuencia de otras inserciones: numaccesos, numlineas, 
	//	numviajesdestino, numviajesprocedencia. numaccesos es el número de accesos que tiene la estación, numlineas es el número de líneas que pasan por ella, 
	//	numviajesdestino el número de viajes que la tienen como destino y numviajesprocedencia el número de viajes que la tienen como origen.
	
	public static void  actualizarCamposEstacion() {
		
		Estaciones estacion = new Estaciones();
		
	}
	
	// Dado un nombre de línea, mostrar todas las estaciones que la componen, y en orden
	public static void estaciones(Session sesion, Transaction tx, BufferedReader mac) throws NumberFormatException, IOException {
		
		System.out.println("Ingrese el nombre de linea que desea consultar");
		String nombreLinea = mac.readLine();
		
		Query sentencia = sesion.createQuery("FROM Lineas WHERE nombre = :nombre");
		sentencia.setParameter("nombre", nombreLinea);
		
		List<Lineas> linea = sentencia.getResultList();
		int codigoLinea = 0;
		
		for (Lineas lineas : linea) {
			codigoLinea = lineas.getCodLinea();
		}
		
		Query sentencia1 = sesion.createQuery("FROM LineaEstacion WHERE lineas.codLinea = :codigo");
		sentencia1.setParameter("codigo", codigoLinea);
		
		List<LineaEstacion> lineaEstacion = sentencia1.getResultList();
		Collections.sort(lineaEstacion); 

		for (LineaEstacion li : lineaEstacion) {
			
			System.out.println("Codigo de linea "+li.getLineas().getCodLinea()+" codigo de estación "+li.getEstaciones().getCodEstacion()+" número de orden "+li.getOrden());
		}
		
		
		
	}
		

}
