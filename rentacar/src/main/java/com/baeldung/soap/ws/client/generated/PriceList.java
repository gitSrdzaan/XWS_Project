
package com.baeldung.soap.ws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for priceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="priceList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="pricePerKilometer" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="priceCDW" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceList", propOrder = {
    "id",
    "pricePerDay",
    "pricePerKilometer",
    "priceCDW",
    "owner"
})
public class PriceList {

    protected Long id;
    protected Double pricePerDay;
    protected Double pricePerKilometer;
    protected Double priceCDW;
    protected String owner;

    public PriceList() {

    }

    public PriceList(xml.team.rentacar.model.PriceList priceList){
        this.id = priceList.getId();
        this.priceCDW = priceList.getPriceCDW();
        this.pricePerDay = priceList.getPricePerDay();
        this.pricePerKilometer = priceList.getPricePerKilometer();
        this.owner = "AGENT_APP";
    }
    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the pricePerDay property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Sets the value of the pricePerDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPricePerDay(Double value) {
        this.pricePerDay = value;
    }

    /**
     * Gets the value of the pricePerKilometer property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPricePerKilometer() {
        return pricePerKilometer;
    }

    /**
     * Sets the value of the pricePerKilometer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPricePerKilometer(Double value) {
        this.pricePerKilometer = value;
    }

    /**
     * Gets the value of the priceCDW property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPriceCDW() {
        return priceCDW;
    }

    /**
     * Sets the value of the priceCDW property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPriceCDW(Double value) {
        this.priceCDW = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

}
