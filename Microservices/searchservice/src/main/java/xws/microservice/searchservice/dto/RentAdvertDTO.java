package xws.microservice.searchservice.dto;

import java.util.Date;

import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.PriceList;
import xws.microservice.searchservice.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Car car;
	private Date advertStartDate;
	private Date advertEndDate;
	private PriceList priceList;
	
	public RentAdvertDTO(RentAdvert rentAdvert) {
		this.id = rentAdvert.getId();
		this.car = rentAdvert.getCar();
		this.advertStartDate = rentAdvert.getAdvertStartDate();
		this.advertEndDate = rentAdvert.getAdvertEndDate();
		this.priceList = rentAdvert.getPriceList();
	}
	
	
	
	public RentAdvertDTO() {
		super();
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
