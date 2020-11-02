//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.1 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.02 a las 12:49:17 PM CET 
//


package EjercicioSchema2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the EjercicioSchema2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Name_QNAME = new QName("http://www.someElements.es", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: EjercicioSchema2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Doc }
     * 
     */
    public Doc createDoc() {
        return new Doc();
    }

    /**
     * Create an instance of {@link Doc.Airport }
     * 
     */
    public Doc.Airport createDocAirport() {
        return new Doc.Airport();
    }

    /**
     * Create an instance of {@link Doc.Flight }
     * 
     */
    public Doc.Flight createDocFlight() {
        return new Doc.Flight();
    }

    /**
     * Create an instance of {@link Doc.Passenger }
     * 
     */
    public Doc.Passenger createDocPassenger() {
        return new Doc.Passenger();
    }

    /**
     * Create an instance of {@link Doc.Reservation }
     * 
     */
    public Doc.Reservation createDocReservation() {
        return new Doc.Reservation();
    }

    /**
     * Create an instance of {@link AttributoClass }
     * 
     */
    public AttributoClass createAttributoClass() {
        return new AttributoClass();
    }

    /**
     * Create an instance of {@link Intervalo }
     * 
     */
    public Intervalo createIntervalo() {
        return new Intervalo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.someElements.es", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

}
