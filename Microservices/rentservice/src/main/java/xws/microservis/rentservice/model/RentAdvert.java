package xws.microservis.rentservice.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentAdvert {

	@OneToOne
	@JoinColumn
	private Car car;
	
	@Column(nullable = false)
	private Date advertStartDate;
	
	@Column(nullable = false)
	private Date advertEndDate;
	
	
	@Column(nullable=false)
	private PriceList priceList;
	
	
	
	
	
	
	public RentAdvert() {
		
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
