package xml.team.rentacar.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class RentRequest {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "rentAdvert_id")
	private RentAdvert rentAdvert;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User advertSender;

	@Column
	private Date reservationStart;
	@Column
	private Date reservationEnd;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bundle_id", nullable = true)
	private RentRequestBundle rentRequestBundle;

	@Column(name = "status")
	private RentRequestStatus status;
	
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

	public RentRequestStatus getStatus() {
		return status;
	}

	public void setStatus(RentRequestStatus status) {
		this.status = status;
	}
	
}
