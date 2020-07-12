package xws.microservice.soapservice.model;

import javax.persistence.*;


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
	
	@Column(nullable = false)
	private String carClass;
	
	@Column(nullable = false)
	private String carFuel;
	
	@Column(nullable = false)
	private String transmission;
	
	@Column(nullable = true)
	private Integer carMileage;//kilometraza do sada
	
   /* *
   TODO: make COMMENT CLASS and connect to car @OneToMany
	*/

	@Column(nullable = true)
	private Integer carGrade;
	/*
	private double longitude;
	
	private double latitude;
	*/
	//Cjenovnik
	
	@Column(nullable = true)
	private Integer kidsSeats;
	
	//Slika automobila

	@Column(nullable = true)
	private String owner;
	
	
	public Car() {
		
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public String getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
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
/*
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
	*/
}
