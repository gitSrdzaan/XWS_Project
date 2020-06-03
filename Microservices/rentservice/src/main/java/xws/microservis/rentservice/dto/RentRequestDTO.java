package xws.microservis.rentservice.dto;

import java.util.Date;


import xws.microservis.rentservice.model.RentAdvert;
import xws.microservis.rentservice.model.RentRequest;
import xws.microservis.rentservice.model.RentRequestStatus;
import xws.microservis.rentservice.model.User;

public class RentRequestDTO {

	private Long id;
	private RentAdvert rentAdvert;
	private User advertSender;
	private Date reservationStart;
	private Date reservationEnd;
	private RentRequestStatus status;
	
	public RentRequestDTO (RentRequest rr) {
		this.id = rr.getId();
		this.advertSender = rr.getAdvertSender();
		this.reservationStart = rr.getReservationStart();
		this.reservationEnd = rr.getReservationEnd();
		this.rentAdvert = rr.getRentAdvert();
		this.status = rr.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RentAdvert getRentAdvert() {
		return rentAdvert;
	}

	public void setRentAdvert(RentAdvert rentAdvert) {
		this.rentAdvert = rentAdvert;
	}

	public User getAdvertSender() {
		return advertSender;
	}

	public void setAdvertSender(User advertSender) {
		this.advertSender = advertSender;
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
