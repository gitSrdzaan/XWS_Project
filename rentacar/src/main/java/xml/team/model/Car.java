package xml.team.model;

import javax.persistence.*;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String carRegistration;
	
	@Column(nullable = false)
	private String carMark;
	
	@Column(nullable = false)
	private String carModel;
	
	@Column(nullable = false)
	private CarFuel carFuel;
	
	@Column(nullable = false)
	private Transmission transmission;
	
	@Column(nullable = false)
	private String carClass;
	
	@Column(nullable = false)
	private Integer carMileage;//kilometraza do sada
	
	@Column(nullable = false)
	private String carComment;
	
	@Column(nullable = false)
	private Integer carGrade;
	
	
	//Cjenovnik
	
	@Column(nullable = false)
	private Integer kidsSeats;
	
	//Slika automobila
	
	
	
	
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

	public String getCarComment() {
		return carComment;
	}

	public void setCarComment(String carComment) {
		this.carComment = carComment;
	}

	public Integer getCarGrade() {
		return carGrade;
	}

	public void setCarGrade(Integer carGrade) {
		this.carGrade = carGrade;
	}
	
}
