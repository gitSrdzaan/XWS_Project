package xws.microservice.searchservice.dto;

import java.util.List;
import java.util.Set;

import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.model.User;

public class FirmDTO {

	private Long id;
	private String pib;
	private String firmName;
	private String firmCity;
	private String firmCountry;
	private String firmAdress;
	private Set<Car> firmCars;
	private List<User> firmUsers;
	
	
	public FirmDTO(Firm firm) {
		this.id = firm.getId();
		this.pib = firm.getPib();
		this.firmName = firm.getFirmName();
		this.firmCity = firm.getFirmCity();
		this.firmCountry = firm.getFirmCountry();
		this.firmAdress = firm.getFirmAdress();
		this.firmCars = firm.getFirmCars();
		this.firmUsers = firm.getFirmUsers();
		
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
