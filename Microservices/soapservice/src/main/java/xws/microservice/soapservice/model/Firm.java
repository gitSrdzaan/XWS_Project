package xws.microservice.soapservice.model;

import javax.persistence.*;


@Entity
public class Firm {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	
	
	
	
	public Firm() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getFirmCity() {
		return firmCity;
	}

	public void setFirmCity(String firmCity) {
		this.firmCity = firmCity;
	}

	public String getFirmCountry() {
		return firmCountry;
	}

	public void setFirmCountry(String firmCountry) {
		this.firmCountry = firmCountry;
	}

	public String getFirmAdress() {
		return firmAdress;
	}

	public void setFirmAdress(String firmAdress) {
		this.firmAdress = firmAdress;
	}





}
