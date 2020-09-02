package xws.microservice.searchservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.PriceList;
import xws.microservice.searchservice.model.RentAdvert;

public class RentAdvertDTO {

	private Long id;
	private Long carId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date advertStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date advertEndDate;
	private Long priceListId;
	private Double priceForRent;

	private Long owner_id;
	
	public RentAdvertDTO(RentAdvert rentAdvert) {
		this.id = rentAdvert.getId();

		this.advertStartDate = rentAdvert.getAdvertStartDate();
		this.advertEndDate = rentAdvert.getAdvertEndDate();

	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public RentAdvertDTO() {
		super();
	}


	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Date getAdvertStartDate() {
		return advertStartDate;
	}

	public void setAdvertStartDate(Date advertStartDate) {
		this.advertStartDate = advertStartDate;
	}

	public Date getAdvertEndDate() {
		return advertEndDate;
	}

	public void setAdvertEndDate(Date advertEndDate) {
		this.advertEndDate = advertEndDate;
	}

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}
}
