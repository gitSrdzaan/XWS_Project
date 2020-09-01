
package com.baeldung.soap.ws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rentrequest" type="{http://www.baeldung.com/springsoap/gen}rentrequest"/&gt;
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
    "rentrequest"
})
@XmlRootElement(name = "getRentRequestRequest")
public class GetRentRequestRequest {

    @XmlElement(required = true)
    protected Rentrequest rentrequest;

    /**
     * Gets the value of the rentrequest property.
     * 
     * @return
     *     possible object is
     *     {@link Rentrequest }
     *     
     */
    public Rentrequest getRentrequest() {
        return rentrequest;
    }

    /**
     * Sets the value of the rentrequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rentrequest }
     *     
     */
    public void setRentrequest(Rentrequest value) {
        this.rentrequest = value;
    }

}
