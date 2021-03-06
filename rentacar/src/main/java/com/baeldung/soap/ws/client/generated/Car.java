
package com.baeldung.soap.ws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="car"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="carRegistration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carMark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carFuel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transmission" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carMileage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="carGrade" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="kidsSeats" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
@XmlType(name = "car", propOrder = {
    "id",
    "carRegistration",
    "carMark",
    "carModel",
    "carClass",
    "carFuel",
    "transmission",
    "carMileage",
    "carGrade",
    "kidsSeats",
    "owner"
})
public class Car {

    protected Long id;
    protected String carRegistration;
    protected String carMark;
    protected String carModel;
    protected String carClass;
    protected String carFuel;
    protected String transmission;
    protected Integer carMileage;
    protected Integer carGrade;
    protected Integer kidsSeats;
    protected String owner;

    public Car (){

    }

    public Car(xml.team.rentacar.model.Car car){
        this.id = car.getId();
        this.kidsSeats = car.getKidsSeats();
        this.carGrade = car.getCarGrade();
        this.carMileage = car.getCarMileage();
        this.carRegistration = car.getCarRegistration();
        this.carMark = car.getCarMark();
        this.carModel = car.getCarModel();
        this.carClass = car.getCarClass();
        this.carFuel= car.getCarFuel();
        this.transmission = car.getTransmission();
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
     * Gets the value of the carRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarRegistration() {
        return carRegistration;
    }

    /**
     * Sets the value of the carRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarRegistration(String value) {
        this.carRegistration = value;
    }

    /**
     * Gets the value of the carMark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarMark() {
        return carMark;
    }

    /**
     * Sets the value of the carMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarMark(String value) {
        this.carMark = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarModel(String value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the carClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Sets the value of the carClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarClass(String value) {
        this.carClass = value;
    }

    /**
     * Gets the value of the carFuel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarFuel() {
        return carFuel;
    }

    /**
     * Sets the value of the carFuel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarFuel(String value) {
        this.carFuel = value;
    }

    /**
     * Gets the value of the transmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets the value of the transmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmission(String value) {
        this.transmission = value;
    }

    /**
     * Gets the value of the carMileage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCarMileage() {
        return carMileage;
    }

    /**
     * Sets the value of the carMileage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCarMileage(Integer value) {
        this.carMileage = value;
    }

    /**
     * Gets the value of the carGrade property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCarGrade() {
        return carGrade;
    }

    /**
     * Sets the value of the carGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCarGrade(Integer value) {
        this.carGrade = value;
    }

    /**
     * Gets the value of the kidsSeats property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKidsSeats() {
        return kidsSeats;
    }

    /**
     * Sets the value of the kidsSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKidsSeats(Integer value) {
        this.kidsSeats = value;
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
