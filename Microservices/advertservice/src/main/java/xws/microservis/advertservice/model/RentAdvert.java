package xws.microservis.advertservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentAdvert {
	
	@Id
	@GenericGenerator(name = "advert_seq",strategy = "sequence", parameters ={
			@org.hibernate.annotations.Parameter(name = "advert_seq_name", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
			@org.hibernate.annotations.Parameter(name = "initial_value", value = "500"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "100")
	})
	@GeneratedValue(generator = "advert_seq", strategy = GenerationType.SEQUENCE)
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

	@Column(nullable = true)
	private Double priceForRent;

	@Column
	private Long monolitId;

	
	
	
	public RentAdvert() {
		
	}


	public Long getMonolitId() {
		return monolitId;
	}

	public void setMonolitId(Long monolitId) {
		this.monolitId = monolitId;
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

	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}
}
