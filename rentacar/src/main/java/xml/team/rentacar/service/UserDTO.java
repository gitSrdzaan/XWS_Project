package xml.team.rentacar.service;

import java.util.Set;

import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String surname;
	private String driversLicence;
	/*@Column(nullable = false)
	private String drivingExpericence;*/
	private String username;
	private String email;
	private String password;
	private Set<Car> userCars;
	
	public UserDTO(User user) {
		this.id=user.getId();
		this.name=user.getName();
		this.surname=user.getSurname();
		this.driversLicence=user.getDriversLicence();
		this.username=user.getUsername();
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.userCars=user.getUserCars();
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
