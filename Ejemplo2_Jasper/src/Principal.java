import java.util.Map;




import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		String reportSource = "./Mireport/Mireport2.jrxml";
		//String reportHTML = "./informes/Informe.html";
		String reportPDF = "Informe.pdf";
		//String reportXML = "./informes/Informe.xml";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", "RESUMEN DATOS DE DEPARTAMENTOS.");
		params.put("autor", "RAQUEL");
		params.put("fecha", (new java.util.Date()).toString());

		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");
			//JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, conn);
			
			ArrayList<Departamento> dept = new ArrayList<Departamento>();
			
			dept.add(new Departamento(1,"Informática","1"));
			dept.add(new Departamento(2,"Contabilidad","2"));
			dept.add(new Departamento(3,"Personal","3"));
			dept.add(new Departamento(4,"Limpieza","4"));
			
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(dept);
			
			JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, datasource);
			
			// Visualizar en pantalla
			//JasperViewer.viewReport(MiInforme);
			// Convertir a HTML
			//JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);
			// Convertir a PDF
			JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
			// Convertir a XML, false es para indicar que no hay imágenes
			// (isEmbeddingImages)
			//JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false);
			
		} /*catch (CommunicationsException c) {
			System.out.println(" Error de comunicación con la BD. No está arrancada.");
		} catch (ClassNotFoundException e) {
			System.out.println(" Error driver. ");
		} catch (SQLException e) {
			System.out.println(" Error al ejecutar sentencia SQL ");
		}*/ catch (JRException ex) {
			System.out.println(" Error Jasper.");
			ex.printStackTrace();
		}
	}

}
