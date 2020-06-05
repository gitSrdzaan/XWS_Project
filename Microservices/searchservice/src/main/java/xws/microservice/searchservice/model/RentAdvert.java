package xws.microservice.searchservice.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentAdvert {

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(nullable = false)
	private Date advertStartDate;
	
	@Column(nullable = false)
	private Date advertEndDate;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pricelist_id")
	private PriceList priceList;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






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
