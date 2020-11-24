
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		try {
			
			String nif="";
			String nombre = "";
			String email = "";
			int codigoPedido = 0;
			String descripcionPedido = "";
			String query = "";
			
		
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidosclientes?serverTimezone=UTC","root","1234");
			
			JOptionPane.showMessageDialog(null, "ELIJA UNA DE LAS SIGUIENTES OPCIONES: \n\n 1.-Insertar Cliente \n 2.- Insertar Pedido Nuevo \n 3.- Eliminar Cliente \n 4.- Eliminar Pedido \n 5.- Consultar Pedidos De Un Cliente");
			int opciones = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA OPCION QUE DESEA"));
			
			switch (opciones) {
			
				case 1 : 
					
					 nif = JOptionPane.showInputDialog("Ingrese el NIF del Cliente");
					 nombre = JOptionPane.showInputDialog("Ingrese Nombre del Cliente");
					 email = JOptionPane.showInputDialog("Ingrese El E-mail Del Cliente");
					
					 query = "INSERT INTO clientes VALUES ('"+nif+"','"+nombre+"','"+email+"')";
		
					Statement sentencia = conexion.createStatement();
					sentencia.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Cliente Creado Correctamente");
					break;
					
				case 2:
					
						 nif = JOptionPane.showInputDialog("Ingrese el nif del Cliente"); //Pedimos el nif del cliente para comprobar si existe en la base de datos
						
						PreparedStatement ps = conexion.prepareStatement("SELECT nif FROM clientes WHERE nif=?"); //Realizamos la busqueda del cliente
							ps.setString(1, nif);
							
						ResultSet result = ps.executeQuery(); //Devuelve resultado de la consulta
						
						while(result.next()) {
							if(result.getString(1).equals(nif)) { //Si existe el nif del cleinte en la base de datos ingresamos el pedido
								 codigoPedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Codigo del Pedido"));
								 descripcionPedido = JOptionPane.showInputDialog("Ingrese la descrpcion del Pedido");
								
								 query = "INSERT INTO pedidos VALUES ('"+codigoPedido+"','"+nif+"','"+descripcionPedido+"')";
								
								Statement st = conexion.createStatement();
								st.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Pedido Creado Correctamente");
								
							}else { //Si no existe el cliente nos arroja este mensaje
								JOptionPane.showMessageDialog(null, "El Cliente no existe");
							}
						}
						
					break;
					
				case 3:
					
					nif = JOptionPane.showInputDialog("Ingrese el nif del Cliente"); //Pedimos el nif del cliente para comprobar si existe en la base de datos
					//Busca en la tabla de pedidos los nif del cliente a eliminar ya que las tablas estan entrelazadas entre si
					//Y para eliminar el cliente primero tiene que elimniar los pedidos de ese cliente
					PreparedStatement ps1 = conexion.prepareStatement("SELECT nif FROM pedidos WHERE nif=?"); //Realizamos la busqueda del cliente
					ps1.setString(1, nif);
					
					ResultSet result1 = ps1.executeQuery(); //Devuelve resultado de la consulta
					while(result1.next()) {
						query = "DELETE FROM pedidos WHERE nif = '"+nif+"'";
						Statement eliminar = conexion.createStatement();
						eliminar.executeUpdate(query);
						
					}
					
					PreparedStatement ps2 = conexion.prepareStatement("SELECT nif FROM clientes WHERE nif=?"); //Realizamos la busqueda del cliente
					ps2.setString(1, nif);
					
					//Una vez elimina los pedidos busca el nif en la tabla clientes y lo elimina
					ResultSet result2 = ps2.executeQuery();
					while(result2.next()) {
						query = "DELETE FROM clientes WHERE nif='"+nif+"'";
						Statement eliminar2 = conexion.createStatement();
						eliminar2.executeUpdate(query);
					}
					
					JOptionPane.showMessageDialog(null, "Cliente Eliminado Correctamente");
					break;
					
				case 4:
					
					codigoPedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del pedido a eliminar"));
					
					PreparedStatement ps3 = conexion.prepareStatement("SELECT codigo FROM pedidos WHERE codigo=?"); //Realizamos la busqueda del cliente
					ps3.setInt(1,codigoPedido);
					
					ResultSet result3 = ps3.executeQuery(); //Devuelve resultado de la consulta
					while(result3.next()) {
						if(result3.getInt(1) == codigoPedido) {
							query = "DELETE FROM pedidos WHERE codigo = '"+codigoPedido+"'";
							Statement eliminar = conexion.createStatement();
							eliminar.executeUpdate(query);
						}else {
							JOptionPane.showMessageDialog(null, "El codigo de pedido no existe");
						}
					}
					
					JOptionPane.showMessageDialog(null, "Pedido Eliminado Correctamente");
					break;
					
				case 5:
					nif = JOptionPane.showInputDialog("Introduzca el nif del cliente a consultar");
					
					PreparedStatement ps4 = conexion.prepareStatement("SELECT * FROM pedidos WHERE nif=?");
						ps4.setString(1, nif);
						
					ResultSet result4 = ps4.executeQuery();
					while(result4.next()) {
						JOptionPane.showMessageDialog(null, result4.getInt(1)+"****"+result4.getString(2)+"****"+result4.getString(3));
					}
						
					
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "La opcion introducida no es valida");
				}
			
			conexion.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexión no establecida o el cliente no existe");
			e.printStackTrace();
		}
			
			
		

	}

}
