package EjercicioSchema2;

import java.io.File;
import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import EjercicioSchemaEnvios.Shiporder;

public class Main {

	public static void main(String[] args) throws DatatypeConfigurationException {
		
		Doc d = new Doc();
	
		Doc.Airport aeropuerto = new Doc.Airport();
			aeropuerto.setName("Barajas");
			aeropuerto.setTax(new BigInteger("5"));
			aeropuerto.setAirId("LHR");
		
		Doc.Airport aeropuerto2 = new Doc.Airport();
			aeropuerto2.setName("Quito");
			aeropuerto2.setTax(new BigInteger("7"));
			aeropuerto2.setAirId("PSA");
		
		d.getAirport().add(aeropuerto);
		d.getAirport().add(aeropuerto2);
		
		
		Doc.Flight volar = new Doc.Flight();
			
				Intervalo in = new Intervalo();
				in.setValue(new BigInteger("25"));
				in.setClazz("tourist");
				
				Intervalo in2 = new Intervalo();
				in2.setValue(new BigInteger("33"));
				in2.setClazz("first");
				
				//Añade los intervalos
				volar.getSeats().add(in);
				volar.getSeats().add(in2);
				
				//Añade fecha
				volar.setDate("25/08/2021");
				
				//Añade fuente
				volar.setSource("ZHR");
				
				//Añade destino
				volar.setDestination("LHR");
				
				//Añade vuelo
				volar.setFlightId("MX5625");
		
		d.setFlight(volar);
		
		Doc.Passenger pasajero = new Doc.Passenger();
				
				pasajero.setName("Roberto");
				pasajero.setPassportnumber(154548797);
				pasajero.setAddress("Madrid - Alcorcon");
				
		d.setPassenger(pasajero);
		
		Doc.Reservation reserva = new Doc.Reservation();
				
				reserva.setFlightRef("Volar");
				reserva.setPassRef(0506);
				reserva.setCreditCard("Mastercard");
				
		d.setReservation(reserva);
		
		
		try {
			
			JAXBContext contexto = JAXBContext.newInstance(Doc.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(d, new File("vuelos.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
				/*GregorianCalendar gc = new GregorianCalendar();
				XMLGregorianCalendar ca = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
					String fecha = "2020-11-02";
					String [] fec = fecha.split("-");
					
					ca.setYear(Integer.parseInt(fec[0]));
					ca.setMonth(Integer.parseInt(fec[1]));
					ca.setDay(Integer.parseInt(fec[2]));*/
			
			
			
			
		

	}

}
