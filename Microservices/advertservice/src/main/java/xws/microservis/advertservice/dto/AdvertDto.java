package xws.microservis.advertservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.model.PriceList;

public class AdvertDto {
	
	private Long id;
	
	private Long carId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SS")
	private Date advertStartDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SS")
	private Date advertEndDate;
	
	private Long priceListId;

	private Double priceForRent;

	private Long owner_id;
	
	public AdvertDto(Long id , Long carId, Date advertStartDate , Date advertEndDate , Long priceListId, Double priceForRent) {
		this.id = id;
		this.advertEndDate = advertEndDate;
		this.advertStartDate = advertStartDate;
		this.carId = carId;
		this.priceListId = priceListId;
		this.priceForRent = priceForRent;
	}

	public AdvertDto() {
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public Long getCarId() {
		return carId;
	}



	public void setCarId(Long carId) {
		this.carId = carId;
	}



	public Long getPriceListId() {
		return priceListId;
	}



	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getPriceForRent() {
		return priceForRent;
	}

	public void setPriceForRent(Double priceForRent) {
		this.priceForRent = priceForRent;
	}
}
