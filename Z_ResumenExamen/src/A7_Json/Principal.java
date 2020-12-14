package A7_Json;
import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;




public class Principal {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		
		try {
			
			Reader reader = new FileReader("aulas.json");	//Lee el archivo aula.json
			JSONObject objetoJson = (JSONObject) parser.parse(reader); //Lo transfroma en objeto Json
			JSONArray array = (JSONArray) objetoJson.get("aula1");  //Obtiene el array que se encuentra dentro de aula1
			JOptionPane.showMessageDialog(null, "ELige una de las siguientes opciones: \n"+"1. Aula con todos los alumnos y notas \n"+"2. Dada una materia listado de todos los alumnos \n"+"3. Boletin de notas de un alumno");
			String op = JOptionPane.showInputDialog("Ingrese una opcion");
			
			switch (op) {
			
			case "1": 
				
				System.out.println("*******Aula1*******");
					System.out.println("");
					for(int i=0; i<array.size();i++) { //Recorre el array de aula1
						
						JSONObject ob = (JSONObject) array.get(i); //Volvemos a convertir en objetos ya que el array contiene listado de objetos
						JSONArray array2 = (JSONArray)ob.get("notas"); //Como el objeto notas contiene un array pues volcamos los datos de esos en un JSONArray
						
						System.out.println("Datos del Alumno "+ (i+1));
						System.out.println("Nombre " + ob.get("nombre")); //Imprime el nombre que contiene el array de aula1
						for(int x=0; x<array2.size();x++) { //Aquí recorre el array de NOTAS 
							JSONObject ob2 = (JSONObject) array2.get(x); //Transforma en objetos el contenido del array de NOTAS
							System.out.println(ob2.get("materia")+" "+ob2.get("nota")); //Imprime el valor de los objetos
							
							
						}
						System.out.println("");
					}
				
				break;
			
			case "2" :
				
				String materiaConsulta = JOptionPane.showInputDialog("Ingrese una materia");
				String nombre = "";
				String materiaAlumno="";
				String nota = "";
				ArrayList<DatosMateria> datos = new ArrayList<DatosMateria>();
				
					for(int i=0; i<array.size();i++) {
						JSONObject ob = (JSONObject) array.get(i);
						JSONArray arr = (JSONArray) ob.get("notas");
						
						for(int x=0; x<arr.size();x++) {
							JSONObject ob1 = (JSONObject) arr.get(x);	
							String materia1 = (String) ob1.get("materia");
							
							if(materia1.equals(materiaConsulta)) {
								materiaAlumno = materia1;
								System.out.println(materia1);
								System.out.println(ob.get("nombre") + " "+ob1.get("nota"));
								nombre = (String) ob.get("nombre");
								nota = ob1.get("nota").toString();
								
								DatosMateria d = new DatosMateria(materiaAlumno, nombre, nota);
								datos.add(d);
							}
						}
					
					
					
					}		
					
								
					String reportSource = "./MiReport/ReportMateria.jrxml";
					String reportPDF = "InformeMateria.pdf";
					
				try {
					
					JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
					JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(datos);
					JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, null, datasource);
					JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
					
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "3" :
				
				String alumno = JOptionPane.showInputDialog("Ingrese el nombre de un alumno");
				String materia="";
				String notaAlumno="";
				ArrayList<DatosMateria> datos1 = new ArrayList<DatosMateria>();
				
				
				for(int i=0; i<array.size();i++) {
					JSONObject ob = (JSONObject) array.get(i);
					JSONArray array1 = (JSONArray) ob.get("notas");
					String nombreAlumno = (String) ob.get("nombre");
					
					if(nombreAlumno.equals(alumno)) {
						for(int x=0; x<array1.size();x++) {
							JSONObject ob1 = (JSONObject) array1.get(x);
							System.out.println(ob1.get("materia")+" "+ ob1.get("nota"));
							materia = (String) ob1.get("materia");
							notaAlumno = ob1.get("nota").toString();
							
							DatosMateria dato = new DatosMateria(materia, nombreAlumno, notaAlumno);
							datos1.add(dato);
						}
					}
					
				}
				
				String reportSource1 = "./MiReport2/Report2.jrxml";
				String reportPDF1 = "InformeBoletin.pdf";
			try {
				JasperReport jasperReport1 = JasperCompileManager.compileReport(reportSource1);
				JRBeanCollectionDataSource datasource1 = new JRBeanCollectionDataSource(datos1);
				JasperPrint MiInforme1 = JasperFillManager.fillReport(jasperReport1, null, datasource1);
				JasperExportManager.exportReportToPdfFile(MiInforme1, reportPDF1);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
