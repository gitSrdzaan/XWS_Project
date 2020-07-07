package xws.microservis.rentservice.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;


@Entity
public class PriceList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double pricePerDay;
	
	@Column
	private Double pricePerKilometer;
	
	@Column
	private Double priceCDW;
	
	//Intervali za popust

	@Column
	@ElementCollection
	private Map<Integer , Integer> saleIntervals = new HashMap<Integer,Integer>() ;



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "firm_id")
	private Firm firm;


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
		return (HashMap<Integer, Integer>) saleIntervals;
	}


	public void setSaleIntervals(HashMap<Integer, Integer> saleIntervals) {
		this.saleIntervals = saleIntervals;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}
}
