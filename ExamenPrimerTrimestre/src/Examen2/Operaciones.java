package Examen2;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;

import com.mysql.cj.protocol.Resultset;

public class Operaciones {
	
	 
	
	public static void insertarEmpleado() {
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			String dni = JOptionPane.showInputDialog("Ingrese el dni del empleado");
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
			
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO empleados (DNI_NIF, NOMBRE) VALUES (?,?)");
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.executeUpdate();
				
			conexion.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void insertarDepartamento()  {
		try {
		Connection conexion;
		
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
		
		
			String dni = JOptionPane.showInputDialog("Ingrese el dni del jefe");
			String nombreDepar = JOptionPane.showInputDialog("Ingrese el nombre del departamento");
			
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO departamentos (NOMBRE,DNI_NIF_JEFE_DEP) VALUES (?,?)");
			
			ps.setString(1, nombreDepar);
			ps.setString(2, dni);
			ps.executeUpdate();
			
	
			conexion.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static void mostrarEmpleadosDepartamento() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			
			String nombreDepartamento = JOptionPane.showInputDialog("Ingrese el nombre del departamento");
			
			PreparedStatement ps = conexion.prepareStatement("SELECT NUM_DEP FROM departamentos WHERE NOMBRE=?");
			ps.setString(1, nombreDepartamento);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PreparedStatement ps1 = conexion.prepareStatement("SELECT DNI_NIF_EMP FROM asig_departamentos WHERE NUM_DEP=?");
				int numero = rs.getInt(1);
				ps1.setInt(1, numero);
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
					PreparedStatement ps2 = conexion.prepareStatement("SELECT NOMBRE FROM empleados WHERE DNI_NIF=?");
					ps2.setInt(1, rs1.getInt(1));
					
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()) {
						String nombre = rs2.getString(1);
						System.out.println(nombre);
					}
				}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
}