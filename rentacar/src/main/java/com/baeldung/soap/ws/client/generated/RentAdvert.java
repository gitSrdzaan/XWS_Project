
package com.baeldung.soap.ws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rentAdvert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rentAdvert"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="advertEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="advertStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="priceListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
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
@XmlType(name = "rentAdvert", propOrder = {
    "advertEndDate",
    "advertStartDate",
    "carId",
    "id",
    "priceListId",
    "owner"
})
public class RentAdvert {

    protected String advertEndDate;
    protected String advertStartDate;
    protected Long carId;
    protected Long id;
    protected Long priceListId;
    protected String owner;

    public RentAdvert(){

    }

    public RentAdvert(xml.team.rentacar.model.RentAdvert rentAdvert){
        this.carId = rentAdvert.getCar().getId();
        this.id = rentAdvert.getId();
        this.priceListId= rentAdvert.getPriceList().getId();
        this.owner = "AGENT_APP";
    }
    /**
     * Gets the value of the advertEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvertEndDate() {
        return advertEndDate;
    }

    /**
     * Sets the value of the advertEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvertEndDate(String value) {
        this.advertEndDate = value;
    }

    /**
     * Gets the value of the advertStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvertStartDate() {
        return advertStartDate;
    }

    /**
     * Sets the value of the advertStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvertStartDate(String value) {
        this.advertStartDate = value;
    }

    /**
     * Gets the value of the carId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCarId() {
        return carId;
    }

    /**
     * Sets the value of the carId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCarId(Long value) {
        this.carId = value;
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
     * Gets the value of the priceListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriceListId() {
        return priceListId;
    }

    /**
     * Sets the value of the priceListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriceListId(Long value) {
        this.priceListId = value;
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
