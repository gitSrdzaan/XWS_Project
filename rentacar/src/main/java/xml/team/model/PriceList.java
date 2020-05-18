package xml.team.model;

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
	
	
	public PriceList() {
		
	}
}
