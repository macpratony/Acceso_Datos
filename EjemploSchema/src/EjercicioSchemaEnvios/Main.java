package EjercicioSchemaEnvios;

import java.awt.event.ItemEvent;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) {
		
		Shiporder envio = new Shiporder();
		
		envio.setOrderid("1");
		envio.setOrderperson("Juan");
		
		Shiporder.Shipto destinatario = new Shiporder.Shipto();
		
		destinatario.setAddress("Calle gran via");
		destinatario.setCity("Madrid");
		destinatario.setCountry("España");
		destinatario.setName("Raul");
		
		envio.setShipto(destinatario);
		
		
		Shiporder.Item it = new Shiporder.Item();
		it.setNote("Bueno");
		it.setPrice(new BigDecimal(7.2));
		it.setQuantity(new BigInteger("3"));
		it.setTitle("Bolis");
		
		Shiporder.Item it2 = new Shiporder.Item();
		
		it2.setNote("Malo");
		it2.setPrice(new BigDecimal(5.3));
		it2.setQuantity(new BigInteger("5"));
		it.setTitle("Cuadernos");
		
		envio.getItem().add(it);
		envio.getItem().add(it2);
		
		try {
			
			JAXBContext contexto = JAXBContext.newInstance(Shiporder.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(envio, new File("envios.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
