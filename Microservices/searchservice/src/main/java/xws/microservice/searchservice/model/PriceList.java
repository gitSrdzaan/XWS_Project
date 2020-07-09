package xws.microservice.searchservice.model;

import java.util.HashMap;

import javax.persistence.*;


@Entity
public class PriceList {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Double pricePerDay;
	
	@Column(nullable = false)
	private Double pricePerKilometer;
	
	@Column(nullable = false)
	private Double priceCDW;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "firm_id")
	private Firm firm;
	
	/***
	 * TODO: Implementirati izracunavanje popusta
	 */
	
	
	public PriceList() {
		
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
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


}
