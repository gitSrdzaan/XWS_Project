package xml.team.rentacar.model;

import java.util.HashSet;
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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String driversLicence;
	
	/*@Column(nullable = false)
	private String drivingExpericence;*/
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String userCity;

	@Column(nullable = false)
	private String userCountry;



	@Column(nullable = false)
	private String userAdress;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_cars", nullable = true)
	private Set<Car> userCars = new HashSet<Car>();
	
	public User() {
		//super();
		this.name="";
		this.surname="";
		this.driversLicence="";
		this.username="";
		this.email="";
		this.password="";
		this.userCars= new HashSet<Car>();
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDriversLicence() {
		return driversLicence;
	}

	public void setDriversLicence(String driversLicence) {
		this.driversLicence = driversLicence;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Car> getUserCars() {
		return userCars;
	}

	public void setUserCars(Set<Car> userCars) {
		this.userCars = userCars;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
