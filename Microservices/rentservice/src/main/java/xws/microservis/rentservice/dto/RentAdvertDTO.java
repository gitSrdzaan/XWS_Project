package xws.microservis.rentservice.dto;

import java.util.Date;

import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.model.PriceList;
import xws.microservis.rentservice.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Car car;
	private Date advertStartDate;
	private Date advertEndDate;
	private PriceList priceList;
	
	public RentAdvertDTO(RentAdvert ra) {
		this.id = ra.getId();
		this.car = ra.getCar();
		this.advertStartDate = ra.getAdvertStartDate();
		this.advertEndDate = ra.getAdvertEndDate();
		this.priceList = ra.getPriceList();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
	public PriceList getPriceList() {
		return priceList;
	}
	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
}
