package com.marco.principal;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.marco.com.*;

public class Principal {

	
	public static void main(String[] args) throws IOException {
		 
		BufferedReader mac = new BufferedReader ( new InputStreamReader(System.in));
		
		//las tres lineas de acontinuacion eliminan los informes que genera el hibernate en la consola
		@SuppressWarnings("unused")
	    Logger logger = Logger.getLogger("org.hibernate");
	    Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF); //or whatever level you need

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction(); //Permite ejecutar todo un bloque en conjunto
		
		/*
		Departamento d = new Departamento();
		d.setNomDepto("Material");  //El objeto se encuentra en estado transitorio lo cual significa que llegado a este punto,
									//el onjeto no tiene conecxion con la base de datos, por lo tanto no realizara cambios
		
		
		Sede s = new Sede();
		s.setNomSede("Madrid");
		d.setSede(s);
		
		sesion.save(s);
		sesion.save(d); //Aquí el objeto es persistente y por lo tanto lleva a cabo la ejecucion y realiza cambios en la base de datos.
		sesion.refresh(s); //actualiza un objeto
		
		for (Object dep : s.getDepartamentos()) {
			System.out.println(((Departamento)dep).getNomDepto());
			
		}
		
		
		Departamento depto = sesion.get(Departamento.class, 3); //Recupera todos los datos del departamento
		
			Empleado emp = new Empleado();//crea un objeto empleado
			emp.setDni("010203");			//Inserta dni
			emp.setNomEmp("Jose");			//Inserta nombre empleado
			emp.setDepartamento(depto);		//Inserta id departamento
		
			sesion.save(emp);				//convierte en objeto persistente para que realice cambios en la base de datos
		*/
		
		//CONSULTAS EN LA BASE DE DATOS HQL
		//CONSULTA 1
//		System.out.println("Introduzcas el nombre del departamento");
//		String query = mac.readLine();
//		
//		Query sentencia = sesion.createQuery("FROM Departamento WHERE nomDepto = :nombre");
//			sentencia.setParameter("nombre", query);
//			
//			List <Departamento>departamento = sentencia.getResultList(); //Obtiene un conjunto de objetos
//			for (Departamento dep : departamento) {
//				System.out.println(dep.getSede().getNomSede());
//				
//			}
//			
//		//CONSULTA 2
//		System.out.println("Introduzcas el id de la sede");
//			int query2 = Integer.parseInt(mac.readLine());
//			
//			//Sede s = sesion.get(Sede.class, query2);
//			
//			Query sentencia2 = sesion.createQuery("FROM Departamento WHERE sede.idSede = :sede"); //entra en la propiedad de departamento sede y luego entra a la clase sede a obtener el idSede
//			sentencia2.setParameter("sede", query2);
//			
//			List<Departamento> depa = sentencia2.getResultList();
//			
//			for (Departamento d : depa) {
//				System.out.println(d.getNomDepto());
//			}
//			
//		//CONSULTA 3 join entre tablas
//			Query sentencia3 = sesion.createQuery("FROM Departamento d, Sede s WHERE d.sede = s");
//			
//			List resultados = sentencia3.getResultList();
//			
//			for (Object ob : resultados) {
//				Object[] result = (Object[])ob;
//				Departamento dep = (Departamento)result[0];
//				Sede sede = (Sede)result[1];
//				System.out.println(dep.getSede().getNomSede());
//			}
//		
//			
//			Departamento dept = sesion.get(Departamento.class, 3);
//			Sede sed = sesion.get(Sede.class, 1);
//			Query senten = sesion.createQuery("UPDATE Departamento SET sede = :sede WHERE idDepto = :idDepto");
//			senten.setParameter("sede", sed);
//			senten.setParameter("idDepto", 3);
//			senten.executeUpdate();
		
			Query senten2 = sesion.createQuery("UPDATE Sede  SET nomSede = :nomSede WHERE idSede= :idSede");
			senten2.setParameter("nomSede", "Alicante");
			senten2.setParameter("idSede", 5);
			senten2.executeUpdate();
		
		tx.commit();
		sesion.close();

	}

}