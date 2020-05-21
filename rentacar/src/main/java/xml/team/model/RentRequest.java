package xml.team.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class RentRequest {

	private RentAdvert rentAdvert;
	
	private User advertSender;
	
	private Date reservationStart;
	
	private Date reservationEnd;
	
	
	public RentRequest() {
		
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
	
	
}
