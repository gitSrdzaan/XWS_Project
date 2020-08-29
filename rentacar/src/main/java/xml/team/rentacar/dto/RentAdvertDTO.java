package xml.team.rentacar.dto;

import java.util.Date;

import xml.team.rentacar.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Long carID;
	private Date advertStartDate;
	private Date advertEndDate;
	private Long priceListID;
	private Double priceForRent;


	public RentAdvertDTO() {
		
	}
	
	public RentAdvertDTO(RentAdvert ra) {
		this.id = ra.getId();
		this.carID = ra.getCar().getId();
		this.advertStartDate = ra.getAdvertStartDate();
		this.advertEndDate = ra.getAdvertEndDate();
		this.priceListID = ra.getPriceList().getId();
		this.priceForRent = ra.getPriceForRent();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}

	public Date getAdvertStartDate() {
		return advertStartDate;
	}

	public void setAdvertStartDate(Date advertStartDate) {
		this.advertStartDate = advertStartDate;
	}

	public Date getAdvertEndDate() {
		return advertEndDate;
	}

	public void setAdvertEndDate(Date advertEndDate) {
		this.advertEndDate = advertEndDate;
	}

	public Long getCarID() {
		return carID;
	}

	public void setCarID(Long carID) {
		this.carID = carID;
	}

	public Long getPriceListID() {
		return priceListID;
	}

	public void setPriceListID(Long priceListID) {
		this.priceListID = priceListID;
	}

	
	
	
	
}
