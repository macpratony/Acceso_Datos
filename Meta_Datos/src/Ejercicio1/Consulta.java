package Ejercicio1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {

	public void resultados(Connection c) {
		
		try {
			DatabaseMetaData dbmd = c.getMetaData();
			
			System.out.println(dbmd.getURL()); //Imprimimos la URL para conocer el nombre de la base de datos
			System.out.println("********************");
			
			//Sacamos las tablas que tiene esa base de datos
			ResultSet rs = dbmd.getTables("pruebametadatos", "pruebametadatos", null, null);
			
			String nombreTabla = "";
			String nombreColumna = "";
			String tipoDato = "";
			
			while(rs.next()) {
				nombreTabla = rs.getString("TABLE_NAME");
				System.out.println(nombreTabla); //Obtenemos el nombre de todas las tablas de esa base de datos
				
				System.out.println("********************");
			}
			
			ResultSet columnas = dbmd.getColumns("pruebametadatos", "pruebametadatos", null, null);
			while(columnas.next()) {
				System.out.println((columnas.getString("COLUMN_NAME")));
				System.out.println(columnas.getString("TYPE_NAME"));
			}
			System.out.println("*******************************************************");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
