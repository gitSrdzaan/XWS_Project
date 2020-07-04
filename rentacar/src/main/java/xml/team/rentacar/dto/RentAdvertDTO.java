package xml.team.rentacar.dto;

import java.util.Date;

import xml.team.rentacar.model.RentAdvert;

public class RentAdvertDTO {

	private Long carID;
	private Date advertStartDate;
	private Date advertEndDate;
	private Long priceListID;
	
	public RentAdvertDTO() {
		
	}
	
	public RentAdvertDTO(RentAdvert ra) {
		//this.carDTO = new CarDTO(ra.getCar());
		this.advertStartDate = ra.getAdvertStartDate();
		this.advertEndDate = ra.getAdvertEndDate();
		//this.priceListDTO = new PriceListDTO(ra.getPriceList());
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
