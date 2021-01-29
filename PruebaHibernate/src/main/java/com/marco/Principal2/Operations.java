package com.marco.Principal2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.marco.com.Departamento;
import clases.marco.com.Empleado;
import clases.marco.com.Proyecto;

public class Operations {
	
	public static void insertarEmpleado(Session sesion, Transaction tx) {
		//Transaction tx = sesion.beginTransaction();
		Empleado empleado = new Empleado();
		
		String dni = JOptionPane.showInputDialog("Ingrese el dni del empleado");
			empleado.setDni(dni);
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
			empleado.setNomEmp(nombre);
			
		int nombreDepartamento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del departamento al que va a pertenecer"));
			Departamento dep = sesion.get(Departamento.class, nombreDepartamento);
			
				empleado.setDepartamento(dep);
				
			sesion.save(empleado);
			tx.commit();
			sesion.close();
			
		
	}
	
	public static void insertarProyecto(Session sesion, Transaction tx) throws ParseException {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
         
		
		Proyecto proyecto = new Proyecto();
		String fecha = JOptionPane.showInputDialog("Ingrese la fecha en formato dd-mm-aaaa");
			Date fechaInicio = objSDF.parse(fecha);
			proyecto.setFInicio(fechaInicio);
		
		String fecha2 = JOptionPane.showInputDialog("Ingrese la fecha de fin en formato dd-mm-aaaa");
			Date fechaFin = objSDF.parse(fecha2);
			proyecto.setFFin(fechaFin);
			
		String nombreProyecto = JOptionPane.showInputDialog("Ingrese el nombre del proyecto");
			proyecto.setNomProy(nombreProyecto);
			
			sesion.save(proyecto);
			tx.commit();
			sesion.close();
	}
}
