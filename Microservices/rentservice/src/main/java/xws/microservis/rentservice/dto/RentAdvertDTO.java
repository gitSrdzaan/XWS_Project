package xws.microservis.rentservice.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import xws.microservis.rentservice.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Long carId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date advertStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date advertEndDate;
	private Long priceListId;
	private Double priceForRent;

	private Long owner_id;
	
	public RentAdvertDTO(RentAdvert ra) {
		this.id = ra.getId();
		this.carId = ra.getCar().getId();
		this.advertStartDate = ra.getAdvertStartDate();
		this.advertEndDate = ra.getAdvertEndDate();
		this.priceListId = ra.getPriceList().getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}
}
