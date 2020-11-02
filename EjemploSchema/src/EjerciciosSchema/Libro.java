//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.1 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.11.02 a las 12:22:42 PM CET 
//


package EjerciciosSchema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Autores" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="10"/&gt;
 *         &lt;element name="Editorial" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="precio" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "titulo",
    "autores",
    "editorial"
})
@XmlRootElement(name = "Libro")
public class Libro {

    @XmlElement(name = "Titulo", required = true)
    protected String titulo;
    @XmlElement(name = "Autores", required = true)
    protected List<String> autores;
    @XmlElement(name = "Editorial", required = true)
    protected String editorial;
    @XmlAttribute(name = "precio")
    protected Double precio;

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the autores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAutores() {
        if (autores == null) {
            autores = new ArrayList<String>();
        }
        return this.autores;
    }

    /**
     * Obtiene el valor de la propiedad editorial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Define el valor de la propiedad editorial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditorial(String value) {
        this.editorial = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrecio(Double value) {
        this.precio = value;
    }

}
