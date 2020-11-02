package EjercicioSchema2;

import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Main {

	public static void main(String[] args) throws DatatypeConfigurationException {
		
		Doc d = new Doc();
	
		Doc.Airport aeropuerto = new Doc.Airport();
			aeropuerto.setName("Barajas");
			aeropuerto.setTax(new BigInteger("5.0"));
			aeropuerto.setAirId("LHR");
		
		Doc.Airport aeropuerto2 = new Doc.Airport();
			aeropuerto2.setName("Quito");
			aeropuerto2.setTax(new BigInteger("5.3"));
			aeropuerto2.setAirId("PSA");
		
		d.getAirport().add(aeropuerto);
		d.getAirport().add(aeropuerto2);
		
		
		Doc.Flight volar = new Doc.Flight();
			Intervalo in = new Intervalo();
				in.setValue(new BigInteger("M005"));
				
				GregorianCalendar gc = new GregorianCalendar();
				XMLGregorianCalendar ca = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
					String fecha = "2020-11-02";
					String [] fec = fecha.split("-");
					
					ca.setYear(Integer.parseInt(fec[0]));
					ca.setMonth(Integer.parseInt(fec[1]));
					ca.setDay(Integer.parseInt(fec[2]));
			volar.getSeats().add(in);
			volar.setDate(ca);
			
			
			
		

	}

}
