package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemnploTransaccion {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/colegio?serverTimezone=UTC";
		
		boolean todobien = true;
		Connection c = null;
		try {
			c = DriverManager.getConnection(url,"root","1234");
			c.setAutoCommit(false); //Apagamos el commit que por defecto viene en true con esto podemos realizar dos consultas a la vez 
			
			Statement st = c.createStatement();
				
				st.executeUpdate("UPDATE alumnos SET edad = edad+1 WHERE nombres = 'Carlos'");
				st.executeUpdate("UPDATE alumnos SET edad = edad-1 WHERE nombres = 'Raul'");
				
		} catch (SQLException e) {
			//System.out.println("Error en alguna sentencia");
			e.printStackTrace();
			todobien = false;
		}
		
		if(todobien) { //si todo ha ido bien hace el commit
			
			try {
				System.out.println("Hacemos commit");
				c.commit();
			} catch (SQLException e) {
				try { //si el commit no se ha ejecutado con el rollback volvemos a las sentencias
					System.out.println("Hacemos rollback");
					c.rollback();
				} catch (SQLException e1) {
					System.out.println("Error en eollback");
					e1.printStackTrace();
				}
			}
		}

	}

}
