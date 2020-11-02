//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.1 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.02 a las 12:49:17 PM CET 
//


package EjercicioSchema2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Airport" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.someElements.es}name"/&gt;
 *                   &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="airId"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="LHR"/&gt;
 *                       &lt;enumeration value="ZRH"/&gt;
 *                       &lt;enumeration value="PSA"/&gt;
 *                       &lt;enumeration value="MDR"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Flight" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="seats" type="{http://www.someElements.es}intervalo" maxOccurs="unbounded"/&gt;
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="source"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="LHR"/&gt;
 *                         &lt;enumeration value="ZRH"/&gt;
 *                         &lt;enumeration value="PSA"/&gt;
 *                         &lt;enumeration value="MDR"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="destination"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="LHR"/&gt;
 *                         &lt;enumeration value="ZRH"/&gt;
 *                         &lt;enumeration value="PSA"/&gt;
 *                         &lt;enumeration value="MDR"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="flightId"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;pattern value="[A-Z]{2}[0-9]{4}"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Passenger" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.someElements.es}name"/&gt;
 *                   &lt;element name="passportnumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Reservation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="flightRef" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="passRef" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="creditCard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "airport",
    "flight",
    "passenger",
    "reservation"
})
@XmlRootElement(name = "doc")
public class Doc {

    @XmlElement(name = "Airport")
    protected List<Doc.Airport> airport;
    @XmlElement(name = "Flight")
    protected Doc.Flight flight;
    @XmlElement(name = "Passenger")
    protected Doc.Passenger passenger;
    @XmlElement(name = "Reservation")
    protected Doc.Reservation reservation;

    /**
     * Gets the value of the airport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the airport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAirport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Doc.Airport }
     * 
     * 
     */
    public List<Doc.Airport> getAirport() {
        if (airport == null) {
            airport = new ArrayList<Doc.Airport>();
        }
        return this.airport;
    }

    /**
     * Obtiene el valor de la propiedad flight.
     * 
     * @return
     *     possible object is
     *     {@link Doc.Flight }
     *     
     */
    public Doc.Flight getFlight() {
        return flight;
    }

    /**
     * Define el valor de la propiedad flight.
     * 
     * @param value
     *     allowed object is
     *     {@link Doc.Flight }
     *     
     */
    public void setFlight(Doc.Flight value) {
        this.flight = value;
    }

    /**
     * Obtiene el valor de la propiedad passenger.
     * 
     * @return
     *     possible object is
     *     {@link Doc.Passenger }
     *     
     */
    public Doc.Passenger getPassenger() {
        return passenger;
    }

    /**
     * Define el valor de la propiedad passenger.
     * 
     * @param value
     *     allowed object is
     *     {@link Doc.Passenger }
     *     
     */
    public void setPassenger(Doc.Passenger value) {
        this.passenger = value;
    }

    /**
     * Obtiene el valor de la propiedad reservation.
     * 
     * @return
     *     possible object is
     *     {@link Doc.Reservation }
     *     
     */
    public Doc.Reservation getReservation() {
        return reservation;
    }

    /**
     * Define el valor de la propiedad reservation.
     * 
     * @param value
     *     allowed object is
     *     {@link Doc.Reservation }
     *     
     */
    public void setReservation(Doc.Reservation value) {
        this.reservation = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.someElements.es}name"/&gt;
     *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="airId"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="LHR"/&gt;
     *             &lt;enumeration value="ZRH"/&gt;
     *             &lt;enumeration value="PSA"/&gt;
     *             &lt;enumeration value="MDR"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "tax"
    })
    public static class Airport {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected BigInteger tax;
        @XmlAttribute(name = "airId")
        protected String airId;

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Define el valor de la propiedad name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Obtiene el valor de la propiedad tax.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTax() {
            return tax;
        }

        /**
         * Define el valor de la propiedad tax.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTax(BigInteger value) {
            this.tax = value;
        }

        /**
         * Obtiene el valor de la propiedad airId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAirId() {
            return airId;
        }

        /**
         * Define el valor de la propiedad airId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAirId(String value) {
            this.airId = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="seats" type="{http://www.someElements.es}intervalo" maxOccurs="unbounded"/&gt;
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="source"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="LHR"/&gt;
     *               &lt;enumeration value="ZRH"/&gt;
     *               &lt;enumeration value="PSA"/&gt;
     *               &lt;enumeration value="MDR"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="destination"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="LHR"/&gt;
     *               &lt;enumeration value="ZRH"/&gt;
     *               &lt;enumeration value="PSA"/&gt;
     *               &lt;enumeration value="MDR"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="flightId"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;pattern value="[A-Z]{2}[0-9]{4}"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "seats",
        "date",
        "source",
        "destination"
    })
    public static class Flight {

        @XmlElement(required = true)
        protected List<Intervalo> seats;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;
        @XmlElement(required = true)
        protected String source;
        @XmlElement(required = true)
        protected String destination;
        @XmlAttribute(name = "flightId")
        protected String flightId;

        /**
         * Gets the value of the seats property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the seats property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSeats().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Intervalo }
         * 
         * 
         */
        public List<Intervalo> getSeats() {
            if (seats == null) {
                seats = new ArrayList<Intervalo>();
            }
            return this.seats;
        }

        /**
         * Obtiene el valor de la propiedad date.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Define el valor de la propiedad date.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Obtiene el valor de la propiedad source.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSource() {
            return source;
        }

        /**
         * Define el valor de la propiedad source.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Obtiene el valor de la propiedad destination.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestination() {
            return destination;
        }

        /**
         * Define el valor de la propiedad destination.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestination(String value) {
            this.destination = value;
        }

        /**
         * Obtiene el valor de la propiedad flightId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlightId() {
            return flightId;
        }

        /**
         * Define el valor de la propiedad flightId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlightId(String value) {
            this.flightId = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.someElements.es}name"/&gt;
     *         &lt;element name="passportnumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "passportnumber",
        "address"
    })
    public static class Passenger {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected BigInteger passportnumber;
        @XmlElement(required = true)
        protected String address;

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Define el valor de la propiedad name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Obtiene el valor de la propiedad passportnumber.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPassportnumber() {
            return passportnumber;
        }

        /**
         * Define el valor de la propiedad passportnumber.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPassportnumber(BigInteger value) {
            this.passportnumber = value;
        }

        /**
         * Obtiene el valor de la propiedad address.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddress() {
            return address;
        }

        /**
         * Define el valor de la propiedad address.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddress(String value) {
            this.address = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="flightRef" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="passRef" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="creditCard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "flightRef",
        "passRef",
        "creditCard"
    })
    public static class Reservation {

        @XmlElement(required = true)
        protected String flightRef;
        @XmlElement(required = true)
        protected BigInteger passRef;
        @XmlElement(required = true)
        protected String creditCard;

        /**
         * Obtiene el valor de la propiedad flightRef.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlightRef() {
            return flightRef;
        }

        /**
         * Define el valor de la propiedad flightRef.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlightRef(String value) {
            this.flightRef = value;
        }

        /**
         * Obtiene el valor de la propiedad passRef.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPassRef() {
            return passRef;
        }

        /**
         * Define el valor de la propiedad passRef.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPassRef(BigInteger value) {
            this.passRef = value;
        }

        /**
         * Obtiene el valor de la propiedad creditCard.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreditCard() {
            return creditCard;
        }

        /**
         * Define el valor de la propiedad creditCard.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreditCard(String value) {
            this.creditCard = value;
        }

    }

}
