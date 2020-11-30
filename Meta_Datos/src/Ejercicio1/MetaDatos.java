package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDatos {

	public static void main(String[] args) {
		
		Consulta consulta = new Consulta();
		String url = "jdbc:mysql://localhost:3306/pruebametadatos?serverTimezone=UTC";
		Connection c=null;
		try {
			c = DriverManager.getConnection(url,"root","1234");
			consulta.resultados(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
