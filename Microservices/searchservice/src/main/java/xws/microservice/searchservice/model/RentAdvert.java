package xws.microservice.searchservice.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentAdvert {

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(nullable = false)
	private Date advertStartDate;
	
	@Column(nullable = false)
	private Date advertEndDate;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pricelist_id")
	private PriceList priceList;

	@ManyToOne
	@JoinColumn(name = "firm")
	private Firm firm;

	@Column(nullable = true)
	private Double priceForRent;
	

	public RentAdvert() {
		
	}

	public Long getId() {
		return id;
	}

	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
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
