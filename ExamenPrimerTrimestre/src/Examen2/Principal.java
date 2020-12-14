package Examen2;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Principal {
	
	private static final Logger logger = LogManager.getLogger(Principal.class);
	
	public static void main(String[] args) {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion"));
		
		switch (op) {
		case 1:
			Operaciones.insertarEmpleado();
			logger.info("Accediendo al metodo de insertar empleado");
			break;

		case 2:
			
			Operaciones.insertarDepartamento();
			logger.info("Accediendo al metodo de insertar departamento");
			break;
			
		}
		
		
		
		
	}

}
