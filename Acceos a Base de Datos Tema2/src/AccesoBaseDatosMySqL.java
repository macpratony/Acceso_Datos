import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBaseDatosMySqL {

	public static void main(String[] args) {
		try {
			
			BufferedReader mac = new BufferedReader ( new InputStreamReader(System.in));
		
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		//	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio?serverTimezone=UTC","root","1234");
			Connection conn = DriverManager.getConnection("jdbc:odbc:BaseDeDatos");
			
			System.out.println("Introduzca el nombre del alumno a consultar");
			String nombre = mac.readLine();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM cursoprueba WHERE nombre = ?");
				ps.setString(1, nombre);
				
				
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				System.out.print(result.getString(1)+" ");
				System.out.print(result.getString(2)+" ");
				//System.out.println(result.getString(3));
			}
			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
