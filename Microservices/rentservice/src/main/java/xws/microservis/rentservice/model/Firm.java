package xws.microservis.rentservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	 * TODO:provjeriti sta je JoinColumn 
	 * */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="users")
	private List<User> firmUsers;

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

	public Set<Car> getFirmCars() {
		return firmCars;
	}

	public void setFirmCars(Set<Car> firmCars) {
		this.firmCars = firmCars;
	}

	public List<User> getFirmUsers() {
		return firmUsers;
	}

	public void setFirmUsers(List<User> firmUsers) {
		this.firmUsers = firmUsers;
	}




}
