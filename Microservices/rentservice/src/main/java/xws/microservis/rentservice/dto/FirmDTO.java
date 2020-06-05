package xws.microservis.rentservice.dto;

import java.util.List;
import java.util.Set;


import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.model.User;

public class FirmDTO {
	
	private Long id;
	private String pib;
	private String firmName;
	private String firmCity;
	private String firmCountry;
	private String firmAdress;
	private Set<Long> firmCars_Id;
	private List<Long> firmUsers_Id;
	
	public FirmDTO(Firm firm) {
		this.id = firm.getId();
		this.pib = firm.getPib();
		this.firmName = firm.getFirmName();
		this.firmCity = firm.getFirmCity();
		this.firmAdress = firm.getFirmAdress();
		this.firmCountry = firm.getFirmCountry();
		for(Car car : firm.getFirmCars()) {
			this.firmCars_Id.add(car.getId());
		}
		for(User user : firm.getFirmUsers()) {
			this.firmUsers_Id.add(user.getId());
		}
		
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

	public Set<Long> getFirmCars() {
		return firmCars_Id;
	}

	public void setFirmCars(Set<Long> firmCars) {
		this.firmCars_Id = firmCars;
	}

	public List<Long> getFirmUsers() {
		return firmUsers_Id;
	}

	public void setFirmUsers(List<Long> firmUsers) {
		this.firmUsers_Id = firmUsers;
	}

}
