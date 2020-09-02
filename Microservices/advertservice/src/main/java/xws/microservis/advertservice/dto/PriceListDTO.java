package xws.microservis.advertservice.dto;

import xws.microservis.advertservice.model.User;

public class PriceListDTO {

    private Long id;
    private Double pricePerDay;
    private Double pricePerKilometer;
    private Double priceCDW;
    private Long owner_id;

    public PriceListDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public void setPricePerKilometer(Double pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    public Double getPriceCDW() {
        return priceCDW;
    }

    public void setPriceCDW(Double priceCDW) {
        this.priceCDW = priceCDW;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }
}
