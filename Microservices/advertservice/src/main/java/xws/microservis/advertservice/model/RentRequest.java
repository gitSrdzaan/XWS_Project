package xws.microservis.advertservice.model;



import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "rent_request")
public class RentRequest {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentAdvert_id")
    private RentAdvert rentAdvert;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User advertSender;

    @Column
    private Date reservationStart;
    @Column
    private Date reservationEnd;

    @Column
    private RentRequestStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bundle_id", nullable = true)
    private RentRequestBundle rentRequestBundle;



    public RentRequest() {

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

    public RentRequestBundle getRentRequestBundle() {
        return rentRequestBundle;
    }

    public void setRentRequestBundle(RentRequestBundle rentRequestBundle) {
        this.rentRequestBundle = rentRequestBundle;
    }
}
