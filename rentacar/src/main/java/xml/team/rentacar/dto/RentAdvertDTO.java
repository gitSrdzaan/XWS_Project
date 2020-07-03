package xml.team.rentacar.dto;

import java.util.Date;

public class RentAdvertDTO {

	private CarDTO carDTO;
	private Date advertStartDate;
	private Date advertEndDate;
	private PriceListDTO priceListDTO;
	
	public RentAdvertDTO() {
		
	}

	public CarDTO getCarDTO() {
		return carDTO;
	}

	public void setCarDTO(CarDTO carDTO) {
		this.carDTO = carDTO;
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

	public PriceListDTO getPriceListDTO() {
		return priceListDTO;
	}

	public void setPriceListDTO(PriceListDTO priceListDTO) {
		this.priceListDTO = priceListDTO;
	}
	
	
	
}
