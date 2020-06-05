package xws.microservis.rentservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class RentAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Car car;
	
	@Column()
	private Date advertStartDate;
	
	@Column()
	private Date advertEndDate;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pricelist_id")
	private PriceList priceList;

	
	public RentAdvert() {
		
	}


	public Car getCar() {
		return car;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
