
package pl.egu.agh.soa.lab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articles"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tittle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articles", propOrder = {
    "tittle"
})
public class Articles {

    protected String tittle;

    /**
     * Gets the value of the tittle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * Sets the value of the tittle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTittle(String value) {
        this.tittle = value;
    }

}
