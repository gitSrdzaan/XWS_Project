package xws.microservis.advertservice.model;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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

	@Column(nullable = true)
	private String owner;
	
	//Slika automobila


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@Column
	private Long monolitID;
	
	
	public Car() {
		
	}

	public Car(com.baeldung.springsoap.gen.Car car){
		this.carRegistration = car.getCarRegistration();
		this.carMark = car.getCarMark();
		this.carModel = car.getCarModel();
		this.carClass = car.getCarClass();
		this.carMileage = car.getCarMileage();
		this.carGrade = car.getCarGrade();
		this.kidsSeats = car.getKidsSeats();
		this.owner = car.getOwner();
	}

	public Long getMonolitID() {
		return monolitID;
	}

	public void setMonolitID(Long monolitID) {
		this.monolitID = monolitID;
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
