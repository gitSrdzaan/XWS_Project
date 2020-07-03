package xml.team.rentacar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class RentRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "rentAdvert_id")
	private RentAdvert rentAdvert;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User advertSender;
	
	private Date reservationStart;
	
	private Date reservationEnd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bundle_id", nullable = true)
	private RentRequestBundle rentRequestBundle;
	
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
