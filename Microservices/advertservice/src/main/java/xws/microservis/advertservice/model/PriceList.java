package xws.microservis.advertservice.model;

import java.util.HashMap;

import javax.persistence.*;


@Entity
public class PriceList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	public PriceList() {
		
	}

	public PriceList(com.baeldung.springsoap.gen.PriceList priceList){
		this.pricePerDay = priceList.getPricePerDay();
		this.pricePerKilometer = priceList.getPricePerKilometer();
		this.priceCDW = priceList.getPriceCDW();
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
