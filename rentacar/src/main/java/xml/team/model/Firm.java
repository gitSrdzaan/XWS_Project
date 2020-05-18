package xml.team.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Firm {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Id
	@Column(nullable = false)
	private String pib;
	
	@Column(nullable = false)
	private String firmName;
	
	@Column(nullable = false)
	private String firmCity;
	
	@Column(nullable = false)
	private String firmCountry;
	
	@Column(nullable = false)
	private String firmAdress;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cars")
	private Set<Car> firmCars;
	
	/**
	 * TODO: Lista korisnika firme
	 * */
	
	
	
	
	
	
	
	public Firm() {
		
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getFirmName() {
		return firmName;
	}





	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}





	public String getFirmAdress() {
		return firmAdress;
	}





	public void setFirmAdress(String firmAdress) {
		this.firmAdress = firmAdress;
	}





}
