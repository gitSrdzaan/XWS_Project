package xws.microservis.advertservice.dto;

import java.util.List;

public class CarDTO {

    private Long id;
    private String carRegistration;
    private String carMark;
    private String carModel;
    private Long carFuel;
    private Long transmission;
    private String carClass;
    private Integer carMileage;//kilometraza do sada
    private Integer maxAllowedMileage;
    private List<String> carComment;
    private Integer carGrade;

	/*private double longitude;

	private double latitude;*/

    private Integer kidsSeats;




    private Long owner_id;

    public CarDTO(){

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

    public Long getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(Long carFuel) {
        this.carFuel = carFuel;
    }

    public Long getTransmission() {
        return transmission;
    }

    public void setTransmission(Long transmission) {
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

    public Integer getMaxAllowedMileage() {
        return maxAllowedMileage;
    }

    public void setMaxAllowedMileage(Integer maxAllowedMileage) {
        this.maxAllowedMileage = maxAllowedMileage;
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

    public Integer getKidsSeats() {
        return kidsSeats;
    }

    public void setKidsSeats(Integer kidsSeats) {
        this.kidsSeats = kidsSeats;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }
}
