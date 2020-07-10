package xws.microservice.searchservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SearchInfo {

    private String country;
    private String city;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;

    /**
     * Advanced search car info
     * */
    private String carMark;
    private String carModel;
    private String carClass;
    private String transmission;
    private String carFuel;
    private Integer carMileage;
    private Integer kidsSeats;
    private Integer intendingMileage;

    /**
     * Advanced search pricelist info
     * */
    private Integer priceLowerBound;
    private Integer priceUpperBound;
    private boolean enableCDW;


    public SearchInfo(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public Integer getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
    }

    public Integer getIntendingMileage() {
        return intendingMileage;
    }

    public void setIntendingMileage(Integer intendingMileage) {
        this.intendingMileage = intendingMileage;
    }

    public Integer getKidsSeats() {
        return kidsSeats;
    }

    public void setKidsSeats(Integer kidsSeats) {
        this.kidsSeats = kidsSeats;
    }

    public Integer getPriceLowerBound() {
        return priceLowerBound;
    }

    public void setPriceLowerBound(Integer priceLowerBound) {
        this.priceLowerBound = priceLowerBound;
    }

    public Integer getPriceUpperBound() {
        return priceUpperBound;
    }

    public void setPriceUpperBound(Integer priceUpperBound) {
        this.priceUpperBound = priceUpperBound;
    }

    public boolean isEnableCDW() {
        return enableCDW;
    }

    public void setEnableCDW(boolean enableCDW) {
        this.enableCDW = enableCDW;
    }
}
