package xws.microservis.advertservice.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashMap;

import javax.persistence.*;


@Entity
public class PriceList {

	@Id
	@GenericGenerator(name = "pricelist_seq",strategy = "sequence", parameters ={
			@org.hibernate.annotations.Parameter(name = "pricelist_seq_name", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
			@org.hibernate.annotations.Parameter(name = "initial_value", value = "500"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "100")
	})
	@GeneratedValue(generator = "pricelist_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private Double pricePerDay;
	
	@Column
	private Double pricePerKilometer;
	
	@Column
	private Double priceCDW;
	
	//Intervali za popust
	/***
	 * ТОDO: intervali za popust impelementacija
	 */

	@ManyToOne
	@JoinColumn
	private User user;

	@Column
	private Long monolitId;
	
	
	public PriceList() {
		
	}

	public PriceList(com.baeldung.springsoap.gen.PriceList priceList){
		this.pricePerDay = priceList.getPricePerDay();
		this.pricePerKilometer = priceList.getPricePerKilometer();
		this.priceCDW = priceList.getPriceCDW();
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


	public Double getPricePerDay() {
		return pricePerDay;
	}


	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}


	public Double getPricePerKilometer() {
		return pricePerKilometer;
	}


	public void setPricePerKilometer(Double pricePerKilometer) {
		this.pricePerKilometer = pricePerKilometer;
	}


	public Double getPriceCDW() {
		return priceCDW;
	}


	public void setPriceCDW(Double priceCDW) {
		this.priceCDW = priceCDW;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
