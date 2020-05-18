package xml.team.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentAdvert {

	@OneToOne
	@JoinColumn
	private Car car;
	
	@Column(nullable = false)
	private Date advertStartDate;
	
	@Column(nullable = false)
	private Date advertEndDate;
	
	/**
	 * TODO: Cjenovnik/Cenovnik
	 */
	
	
	
	
	
	
	public RentAdvert() {
		
	}
	
}
