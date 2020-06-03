package xws.microservice.searchservice.model;

import java.util.HashMap;

import javax.persistence.*;


@Entity
public class PriceList {

	@Id
	private Long id;
	
	@Column
	private Double pricePerDay;
	
	@Column
	private Double pricePerKilometer;
	
	@Column
	private Double priceCDW;
	
	//Intervali za popust
	
	private HashMap<Integer , Integer> saleIntervals ; 
	
	
	public PriceList() {
		
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


	public HashMap<Integer, Integer> getSaleIntervals() {
		return saleIntervals;
	}


	public void setSaleIntervals(HashMap<Integer, Integer> saleIntervals) {
		this.saleIntervals = saleIntervals;
	}
}
