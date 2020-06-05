package xws.microservis.rentservice.dto;

import java.util.Date;


import xws.microservis.rentservice.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Long car_Id;
	private Date advertStartDate;
	private Date advertEndDate;
	private Long priceList_Id;
	
	public RentAdvertDTO(RentAdvert ra) {
		this.id = ra.getId();
		this.car_Id = ra.getCar().getId();
		this.advertStartDate = ra.getAdvertStartDate();
		this.advertEndDate = ra.getAdvertEndDate();
		this.priceList_Id = ra.getPriceList().getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getCar_Id() {
		return car_Id;
	}

	public void setCar_Id(Long car_Id) {
		this.car_Id = car_Id;
	}

	public Long getPriceList_Id() {
		return priceList_Id;
	}

	public void setPriceList_Id(Long priceList_Id) {
		this.priceList_Id = priceList_Id;
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

}
