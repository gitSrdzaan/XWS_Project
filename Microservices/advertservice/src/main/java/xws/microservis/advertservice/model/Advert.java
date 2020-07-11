package xws.microservis.advertservice.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class Advert {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Car car;
	
	@Column
	private Date advertStartDate;
	
	@Column
	private Date advertEndDate;

	@OneToOne
	@JoinColumn
	private PriceList priceList;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	public Advert() {
		
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
