package xws.microservice.searchservice.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import javax.persistence.*;

@Entity
public class Car {

	@Id
	@GenericGenerator(name = "car_seq",strategy = "sequence", parameters ={
			@org.hibernate.annotations.Parameter(name = "car_seq_name", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
			@org.hibernate.annotations.Parameter(name = "initial_value", value = "500"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "100")
	})
	@GeneratedValue(generator = "car_seq",strategy = GenerationType.SEQUENCE)
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
	
	@Column(nullable = false)
	private Integer carMileage;//kilometraza do sada

	@Column(nullable = true)
	private Integer maxAllowedMileage;
	
	@Column(nullable = true)
	@ElementCollection(targetClass = String.class)
	private List<String> carComment;
	
	@Column(nullable = true)
	private Integer carGrade;

	/*@Column(nullable = true)
	private double longitude;
	@Column(nullable = true)
	private double latitude;*/
	
	//Cjenovnik
	
	@Column(nullable = false)
	private Integer kidsSeats;
	
	//Slika automobila

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firm_id")
    private Firm firm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;*/

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private Owner owner;




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

	public Integer getMaxAllowedMileage() {
		return maxAllowedMileage;
	}

	public void setMaxAllowedMileage(Integer maxAllowedMileage) {
		this.maxAllowedMileage = maxAllowedMileage;
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
	}*/
	/*public Firm getFirm() {
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
	}*/

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
