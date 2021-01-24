package Principal;

import java.io.File;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Operaciones {
	
	public void anadirProyecto() {
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      	DocumentBuilder builder = factory.newDocumentBuilder();
			
	      	LinkedList<Proyecto> proyectosArray = new LinkedList<>();
	      	
	      	Document document = builder.parse( new File("datos.xml"));
	      
	      	Node nodo = document.getFirstChild();
	      	//	Recursividad.recursivo(nodo);
	      	      	      	
	      	NodeList nodos = document.getChildNodes();
	      	
	      	
	      	
	      	for(int i=0; i<nodos.getLength(); i++) {
	      		Proyecto proyecto = new Proyecto();
	      	
		      	String nombre= "";
		      	String dniJefe = "";
		      	
		      	LinkedList<Emp_asignados> empleados = new LinkedList<Emp_asignados>();
		      	LinkedList<Integer> dnis = new LinkedList<Integer>();
	      		
	      		if(nodos.item(i).getNodeType() == Node.ELEMENT_NODE) {
	      			NodeList nodoProyecto = nodos.item(i).getChildNodes();
	      			for(int x=0; x<nodoProyecto.getLength();x++) {
	      				if(nodoProyecto.item(x).getNodeType() == Node.ELEMENT_NODE) {
	      					if(nodoProyecto.item(x).getNodeName().equals("proyecto")) {
	      						NodeList prueba = nodoProyecto.item(x).getChildNodes();
	      						for(int j=0; j<prueba.getLength();j++) {
	      							if(prueba.item(j).getNodeType() == Node.ELEMENT_NODE) {
	      								if(prueba.item(j).getNodeName().equals("nombre")) {
	      									System.out.println(prueba.item(j).getFirstChild().getNodeValue());
	      									nombre = prueba.item(j).getFirstChild().getNodeValue();
	      									
	      								}
	      								if(prueba.item(j).getNodeName().equals("dni_jefe")) {
	      									System.out.println(prueba.item(j).getFirstChild().getNodeValue());
	      									dniJefe = prueba.item(j).getFirstChild().getNodeValue();
	      								}
	      								if(prueba.item(j).getNodeName().equals("emp_asignados")) {
	      									NodeList dos = prueba.item(j).getChildNodes();
	      									for(int z=0; z<dos.getLength();z++) {
	      										if(dos.item(z).getNodeType() == Node.ELEMENT_NODE) {
	      											if(dos.item(z).getNodeName().equals("dni")) {
	      												System.out.println(dos.item(z).getFirstChild().getNodeValue());
	      												String dni = "";
	      												dni = dos.item(z).getFirstChild().getNodeValue();
	      												dnis.add(Integer.parseInt(dni));
	      											}
	      										}
	      									}
	      									empleados.add(new Emp_asignados(dnis));
	      								}
	      							}
	      						}
	      						
	      					}
	      			
	      				}
	      		
	      			}
	      		}
	      		
	      		if(nombre !=null && dniJefe !=null) {
		      		proyecto.setNombre(nombre);
		      		proyecto.setDni_jefe(dniJefe);
		      		proyecto.setEmpleadoAsignado(empleados);
		      		
		      		proyectosArray.add(proyecto);
	      		}
	      		
	      	}
	      	
	      	for(int i=0; i<proyectosArray.size();i++) {
	      		String nombre = proyectosArray.get(i).getNombre();
	      		int dniJefe = Integer.parseInt(proyectosArray.get(i).getDni_jefe());
	      		
	      		
	      		PreparedStatement ps = conexion.prepareStatement("INSERT INTO proyectos (NOMBRE, DNI_NIF_JEFE_PROY) VALUES(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	      		ps.setString(1, nombre);
	      		ps.setInt(2,dniJefe);
	      		ps.executeUpdate();
	      		
	      		ResultSet rs = ps.getGeneratedKeys();
	      		rs.next();
	      		
	      		int key = rs.getInt(1);
	      		LinkedList<Emp_asignados> emp_asignados = proyectosArray.get(i).getEmpleadoAsignado();
	      		
	      		for(int j=0; j<emp_asignados.size();j++) {
	      			LinkedList<Integer> dnis = emp_asignados.get(j).getDni();
	      			for(int k =0; k<dnis.size();k++) {
	      				int dni = dnis.get(k);
	      				
	      				PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO asig_proyectos (DNI_NIF_EMP, NUM_PROY) VALUES(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	      				ps1.setInt(1, dni);
	      				ps1.setInt(2, key);
	      				ps1.executeUpdate();
	      			}
	      		}
	      		
	      	}
	      	
	      	conexion.close();
	      	
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public static void mostrarEmpleados() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			String consulta = JOptionPane.showInputDialog("Ingrese el nif del jefe");
			
			PreparedStatement ps = conexion.prepareStatement("SELECT NUM_PROY FROM proyectos WHERE DNI_NIF_JEFE_PROY=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, Integer.parseInt(consulta));
			
			ResultSet rs = ps.executeQuery();
			
			String aux = "";
			while(rs.next()) {
				
				PreparedStatement ps2 = conexion.prepareStatement("SELECT DNI_NIF_EMP FROM asig_proyectos WHERE NUM_PROY = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps2.setInt(1, rs.getInt(1));
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {
					PreparedStatement ps3 = conexion.prepareStatement("SELECT NOMBRE FROM empleados WHERE DNI_NIF=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ps3.setInt(1, rs2.getInt(1));
					ResultSet rs3 = ps3.executeQuery();
					
					while(rs3.next()) {
						String nombre = rs3.getString(1);
						aux = aux + nombre +"\n";
					}
					
					
				}
				
			}
			
			conexion.close();
			Main.textArea.setText(aux);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void generarXml() {
		try {
			Proyectos proyectos = new Proyectos(new LinkedList<Proyecto>());
			LinkedList<Emp_asignados> emp_asignados = new LinkedList<Emp_asignados>();
			LinkedList<Integer> dnis = new LinkedList<Integer>();
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			
			String consulta = JOptionPane.showInputDialog("Ingrese numero de proyecto");
			
			PreparedStatement ps = conexion.prepareStatement("SELECT NOMBRE, DNI_NIF_JEFE_PROY FROM proyectos WHERE NUM_PROY=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, Integer.parseInt(consulta));
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nombre = rs.getString(1);
				int numero = rs.getInt(2);
				
				PreparedStatement ps2 = conexion.prepareStatement("SELECT DNI_NIF_EMP FROM asig_proyectos WHERE NUM_PROY=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps2.setInt(1, numero);
				ResultSet rs1 = ps2.executeQuery();
				
				while(rs1.next()) {
					int dni = rs1.getInt(1);
					dnis.add(dni);
				}
				String num = String.valueOf(numero);
				emp_asignados.add(new Emp_asignados(dnis));
				proyectos.getProyecto().add(new Proyecto(nombre, num, emp_asignados));
			}
			
		
			JAXBContext	contexto = JAXBContext.newInstance(Proyectos.class);
				Marshaller m = contexto.createMarshaller();
			
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
				m.marshal(proyectos, new File("alumnos.xml"));  //Asignamos un nombre al fichero que nos va a generar
			
		
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Se pasa como argumento la clase principal que contiene @XmlRootElement 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void generarPdf() {
		
		try {
			ArrayList<Ireport> report = new ArrayList<Ireport>();
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ad_examen?serverTimezone=UTC","root","1234");
			
			PreparedStatement ps = conexion.prepareStatement("SELECT DNI_NIF_EMP, NUM_PROY FROM asig_proyectos ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int emple = rs.getInt(1);
				int proyec = rs.getInt(2);
				
				PreparedStatement ps1 = conexion.prepareStatement("SELECT NOMBRE FROM proyectos WHERE NUM_PROY = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps1.setInt(1, proyec);
				
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					String nombre = rs1.getString(1);
					
					PreparedStatement ps2 = conexion.prepareStatement("SELECT NOMBRE FROM empleados WHERE DNI_NIF = ?  ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ps2.setInt(1, emple);
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()) {
						String nombreEm = rs2.getString(1);
						report.add(new Ireport(nombre, nombreEm));
					}
				}
				
			}
			
			String reportSource1 = "./MiReport2/Report2.jrxml";
			String reportPDF1 = "InformeBoletin.pdf";
	
			JasperReport jasperReport1 = JasperCompileManager.compileReport(reportSource1);
			JRBeanCollectionDataSource datasource1 = new JRBeanCollectionDataSource(report);
			JasperPrint MiInforme1 = JasperFillManager.fillReport(jasperReport1, null, datasource1);
			JasperViewer.viewReport(MiInforme1);
			JasperExportManager.exportReportToPdfFile(MiInforme1, reportPDF1);
		
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
