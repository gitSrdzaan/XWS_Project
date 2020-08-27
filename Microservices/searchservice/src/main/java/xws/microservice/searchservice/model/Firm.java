package xws.microservice.searchservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Table(name = "firm")
@Entity
@PrimaryKeyJoinColumn(name = "firm_id")
public class Firm extends Owner {


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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cars")
	private Set<Car> firmCars;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
