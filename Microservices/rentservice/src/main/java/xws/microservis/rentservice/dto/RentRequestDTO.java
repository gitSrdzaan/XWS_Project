package xws.microservis.rentservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import xws.microservis.rentservice.model.RentRequest;
import xws.microservis.rentservice.model.RentRequestStatus;

public class RentRequestDTO {

	private Long id;
	private Long rentAdvert_Id;
	private Long advertSender_Id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date reservationStart;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date reservationEnd;
	private RentRequestStatus status;
	
	public RentRequestDTO (RentRequest rr) {
		this.id = rr.getId();
		this.advertSender_Id = rr.getAdvertSender().getId();
		this.reservationStart = rr.getReservationStart();
		this.reservationEnd = rr.getReservationEnd();
		this.rentAdvert_Id = rr.getRentAdvert().getId();
		this.status = rr.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getRentAdvert_Id() {
		return rentAdvert_Id;
	}

	public void setRentAdvert_Id(Long rentAdvert_Id) {
		this.rentAdvert_Id = rentAdvert_Id;
	}

	public Long getAdvertSender_Id() {
		return advertSender_Id;
	}

	public void setAdvertSender_Id(Long advertSender_Id) {
		this.advertSender_Id = advertSender_Id;
	}

	public Date getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(Date reservationStart) {
		this.reservationStart = reservationStart;
	}

	public Date getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(Date reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public RentRequestStatus getStatus() {
		return status;
	}

	public void setStatus(RentRequestStatus status) {
		this.status = status;
	}
	
	
}
