package xws.microservis.rentservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import xws.microservis.rentservice.dto.CarDTO;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String carRegistration;
	
	@Column(nullable = false)
	private String carMark;
	
	@Column(nullable = false)
	private String carModel;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carfuel_id")
	private CarFuel carFuel;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transmission_id")
	private Transmission transmission;
	
	@Column(nullable = false)
	private String carClass;
	
	@Column(nullable = true)
	private Integer carMileage;//kilometraza do sada

	@Column(nullable = true)
	private Integer maxAllowedMileage;
	
	@Column(nullable = true)
	@ElementCollection(targetClass = String.class)
	private List<String> carComment;
	
	@Column(nullable = true)
	private Integer carGrade;
	
	/*private double longitude;
	
	private double latitude;*/

	@Column(nullable = true)
	private Integer kidsSeats;
	
	//Slika automobila
	
	/**
	 * TODO: veza firme i auta da se obezbjedi
	 * */
	@ManyToOne
	@JoinColumn(name = "firm_id")
	private Firm firm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	public Car() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarMark() {
		return carMark;
	}

	public void setCarMark(String carMark) {
		this.carMark = carMark;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public CarFuel getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(CarFuel carFuel) {
		this.carFuel = carFuel;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public List<String> getCarComment() {
		return carComment;
	}

	public void setCarComment(List<String> carComment) {
		this.carComment = carComment;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public Integer getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(Integer carMileage) {
		this.carMileage = carMileage;
	}

	public Integer getKidsSeats() {
		return kidsSeats;
	}

	public void setKidsSeats(Integer kidsSeats) {
		this.kidsSeats = kidsSeats;
	}

	public String getCarRegistration() {
		return carRegistration;
	}

	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}


	public Integer getCarGrade() {
		return carGrade;
	}

	public void setCarGrade(Integer carGrade) {
		this.carGrade = carGrade;
	}

	/*public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}*/
	
	public Car createFromDTO(CarDTO carDTO) {
		
		this.id = carDTO.getId();
		this.carClass = carDTO.getCarClass();
		this.carComment = carDTO.getCarComment();
		//this.carFuel = carDTO.getCarFuel()el();
		this.carGrade = carDTO.getCarGrade();
		this.carMark = carDTO.getCarMark();
		this.carMileage = carDTO.getCarMileage();
		this.carRegistration = carDTO.getCarRegistration();
		this.kidsSeats = carDTO.getKidsSeats();
		//this.transmission = carDTO.getTransmission();
		/*this.latitude = carDTO.getLatitude();
		this.longitude = carDTO.getLongitude();*/
		this.carModel = carDTO.getCarModel();
		
		
		return this;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getMaxAllowedMileage() {
		return maxAllowedMileage;
	}

	public void setMaxAllowedMileage(Integer maxAllowedMileage) {
		this.maxAllowedMileage = maxAllowedMileage;
	}
}
