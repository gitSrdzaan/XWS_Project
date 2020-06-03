package xws.microservice.searchservice.dto;

import java.util.List;

import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.CarFuel;
import xws.microservice.searchservice.model.Transmission;

public class CarDTO {
	
	private Long id;
	private String carRegistration;
	private String carMark;
	private String carModel;
	private CarFuel carFuel;
	private Transmission transmission;
	private String carClass;
	private Integer carMileage;//kilometraza do sada
	
	private List<String> carComment;
	
	private Integer carGrade;
	
	private double longitude;
	
	private double latitude;
	
	private Integer kidsSeats;
	
	public CarDTO(Car car) {
		this.id = car.getId();
		this.carRegistration = car.getCarRegistration();
		this.carClass = car.getCarClass();
		this.carMark = car.getCarMark();
		this.carModel = car.getCarModel();
		this.carFuel =car.getCarFuel();
		this.transmission = car.getTransmission();
		this.carMileage = car.getCarMileage();
		this.carComment = car.getCarComment();
		this.carGrade = car.getCarGrade();
		this.longitude = car.getLongitude();
		this.latitude = car.getLatitude();
		this.kidsSeats = car.getKidsSeats();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarRegistration() {
		return carRegistration;
	}

	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
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

	public List<String> getCarComment() {
		return carComment;
	}

	public void setCarComment(List<String> carComment) {
		this.carComment = carComment;
	}

	public Integer getCarGrade() {
		return carGrade;
	}

	public void setCarGrade(Integer carGrade) {
		this.carGrade = carGrade;
	}

	public double getLongitude() {
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
	}

	public Integer getKidsSeats() {
		return kidsSeats;
	}

	public void setKidsSeats(Integer kidsSeats) {
		this.kidsSeats = kidsSeats;
	}
	
	
	

}
