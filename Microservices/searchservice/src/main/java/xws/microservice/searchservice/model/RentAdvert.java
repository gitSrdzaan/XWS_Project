package xws.microservice.searchservice.model;

import org.hibernate.annotations.GenericGenerator;

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

	/*@ManyToOne
	@JoinColumn(name = "firm", nullable = true)
	private Firm firm;

	@ManyToOne
	@JoinColumn(name = "user", nullable = true)
	private User user;*/

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "owner_id")
	private Owner owner;

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


	/*public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}*/

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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
