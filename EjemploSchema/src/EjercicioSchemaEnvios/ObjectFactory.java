//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.1 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.02 a las 12:53:50 PM CET 
//


package EjercicioSchemaEnvios;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the EjercicioSchemaEnvios package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: EjercicioSchemaEnvios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Shiporder }
     * 
     */
    public Shiporder createShiporder() {
        return new Shiporder();
    }

    /**
     * Create an instance of {@link Shiporder.Shipto }
     * 
     */
    public Shiporder.Shipto createShiporderShipto() {
        return new Shiporder.Shipto();
    }

    /**
     * Create an instance of {@link Shiporder.Item }
     * 
     */
    public Shiporder.Item createShiporderItem() {
        return new Shiporder.Item();
    }

}
