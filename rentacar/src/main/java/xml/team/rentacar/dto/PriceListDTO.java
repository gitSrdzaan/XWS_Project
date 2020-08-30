package xml.team.rentacar.dto;

import java.util.HashMap;


import xml.team.rentacar.model.PriceList;

public class PriceListDTO {

	
	private Long id;
	
	
	private Double pricePerDay;
	
	private Double pricePerKilometer;
	
	
	private Double priceCDW;
	
	
	private HashMap<Integer , Integer> saleIntervals ; 
	
	private Long firmID;
	
	public PriceListDTO() {
		
	}
	
	public PriceListDTO(PriceList priceList) {
		// TODO Auto-generated constructor stub
		this.id = priceList.getId();
		this.pricePerDay = priceList.getPricePerDay();
		this.priceCDW = priceList.getPriceCDW();
		this.pricePerKilometer = priceList.getPricePerKilometer();
		//this.saleIntervals = priceList.getSaleIntervals();
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

	public Long getFirmID() {
		return firmID;
	}

	public void setFirmID(Long firmID) {
		this.firmID = firmID;
	}

}
