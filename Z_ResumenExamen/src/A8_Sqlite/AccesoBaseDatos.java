package A8_Sqlite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBaseDatos {
	//EJEMPLO CON SQLITE
	
	public static void main(String[] args) {
		try {
			BufferedReader mac = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Introduzca nombre del alumno a consultar");
			String nombre= mac.readLine();
			
			//crea la conexion con el archivo de la base de datos
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\SqLite\\sqlite-tools-win32-x86-3300100\\alumno.bd");
		/*
			Statement sentencia = conn.createStatement();//Clase sentencia basica generica que se crea a partir de la conexion
			//sentencia.executeUpdate("INSERT INTO usuario VALUES ('Jose',9)"); //sentencia de insert, delete, uddate
			//sentencia.executeQuery("select * from usuario");//sentencia de consulta
			
			ResultSet registros = sentencia.executeQuery("select * from usuario"); //Recoge el resultado de la consulta para luego recorrerlo y mostrar lo
			*/
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuario WHERE nombre = ?");//Sentencia precompilada para consultas
				ps.setString(1, nombre);
				
				ResultSet registros = ps.executeQuery(); //sentencia de consulta
			
			
			while(registros.next()) { //recorre el resultado de registros
				//System.out.print(registros.getString(1)+" "); //recoge el valor de la columna 1
				System.out.print(registros.getString("nombre")+" "); //es igual que el anterior pero con el nombre de la columna
				System.out.println(registros.getString(2));
			}
			
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

}
